package com.wdz.bean;

public class RukuQuery {
	private String dname;
	private String year;
	private String mouth;
	private String day;

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
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

	public RukuQuery(String dname, String year, String mouth, String day) {
		this.dname = dname;
		this.year = year;
		this.mouth = mouth;
		this.day = day;
	}

	public RukuQuery() {
	}

	public RukuQuery(String dname) {
		this.dname = dname;
	}
}