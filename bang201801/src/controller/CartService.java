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
 * Servlet implementation class CartService
 */
@WebServlet("/cart")
public class CartService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String itemNo = request.getParameter("itemNo");



		HttpSession session = request.getSession();
		List <GoodsBean>shopList = (List <GoodsBean>)session.getAttribute("shopList");
		List<GoodsBean>cartList =(List <GoodsBean>)session.getAttribute("cartList");
		if(cartList==null) {
			cartList = new ArrayList<>();
		}
		if(itemNo != null) {
		int index = Integer.parseInt(itemNo);
		cartList.add(shopList.get(index-1));

		}


		session.setAttribute("cartList", cartList);
		String message;
		message = "カートに" +cartList.size()+ "個の商品が入っています";
		request.setAttribute("message", message);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String clear = request.getParameter("clear");
		HttpSession session = request.getSession();
		System.out.println(clear);
		if(clear != null){
			session.removeAttribute("cartList");
			String message = "カートに商品はありません";
			request.setAttribute("message", message);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cartEmpty.jsp");
		dispatcher.forward(request, response);
	}



}
