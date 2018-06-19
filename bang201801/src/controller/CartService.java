package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



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

		request.setCaracterEncording("UTF-8");

		HttpSession session = request.getSession(false);
		ArrayList<String> cart = null;


		//商品の合計金額算出→messageに代入
		if(session != null) {
			cart = (ArrayList<String>)session.getAttribute("cart");
		}

		String message;

		//カート内に商品がある場合
		if(cart != null && !cart.isEmpty()) {
			int total = 0;
			for(String itemNo : cart) {
				int index = Integer.paeseInt(ItemNo);
				total += ******カート内の全商品******;
			}
			message = "合計は ￥ " + total + " になります";
		}else {
		//カート内が空の場合
			message = "カートに商品がありません";
		}
		request.setAttribute("message", message);

		//リクエストディスパッチャーを取得
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("***会計画面①****");
		//指定したJSPへと転送
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String paramIndex = request.getParameter("Index");
		HttpSession session = request.getSession(false);
		ArrayList<String> cart = null;
		if(session != null) {
			cart = (ArrayList<String>)session.getAttribute("cart");
		}

		if(cart != null && paramIndex != null) {
			int index Integer.parseInt(paramIndex);
			cart.remove(index);
		}
		doGet(request, response);
	}

}
