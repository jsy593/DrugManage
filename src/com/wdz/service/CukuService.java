package com.wdz.service;

import com.wdz.bean.RukuQuery;
import com.wdz.bean.cuku;
import com.wdz.dao.CukuDao;
import java.sql.SQLException;
import java.util.List;

public class CukuService {
	CukuDao cd;

	public CukuService() {
		this.cd = new CukuDao();
	}

	public List getinfo(int nowPage, int pageNumber, RukuQuery rq)
			throws SQLException {
		return this.cd.getinfo(nowPage, pageNumber, rq);
	}

	public int count(RukuQuery rq) throws SQLException {
		return this.cd.count(rq);
	}

	public List getcuku(Integer did) throws SQLException {
		return this.cd.getcuku(did);
	}

	public boolean getckmx(cuku ck) {
		return this.cd.getckmx(ck);
	}

	public boolean addck(String did, String cnumber) {
		return this.cd.addck(did, cnumber);
	}
}