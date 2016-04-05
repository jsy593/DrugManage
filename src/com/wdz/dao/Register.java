package com.wdz.dao;

import com.wdz.bean.UserBean;
import com.wdz.util.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;

public class Register {
	JdbcTemplate jt;

	public Register() {
		this.jt = new JdbcTemplate();
	}

	public boolean register(UserBean ub) {
		String sql = "insert into user_tb(username,password,sex,phone,email) value(?,?,?,?,?)";
		List params = new ArrayList();
		params.add(ub.getUsername());
		params.add(ub.getPassword());
		params.add(ub.getSex());
		params.add(ub.getPhone());
		params.add(ub.getEmail());

		boolean isok = false;
		try {
			isok = this.jt.updateData(sql, params);
			this.jt.myCommit();
		} catch (Exception e) {
			this.jt.myRollback();
		}

		return isok;
	}
}