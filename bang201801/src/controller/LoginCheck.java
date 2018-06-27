package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBean;
import model.GoodsBean;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AccountBean account = (AccountBean)session.getAttribute("account");
		List<GoodsBean>cartList =(List <GoodsBean>)session.getAttribute("cartList");
		if(cartList.size()==0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cartEmpty.jsp");
			dispatcher.forward(request, response);

		}else if(account == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginCheck.jsp");
			dispatcher.forward(request, response);
		}else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/cash.jsp");
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
