package com.wdz.dao;

import com.wdz.bean.RukuQuery;
import com.wdz.bean.cuku;
import com.wdz.bean.kucu;
import com.wdz.util.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CukuDao {
	JdbcTemplate jt;

	public CukuDao() {
		this.jt = new JdbcTemplate();
	}

	public List getinfo(int nowPage, int pageNumber, RukuQuery rq)
			throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from cuku_tb where 1=1");
		if (rq != null) {
			if ((rq.getDname() != null) && (!"".equals(rq.getDname()))) {
				sql.append(" and dname like '%" + rq.getDname() + "%'");
			}
			if ((rq.getYear() != null) && (!"".equals(rq.getYear()))) {
				sql.append(" and cyear='" + rq.getYear() + "'");
			}
			if ((rq.getMouth() != null) && (!"".equals(rq.getMouth()))) {
				sql.append(" and cmouth= '" + rq.getMouth() + "'");
			}
			if ((rq.getDay() != null) && (!"".equals(rq.getDay()))) {
				sql.append(" and cday= '" + rq.getDay() + "'");
			}
		}
		sql.append(" limit " + (nowPage - 1) * pageNumber + "," + pageNumber);

		ResultSet rs = this.jt.query(sql.toString());
		List list = new ArrayList();
		while (rs.next()) {
			cuku rk = new cuku(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs
							.getString(7), rs.getString(8));
			list.add(rk);
		}
		this.jt.closeRes();
		return list;
	}

	public int count(RukuQuery rq) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(cid) from cuku_tb where 1=1");
		if (rq != null) {
			if ((rq.getDname() != null) && (!"".equals(rq.getDname()))) {
				sql.append(" and dname like '%" + rq.getDname() + "%'");
			}
			if ((rq.getYear() != null) && (!"".equals(rq.getYear()))) {
				sql.append(" and cyear='" + rq.getYear() + "'");
			}
			if ((rq.getMouth() != null) && (!"".equals(rq.getMouth()))) {
				sql.append(" and cmouth= '" + rq.getMouth() + "'");
			}
			if ((rq.getDay() != null) && (!"".equals(rq.getDay()))) {
				sql.append(" and cday= '" + rq.getDay() + "'");
			}
		}
		ResultSet rs = this.jt.query(sql.toString());
		int result = 0;
		if (rs.next()) {
			result = rs.getInt(1);
		}
		this.jt.closeRes();
		return result;
	}

	public List getcuku(Integer did) throws SQLException {
		String sql = "select * from kc_tb where did='" + did + "'";
		ResultSet rs = this.jt.query(sql);
		List list = new ArrayList();
		if (rs.next()) {
			kucu kc = new kucu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs
					.getInt(4));
			list.add(kc);
		}
		this.jt.closeRes();
		return list;
	}

	public boolean getckmx(cuku ck) {
		String sql = "insert into cuku_tb(did,dname,cnumber,uname,cyear,cmouth,cday) values(?,?,?,?,?,?,?)";
		List list = new ArrayList();
		list.add(ck.getDid());
		list.add(ck.getDname());
		list.add(ck.getCnumber());
		list.add(ck.getUname());
		list.add(ck.getCyear());
		list.add(ck.getCmouth());
		list.add(ck.getCday());
		boolean isok = false;
		try {
			isok = this.jt.updateData(sql, list);
			this.jt.myCommit();
		} catch (Exception e) {
			this.jt.myRollback();
		}
		return isok;
	}

	public boolean addck(String did, String cnumber) {
		String sql = "update kc_tb set knumber=knumber-'" + cnumber
				+ "' where did='" + did + "'";
		boolean isok = false;
		try {
			isok = this.jt.updateData(sql);
			this.jt.myCommit();
		} catch (Exception e) {
			this.jt.myRollback();
		}
		this.jt.closeRes();
		return isok;
	}
}