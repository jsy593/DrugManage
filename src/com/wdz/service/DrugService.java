package com.wdz.service;

import com.wdz.bean.DrugQuery;
import com.wdz.dao.DrugDao;
import java.sql.SQLException;
import java.util.List;

public class DrugService {
	DrugDao dd;

	public DrugService() {
		this.dd = new DrugDao();
	}

	public List getinfo() {
		return this.dd.getinfo();
	}

	public List getinfo1(int nowPage, int pageNumber, DrugQuery dq)
			throws SQLException {
		return this.dd.getinfo1(nowPage, pageNumber, dq);
	}

	public int getCount(DrugQuery dq) throws SQLException {
		return this.dd.getCount(dq);
	}
}