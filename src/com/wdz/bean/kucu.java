package com.wdz.bean;

public class kucu {
	private int kid;
	private int did;
	private String dname;
	private int knumber;

	public int getKid() {
		return this.kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

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

	public int getKnumber() {
		return this.knumber;
	}

	public void setKnumber(int knumber) {
		this.knumber = knumber;
	}

	public kucu(int kid, int did, String dname, int knumber) {
		this.kid = kid;
		this.did = did;
		this.dname = dname;
		this.knumber = knumber;
	}

	public kucu() {
	}
}