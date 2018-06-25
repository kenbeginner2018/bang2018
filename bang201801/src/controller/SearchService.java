package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GoodsBean;
/**
 * Servlet implementation class SeafoodFormServlet
 */
@WebServlet("/form")
public class SearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<GoodsBean>cartList =(List <GoodsBean>)session.getAttribute("cartList");



		String message;
		if(cartList != null && !cartList.isEmpty()){
			message = "カートに" + cartList.size() + "個の商品が入っています";
		} else {
			message = "商品を選んでください";
		}
		request.setAttribute("message", message);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String clear = request.getParameter("clear");
		HttpSession session = request.getSession(true);

		String message;
		if(clear != null){
			session.removeAttribute("cartList");
			message = "カートを空にしました";
		} else {
			ArrayList<String> cartList = (ArrayList<String>)session.getAttribute("cartList");
			if(cartList == null){
				cartList = new ArrayList<>();
				session.setAttribute("cartList", cartList);

			}



			message = "カートに" + cartList.size() + "個の商品が入っています";
		}
		request.setAttribute("message", message);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main.jsp");
		dispatcher.forward(request, response);
	}
}
