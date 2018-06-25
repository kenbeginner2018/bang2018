package model;

public class CartBean {
	private int goodsId;
	private String goodsName;
	private String creater;
	private int price;
	private int stock;

	public CartBean(int goodsId,String goodsName,String creater,int price, int stock) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.creater = creater;
		this.price = price;
		this.stock = stock;

	}




	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

}
