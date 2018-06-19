package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.GoodsBean;
import controller.IdSearch;

public class ShopDB {

	public List<GoodsBean>findAll(){

		Connection conn = null;
		List <GoodsBean> shopList = new ArrayList<>();

		try {
			//jdbc読み込み

			Class.forName("com.mysql.jdbc.Driver");

			//データベースへ接続

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_database", "root", "root");

			//SELECT文を準備
			String sql = "SELECT * FROM goods ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行し、結果表（ResultSetを取得

			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコード内容を表示

			while (rs.next()) {

				int goodsId = rs.getInt("goodsId");
				String goodsName = rs.getString("goodsName");
				String creater = rs.getString("creater");
				int price  = rs.getInt("price");
				int stock  = rs.getInt("stock");
				int dvdGenreId  = rs.getInt("dvdGenreId");
				int cdGenreId  = rs.getInt("cdGenreId");
				int discId  = rs.getInt("discId");

				//結果表に格納されたレコード内容を
				//Employeeインスタンスに設定し、ArrayList インスタンスに追加


				GoodsBean goods = new GoodsBean(goodsId,goodsName, creater, price, stock,
						 dvdGenreId, cdGenreId,discId);
				shopList.add(goods);

			}


			//キーワード受け取り
		GoodsBean getGoodsDataByName(String goodsName) throws SQLException {
			GoodsBean bean = null;
			PreparedStatement pstatement = null;
			ResultSet rs = null;
			try {
				// SQLを保持するPreparedStatementオブジェクトの生成
				String sql = "SELECT * FROM goods WHERE goods_name= ?";
				pstatement = connection.prepareStatement(sql);
				// INパラメーターの設定
				pstatement.setString(1, goodsName);
				// SQLの発行し、抽出結果が格納されたResultSetオブジェクトを取得
				rs = pstatement.executeQuery();
				if (rs.next()) {
					// 列名を指定してResultSetオブジェクトから値を取得
					int goodsId = rs.getInt("goodsId");
					String goodsName = rs.getString("goodsName");
					String creater = rs.getString("creater");
					int price  = rs.getInt("price");
					int stock  = rs.getInt("stock");
					int dvdGenreId  = rs.getInt("dvdGenreId");
					int cdGenreId  = rs.getInt("cdGenreId");
					int discId  = rs.getInt("discId");
				}
				// ResultSetオブジェクトの解放
				rs.close();
			} finally {
				// PreparedStatementオブジェクトの解放
				pstatement.close();
			}
			return bean;
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
