package model;

import java.io.Serializable;


public class GoodsBean implements Serializable{

	private int goodsId;
	private String goodsName;
	private String creater;
	private int price;
	private int stock;
	private String discName;
	private String cGenreName;
	private String dGenreName;

	public GoodsBean(int goodsId,String goodsName, String creater, int price,int stock,
			String discName, String cGenreName, String dGenreName) {
			this.goodsId = goodsId;
			this.goodsName = goodsName;
			this.creater = creater;
			this.price = price;
			this.stock = stock;
			this.discName = discName;
			this.cGenreName = cGenreName;
			this.dGenreName = dGenreName;

		}


		public int getGoodsId() {
			return goodsId;
		}

		public String getGoodsName() {
			return goodsName;
		}

		public String getCreater() {
			return creater;
		}

		public int getPrice() {
			return price;
		}

		public int getStock() {
			return stock;
		}

		public String getDiscName() {
			return discName;
		}

		public String getcGenreName() {
			return cGenreName;
		}

		public String getdGenreName() {
			return dGenreName;
		}



}
