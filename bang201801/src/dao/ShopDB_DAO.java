package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GoodsBean;

public class ShopDB_DAO {

	public List<GoodsBean>findAll(){

		Connection conn = null;
		List <GoodsBean> shopList = new ArrayList<>();

		try {
			//jdbc読み込み

			Class.forName("com.mysql.jdbc.Driver");

			//データベースへ接続

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_database?serverTimezone=JST", "root", "root");

			//SELECT文を準備
			String sql = "SELECT * FROM goods ";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			//SELECTを実行し、結果表（ResultSetを取得

			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコード内容を表示

			while (rs.next()) {

				int goodsId = rs.getInt("goods_id");
				String goodsName = rs.getString("goods_name");
				String creater = rs.getString("goods_creater");
				int price  = rs.getInt("goods_price");
				int stock  = rs.getInt("goods_stock");
				//int dvdGenreId  = rs.getInt("goods_dvdGenreId");
				//int cdGenreId  = rs.getInt("goods_cdGenreId");
				//int discId  = rs.getInt("goods_discId");

				//結果表に格納されたレコード内容を
				//Employeeインスタンスに設定し、ArrayList インスタンスに追加


				GoodsBean goods = new GoodsBean(goodsId,goodsName, creater, price, stock);
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
