package model;

import java.io.Serializable;

public class Customer implements Serializable{

	private String id;
	private String pass;

	public  Customer() {}

	public Customer(String id,String pass) {
		this.id = id;//ユーザーID
		this.pass = pass;//パスワード

	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

}
