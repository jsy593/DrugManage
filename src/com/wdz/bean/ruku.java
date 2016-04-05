package com.wdz.bean;

public class ruku {
	private int rid;
	private String did;
	private String dname;
	private String rnumber;
	private String year;
	private String mouth;
	private String day;
	private String uname;

	public int getRid() {
		return this.rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getRnumber() {
		return this.rnumber;
	}

	public void setRnumber(String rnumber) {
		this.rnumber = rnumber;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMouth() {
		return this.mouth;
	}

	public void setMouth(String mouth) {
		this.mouth = mouth;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public ruku(int rid, String did, String dname, String rnumber,
			String uname, String year, String mouth, String day) {
		this.rid = rid;
		this.did = did;
		this.dname = dname;
		this.rnumber = rnumber;
		this.uname = uname;
		this.year = year;
		this.mouth = mouth;
		this.day = day;
	}

	public ruku() {
	}
}