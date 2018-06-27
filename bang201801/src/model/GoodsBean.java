package model;

public class GoodsBean {

	private int goodsId;
	private String goodsName;
	private String creater;
	private String dGenreName;
	private String discName;
	private int price;

	public GoodsBean(int goodsId,String goodsName, String creater, String dGenreName,String discName, int price) {
			this.goodsId = goodsId;
			this.goodsName = goodsName;
			this.creater = creater;
			this.dGenreName = dGenreName;
			this.discName = discName;
			this.price = price;

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





	public String getdGenreName() {
		return dGenreName;
	}



	public String getDiscName() {
		return discName;
	}





	public int getPrice() {
		return price;
	}










}

