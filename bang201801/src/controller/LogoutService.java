package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBean;

/**
 * Servlet implementation class LogoutService
 */
@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AccountBean account = (AccountBean)session.getAttribute("account");

		if (account==null) {
			//ログアウト後にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginCheck.jsp");
			dispatcher.forward(request, response);


		}else {
			//セッションスコープに破棄

			session.invalidate();

			//ログアウト後にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/logout.jsp");
			dispatcher.forward(request, response);


		}


	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
