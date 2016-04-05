package com.wdz.dao;

import com.wdz.bean.DrugBean;
import com.wdz.util.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Addinfo {
	JdbcTemplate jt;

	public Addinfo() {
		this.jt = new JdbcTemplate();
	}

	public boolean addinfo(DrugBean db) {
		String sql = "insert into drug_tb(dname,guige,price,effect,type,factory,date,indate,anumber)values(?,?,?,?,?,?,?,?,?)";
		List list = new ArrayList();
		list.add(db.getDname());
		list.add(db.getGuige());
		list.add(db.getPrice());
		list.add(db.getEffect());
		list.add(db.getType());
		list.add(db.getFactory());
		list.add(db.getDate());
		list.add(db.getIndate());
		list.add(db.getAnumber());

		boolean isok = false;
		try {
			isok = this.jt.updateData(sql, list);
			this.jt.myCommit();
		} catch (Exception e) {
			this.jt.myRollback();
		}
		return isok;
	}

	public List getdruginfo1(Integer did) throws SQLException {
		String sql = "select * from drug_tb where did=" + did;
		ResultSet rs = this.jt.query(sql);
		List list = new ArrayList();
		if (rs.next()) {
			DrugBean db = new DrugBean(rs.getInt(1), rs.getString(2), rs
					.getString(3), rs.getString(4), rs.getString(5), rs
					.getString(6), rs.getString(7), rs.getString(8), rs
					.getString(9), rs.getString(10));
			list.add(db);
		}
		this.jt.closeRes();
		return list;
	}

	public boolean update(String did, String dname, String guige, String price,
			String effect) {
		String sql = "update drug_tb set dname='" + dname + "',guige='" + guige
				+ "'," + "price='" + price + "',effect='" + effect
				+ "' where did='" + did + "'";
		boolean isok = false;
		try {
			isok = this.jt.updateData(sql);
			this.jt.myCommit();
		} catch (Exception e) {
			this.jt.myRollback();
		}
		return isok;
	}

	public boolean delete(String did) {
		String sql = "delete from drug_tb where did='" + did + "'";
		boolean isok = false;
		isok = this.jt.updateData(sql);
		this.jt.myCommit();
		return isok;
	}
}