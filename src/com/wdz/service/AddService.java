package com.wdz.service;

import com.wdz.bean.DrugBean;
import com.wdz.dao.Addinfo;
import java.sql.SQLException;
import java.util.List;

public class AddService {
	Addinfo af;

	public AddService() {
		this.af = new Addinfo();
	}

	public boolean addinfo(DrugBean db) {
		return this.af.addinfo(db);
	}

	public List getdruginfo1(Integer did) throws SQLException {
		return this.af.getdruginfo1(did);
	}

	public boolean update(String did, String dname, String guige, String price,
			String effect) {
		return this.af.update(did, dname, guige, price, effect);
	}

	public boolean delete(String did) {
		return this.af.delete(did);
	}
}