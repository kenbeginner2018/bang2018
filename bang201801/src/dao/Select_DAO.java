package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GoodsBean;

public class Select_DAO {
	public List<GoodsBean>findAll(String title){

		Connection conn = null;
		List <GoodsBean> shopList = new ArrayList<>();

		try {
			//jdbc読み込み

			Class.forName("com.mysql.jdbc.Driver");

			//データベースへ接続

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_database?serverTimezone=JST", "root", "root");

			//SELECT文を準備
			String sql = " select goods_id, disc_name, goods_creater, goods_price, dgenre_name, goods_name from goods join dvd on goods.dgenre_id = dvd.dgenre_id join disc on goods.disc_id = disc.disc_id  WHERE goods_name LIKE ?;";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,"%"+title+"%");


			//SELECTを実行し、結果表（ResultSetを取得

			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコード内容を表示

			while (rs.next()) {

				int goodsId = rs.getInt("goods_id");
				String creater = rs.getString("goods_creater");
				String dGenreName = rs.getString("dgenre_name");
				String discName = rs.getString("disc_name");
				String  goodsName = rs.getString("goods_name");
				int price = rs.getInt("goods_price");

				//結果表に格納されたレコード内容を
				//Employeeインスタンスに設定し、ArrayList インスタンスに追加


				GoodsBean goods = new GoodsBean(goodsId, goodsName,  creater,  dGenreName, discName, price);
				shopList.add(goods);



			}



		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handlconne exception
					e.printStackTrace();
					return null;
				}
			}

		}

		return shopList;
	}


}
