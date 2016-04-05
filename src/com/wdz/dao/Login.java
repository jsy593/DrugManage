package com.wdz.dao;

import com.wdz.bean.UserBean;
import com.wdz.util.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	JdbcTemplate jt;

	public Login() {
		this.jt = new JdbcTemplate();
	}

	public UserBean login(String username, String password) throws SQLException {
		username = username.replaceAll(" ", "");
		String sql = "select * from user_tb where username='" + username
				+ "' and password='" + password + "'";
		ResultSet rs = this.jt.query(sql);
		UserBean ub = null;
		if (rs.next()) {
			
			ub = new UserBean(rs.getString("username"), rs.getString("password"));
		}
		rs.close();
		this.jt.closeRes();
		return ub;
	}
}