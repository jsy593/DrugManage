package com.wdz.service;

import com.wdz.bean.UserBean;
import com.wdz.dao.Register;

public class RegisterService {
	Register re;

	public RegisterService() {
		this.re = new Register();
	}

	public boolean register(UserBean ub) {
		return this.re.register(ub);
	}
}