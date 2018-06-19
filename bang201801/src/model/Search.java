package model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShopDB_DAO;
import model.GoodsBean;
/**
 * Servlet implementation class Serch
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ShopDB_DAO shopDB = new ShopDB_DAO();
		List <GoodsBean>  shopList =  shopDB.findAll();
		System.out.println(shopList);

		HttpSession session = request.getSession();
		session.setAttribute("shopList",shopList );

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Main.jsp");
		dispatcher.forward(request, response);


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
