package com.wdz.bean;

public class cuku {
	private int cid;
	private String did;
	private String dname;
	private String cnumber;
	private String uname;
	private String cyear;
	private String cmouth;
	private String cday;

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getCnumber() {
		return this.cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public cuku(int cid, String did, String dname, String cnumber,
			String uname, String cyear, String cmouth, String cday) {
		this.cid = cid;
		this.did = did;
		this.dname = dname;
		this.cnumber = cnumber;
		this.uname = uname;
		this.cyear = cyear;
		this.cmouth = cmouth;
		this.cday = cday;
	}

	public String getCyear() {
		return this.cyear;
	}

	public void setCyear(String cyear) {
		this.cyear = cyear;
	}

	public String getCmouth() {
		return this.cmouth;
	}

	public void setCmouth(String cmouth) {
		this.cmouth = cmouth;
	}

	public String getCday() {
		return this.cday;
	}

	public void setCday(String cday) {
		this.cday = cday;
	}

	public cuku() {
	}
}