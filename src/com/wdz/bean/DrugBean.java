package com.wdz.bean;

public class DrugBean {
	private int did;
	private String dname;
	private String guige;
	private String price;
	private String effect;
	private String type;
	private String factory;
	private String date;
	private String indate;
	private String anumber;

	public int getDid() {
		return this.did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getGuige() {
		return this.guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFactory() {
		return this.factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIndate() {
		return this.indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getAnumber() {
		return this.anumber;
	}

	public void setAnumber(String anumber) {
		this.anumber = anumber;
	}

	public DrugBean(int did, String dname, String guige, String price,
			String effect, String type, String factory, String date,
			String indate, String anumber) {
		this.did = did;
		this.dname = dname;
		this.guige = guige;
		this.price = price;
		this.effect = effect;
		this.type = type;
		this.factory = factory;
		this.date = date;
		this.indate = indate;
		this.anumber = anumber;
	}

	public DrugBean() {
	}
}
