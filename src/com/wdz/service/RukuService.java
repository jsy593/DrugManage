package com.wdz.service;

import com.wdz.bean.RukuQuery;
import com.wdz.dao.RukuDao;
import java.sql.SQLException;
import java.util.List;

public class RukuService {
	RukuDao rd;

	public RukuService() {
		this.rd = new RukuDao();
	}

	public List getinfo(int nowPage, int pageNumber, RukuQuery rq)
			throws SQLException {
		return this.rd.getinfo(nowPage, pageNumber, rq);
	}

	public int count(RukuQuery rq) throws SQLException {
		return this.rd.count(rq);
	}
}