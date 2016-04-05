package com.wdz.service;

import com.wdz.bean.ruku;
import com.wdz.dao.Addruku;

public class AddrukuService {
	Addruku ar;

	public AddrukuService() {
		this.ar = new Addruku();
	}

	public boolean addruku(ruku rk) {
		return this.ar.addruku(rk);
	}
}