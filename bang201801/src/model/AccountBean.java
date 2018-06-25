package model;



public class AccountBean {
	private String customer_id;
	private String customer_name;
	private String customer_kana;
	private String customer_birthday;
	private String customer_tel;
	private String customer_passward;



	public AccountBean(String customer_id,String customer_name,String  customer_kana, String customer_birthday,String customer_tel,String customer_passward){
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_kana = customer_kana;
		this.customer_birthday = customer_birthday;
		this.customer_tel = customer_tel;
		this.customer_passward = customer_passward;

	};


	public String getCustomer_id() {
		return customer_id;
	}
	public String getCustomer_tel() {
		return customer_tel;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public String getCustomer_kana() {
		return customer_kana;
	}
	public String getCustomer_birthday() {
		return customer_birthday;
	}
	public String getCustomer_passward() {
		return customer_passward;
	}

}
