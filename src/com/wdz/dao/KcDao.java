package com.wdz.dao;

import com.wdz.bean.RukuQuery;
import com.wdz.bean.kucu;
import com.wdz.util.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KcDao {
	JdbcTemplate jt;

	public KcDao() {
		this.jt = new JdbcTemplate();
	}

	public List getinfo(int nowPage, int pageNumber, RukuQuery rq)
			throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from kc_tb where 1=1");
		if ((rq != null) && (rq.getDname() != null)
				&& (!"".equals(rq.getDname()))) {
			sql.append(" and dname like '%" + rq.getDname() + "%'");
		}

		sql.append(" limit " + (nowPage - 1) * pageNumber + "," + pageNumber);
		ResultSet rs = this.jt.query(sql.toString());
		List list = new ArrayList();
		while (rs.next()) {
			kucu rk = new kucu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs
					.getInt(4));

			list.add(rk);
		}
		this.jt.closeRes();
		return list;
	}

	public int count(RukuQuery rq) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(kid) from kc_tb where 1=1");
		if ((rq != null) && (rq.getDname() != null)
				&& (!"".equals(rq.getDname()))) {
			sql.append(" and dname like '%" + rq.getDname() + "%'");
		}

		ResultSet rs = this.jt.query(sql.toString());
		int result = 0;
		if (rs.next()) {
			result = rs.getInt(1);
		}
		this.jt.closeRes();
		return result;
	}

	public List getxx(int nowPage, int pageNumber) throws SQLException {
		String sql = "select * from kc_tb where knumber<20 order by knumber limit "
				+ (nowPage - 1) * pageNumber + "," + pageNumber;
		ResultSet rs = this.jt.query(sql);
		List list = new ArrayList();
		while (rs.next()) {
			kucu kc = new kucu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs
					.getInt(4));
			list.add(kc);
		}
		this.jt.closeRes();

		return list;
	}

	public int getcount() throws SQLException {
		String sql = "select count(kid) from kc_tb where knumber<20 order by knumber";
		ResultSet rs = this.jt.query(sql);
		int result = 0;
		if (rs.next()) {
			result = rs.getInt(1);
		}
		return result;
	}
}