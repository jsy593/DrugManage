package com.wdz.service;

import com.wdz.bean.RukuQuery;
import com.wdz.dao.KcDao;
import java.sql.SQLException;
import java.util.List;

public class KcService {
	KcDao kd;

	public KcService() {
		this.kd = new KcDao();
	}

	public List getinfo(int nowPage, int pageNumber, RukuQuery rq)
			throws SQLException {
		return this.kd.getinfo(nowPage, pageNumber, rq);
	}

	public int count(RukuQuery rq) throws SQLException {
		return this.kd.count(rq);
	}

	public List getxx(int nowPage, int pageNumber) throws SQLException {
		return this.kd.getxx(nowPage, pageNumber);
	}

	public int getcount() throws SQLException {
		return this.kd.getcount();
	}
}