package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/login")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		boolean decision ;

		Customer customer = new Customer(id,pass);

		//ログイン処理

			if(customer.getPass().equals("1234")) {
				decision = true;
			}else {
				decision = false;
			}

		HttpSession session = request.getSession();
		//ログイン処理成功時
		if (decision) {
			//ユーザー情報をセッションスコープに保存

			session.setAttribute("loginUser",customer );


		}

		Customer loginUser = (Customer)session.getAttribute("loginUser");

		//ログイン結果画面にフォワード

		if(loginUser == null) {
			//リダイレクト
			response.sendRedirect("/bang201801/");


		}else {
			//フォーワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Search");
			dispatcher.forward(request, response);


		}
	}
}