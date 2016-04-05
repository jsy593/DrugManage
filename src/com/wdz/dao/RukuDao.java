package com.wdz.dao;

import com.wdz.bean.RukuQuery;
import com.wdz.bean.ruku;
import com.wdz.util.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RukuDao {
	JdbcTemplate jt;

	public RukuDao() {
		this.jt = new JdbcTemplate();
	}

	public List getinfo(int nowPage, int pageNumber, RukuQuery rq)
			throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ruku_tb where 1=1");
		if (rq != null) {
			if ((rq.getDname() != null) && (!"".equals(rq.getDname()))) {
				sql.append(" and dname like '%" + rq.getDname() + "%'");
			}
			if ((rq.getYear() != null) && (!"".equals(rq.getYear()))) {
				sql.append(" and year='" + rq.getYear() + "'");
			}
			if ((rq.getMouth() != null) && (!"".equals(rq.getMouth()))) {
				sql.append(" and mouth= '" + rq.getMouth() + "'");
			}
			if ((rq.getDay() != null) && (!"".equals(rq.getDay()))) {
				sql.append(" and day= '" + rq.getDay() + "'");
			}
		}
		sql.append(" limit " + (nowPage - 1) * pageNumber + "," + pageNumber);
		ResultSet rs = this.jt.query(sql.toString());
		List list = new ArrayList();
		while (rs.next()) {
			ruku rk = new ruku(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs
							.getString(7), rs.getString(8));
			list.add(rk);
		}
		this.jt.closeRes();
		return list;
	}

	public int count(RukuQuery rq) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(rid) from ruku_tb where 1=1");
		if (rq != null) {
			if ((rq.getDname() != null) && (!"".equals(rq.getDname()))) {
				sql.append(" and dname like '%" + rq.getDname() + "%'");
			}

			if ((rq.getYear() != null) && (!"".equals(rq.getYear()))) {
				sql.append(" and year='" + rq.getYear() + "'");
			}
			if ((rq.getMouth() != null) && (!"".equals(rq.getMouth()))) {
				sql.append(" and mouth= '" + rq.getMouth() + "'");
			}
			if ((rq.getDay() != null) && (!"".equals(rq.getDay()))) {
				sql.append(" and day= '" + rq.getDay() + "'");
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
}