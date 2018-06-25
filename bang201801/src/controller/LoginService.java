package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Custemer_DAO;
import model.AccountBean;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/login")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		boolean decision ;




		Custemer_DAO custemerDB = new Custemer_DAO();
		AccountBean  account =  custemerDB.findAll(id,pass);
        System.out.println(account);

		//ログイン処理

			if(account.getCustomer_passward().equals(pass)) {
				decision = true;
			}else {
				decision = false;
			}


		//ログイン処理成功時
		if (decision) {
			//ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("account",account );


		}



		//ログイン結果画面にフォワード

		if(decision == false) {
			//リダイレクト
			response.sendRedirect("/WEB-INF/login.jsp");


		}else {
			//フォーワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Search");
			dispatcher.forward(request, response);


		}
	}
}