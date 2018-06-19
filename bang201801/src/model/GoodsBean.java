package model;

import java.io.Serializable;


public class GoodsBean implements Serializable{

	private int goodsId;
	private String goodsName;
	private String creater;
	private int price;
	private int stock;
	private int dvdGenreId;
	private int cdGenreId;
	private int discId;

	public GoodsBean() {}

	public GoodsBean(int goodsId,String goodsName, String creater, int price,int stock,
			int dvdGenreId, int cdGenreId,int discId) {
			this.goodsId = goodsId;
			this.goodsName = goodsName;
			this.creater = creater;
			this.price = price;
			this.stock = stock;
			this.dvdGenreId = dvdGenreId;
			this.cdGenreId = cdGenreId;
			this.discId = discId;

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
		public int getDvdGenreId() {
			return dvdGenreId;
		}
		public int getCdGenreId() {
			return cdGenreId;
		}
		public int getDiscId() {
			return discId;
		}



}
