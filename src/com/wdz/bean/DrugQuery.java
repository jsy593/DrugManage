package com.wdz.bean;

public class DrugQuery {
	private int did;
	private String dname;
	private String price1;
	private String price2;
	private String type;

	public int getDid() {
		return this.did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getPrice1() {
		return this.price1;
	}

	public String getPrice2() {
		return this.price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DrugQuery(String dname, String price1, String price2, String type) {
		this.dname = dname;
		this.price1 = price1;
		this.price2 = price2;
		this.type = type;
	}

	public DrugQuery() {
	}
}