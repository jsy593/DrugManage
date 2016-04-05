package com.wdz.dao;

import com.wdz.util.JdbcTemplate;

public class RkDao {
	JdbcTemplate jt;

	public RkDao() {
		this.jt = new JdbcTemplate();
	}

	public boolean addrk(String did, String rnumber) {
		String sql = "update kc_tb set knumber=knumber+'" + rnumber
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