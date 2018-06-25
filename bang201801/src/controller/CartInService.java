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
 * Servlet implementation class CartInService
 */
@WebServlet("/shop")
public class CartInService extends HttpServlet {
	private static final long serialVersionUID = 1L;


			public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");

				HttpSession session = request.getSession(false);
				ArrayList<String> cart = null;
				if(session != null) {
					cart = (ArrayList<String>)session.getAttribute("cart");
				}

				String message;
				if(cart != null && !cart.isEmpty()){
					message = "カートに" + cart.size() + "個の商品が入っています";
				} else {
					message = "商品を選んでください";
				}
				request.setAttribute("message", message);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/seafood_form.jsp");
				dispatcher.forward(request, response);
			}

			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");

				String itemNo = request.getParameter("itemNo");
				String clear = request.getParameter("clear");
				HttpSession session = request.getSession(true);

				String message;
				if(clear != null){
					session.invalidate();
					message = "カートを空にしました";
				} else {
					ArrayList<String> cart = (ArrayList<String>)session.getAttribute("cart");
					if(cart == null){
						cart = new ArrayList<>();
						session.setAttribute("cart", cart);
					}

					if(itemNo != null){
						cart.add(itemNo);
					}

					message = "カートに" + cart.size() + "個の商品が入っています";
				}
				request.setAttribute("message", message);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/seafood_form.jsp");
				dispatcher.forward(request, response);
			}
		}
