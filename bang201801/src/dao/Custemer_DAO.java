package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBean;
import model.Customer;

public class Custemer_DAO {
	public AccountBean findAll(Customer customer){
		Connection conn = null;
		AccountBean account = null;
		try {
			//jdbc読み込み

			Class.forName("com.mysql.jdbc.Driver");

			//データベースへ接続

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_database?serverTimezone=JST", "root", "root");

			//SELECT文を準備
			String sql = "SELECT * FROM customers WHERE customer_id = ? AND customer_passward = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,customer.getId());
			pStmt.setString(2,customer.getPass());


			//SELECTを実行し、結果表（ResultSetを取得

			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコード内容を表示

			while (rs.next()) {

				String customer_id = rs.getString("customer_id");
				String customer_name = rs.getString("customer_name");
				String customer_kana = rs.getString("customer_kana");
				String customer_birthday  = rs.getString("customer_birthday");
				String customer_tel  = rs.getString("customer_tel");
				String customer_passward  = rs.getString("customer_passward");

				//結果表に格納されたレコード内容を
				//Employeeインスタンスに設定し、ArrayList インスタンスに追加
				 account = new AccountBean(customer_id,customer_name,customer_kana,customer_birthday,customer_tel,customer_passward);

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

		return account;
	}

}
