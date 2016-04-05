package com.wdz.dao;

import com.wdz.bean.DrugBean;
import com.wdz.bean.DrugQuery;
import com.wdz.util.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugDao {
	JdbcTemplate jt;

	public DrugDao() {
		this.jt = new JdbcTemplate();
	}

	public List getinfo() {
		String sql = "select * from  drug_tb";
		ResultSet rs = this.jt.query(sql);
		List list = new ArrayList();
		try {
			while (rs.next()) {
				DrugBean db = new DrugBean(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9), rs.getString(10));

				list.add(db);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.jt.closeRes();
		return list;
	}

	public List getinfo1(int nowPage, int pageNumber, DrugQuery dq)
			throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from drug_tb where 1=1");
		if (dq != null) {
			if ((dq.getDname() != null) && (!"".equals(dq.getDname()))) {
				sql.append(" and dname like '%" + dq.getDname() + "%'");
			}
			if ((dq.getPrice1() != null) && (!"".equals(dq.getPrice1()))) {
				sql.append(" and price>=" + dq.getPrice1());
			}
			if ((dq.getPrice2() != null) && (!"".equals(dq.getPrice2()))) {
				sql.append(" and price<=" + dq.getPrice2());
			}
			if ((dq.getType() != null) && (!"".equals(dq.getType()))) {
				sql.append(" and type='" + dq.getType() + "'");
			}
		}
		sql.append(" limit " + (nowPage - 1) * pageNumber + "," + pageNumber);
		ResultSet rs = this.jt.query(sql.toString());
		List list = new ArrayList();
		while (rs.next()) {
			DrugBean db = new DrugBean(rs.getInt(1), rs.getString(2), rs
					.getString(3), rs.getString(4), rs.getString(5), rs
					.getString(6), rs.getString(7), rs.getString(8), rs
					.getString(9), rs.getString(10));
			list.add(db);
		}
		this.jt.closeRes();
		return list;
	}

	public int getCount(DrugQuery dq) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(did) from drug_tb where 1=1");
		if (dq != null) {
			if ((dq.getDname() != null) && (!"".equals(dq.getDname()))) {
				sql.append(" and dname like '%" + dq.getDname() + "%'");
			}
			if ((dq.getPrice1() != null) && (!"".equals(dq.getPrice1()))) {
				sql.append(" and price>=" + dq.getPrice1());
			}
			if ((dq.getPrice2() != null) && (!"".equals(dq.getPrice2()))) {
				sql.append(" and price<=" + dq.getPrice2());
			}
			if ((dq.getType() != null) && (!"".equals(dq.getType()))) {
				sql.append(" and type='" + dq.getType() + "'");
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