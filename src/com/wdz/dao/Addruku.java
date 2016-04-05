package com.wdz.dao;

import com.wdz.bean.ruku;
import com.wdz.util.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;

public class Addruku {
	JdbcTemplate jt;

	public Addruku() {
		this.jt = new JdbcTemplate();
	}

	public boolean addruku(ruku rk) {
		String sql = "insert into ruku_tb(did,dname,rnumber,year,mouth,day,uname) values(?,?,?,?,?,?,?)";
		List list = new ArrayList();
		list.add(rk.getDid());
		list.add(rk.getDname());
		list.add(rk.getRnumber());
		list.add(rk.getYear());
		list.add(rk.getMouth());
		list.add(rk.getDay());
		list.add(rk.getUname());
		boolean isok = false;
		try {
			isok = this.jt.updateData(sql, list);
			this.jt.myCommit();
		} catch (Exception e) {
			this.jt.myRollback();
		}
		return isok;
	}
}