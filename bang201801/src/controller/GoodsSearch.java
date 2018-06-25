package controller;
	import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ShopDB_DAO;
import model.GoodsBean;


public class GoodsSearch {
	public void execute(HttpServletRequest request) throws Exception {
		ShopDB_DAO daoShop = null;
		String goodsName = request.getParameter("keyword");
		try {
			if (goodsName != null && !goodsName.isEmpty()) {
				daoShop = new ShopDB_DAO();
				GoodsBean goodsBean = daoShop.getGoodsDataByName(goodsName);
				if (daoShop != null) {
					ArrayList<GoodsBean> goodsList = new ArrayList<GoodsBean>();
					goodsList.add(goodsBean);
					request.setAttribute("goodsList", goodsList);
				} else {
					request.setAttribute("message", "該当商品はありません");
				}
			} else {
				request.setAttribute("message", "検索商品名を入力してください");
			}
		} finally {
			if (daoShop != null) {
				daoShop.close();
			}
		}
	}
}
