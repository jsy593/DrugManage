package com.wdz.service;

import com.wdz.dao.RkDao;

public class RkService {
	RkDao rd;

	public RkService() {
		this.rd = new RkDao();
	}

	public boolean addrk(String did, String rnumber) {
		return this.rd.addrk(did, rnumber);
	}
}