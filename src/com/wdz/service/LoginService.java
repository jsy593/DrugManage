package com.wdz.service;

import com.wdz.bean.UserBean;
import com.wdz.dao.Login;
import java.sql.SQLException;

public class LoginService {
	Login lo;

	public LoginService() {
		this.lo = new Login();
	}

	public UserBean login(String username, String password) throws SQLException {
		return this.lo.login(username, password);
	}
}