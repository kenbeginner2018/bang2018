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

import dao.Select_DAO;
import dao.ShopDB_DAO;
import model.GoodsBean;
/**
 * Servlet implementation class Serch
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		HttpSession session = request.getSession();

		if(title == null) {
			ShopDB_DAO shopDB = new ShopDB_DAO();
			List <GoodsBean>  shopList =  shopDB.findAll();
			session.setAttribute("shopList",shopList );

		}else {

			Select_DAO select_DAO = new Select_DAO();
			List <GoodsBean>  shopList = select_DAO.findAll(title);
			session.setAttribute("shopList",shopList );
		}





		RequestDispatcher dispatcher = request.getRequestDispatcher("/form");
		dispatcher.forward(request, response);



		//カート関連


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}