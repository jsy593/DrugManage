package com.wdz.servlet;

import com.wdz.bean.cuku;
import com.wdz.service.CukuService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CAddServlet extends HttpServlet {
	CukuService cs;

	public CAddServlet() {
		this.cs = new CukuService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String did = request.getParameter("did");
		String dname = request.getParameter("dname");
		String cnumber = request.getParameter("cnumber");
		String cyear = request.getParameter("cyear");
		String cmouth = request.getParameter("cmouth");
		String cday = request.getParameter("cday");
		String uname = request.getParameter("uname");
		cuku ck = new cuku();
		ck.setDid(did);
		ck.setDname(dname);
		ck.setCnumber(cnumber);
		ck.setCyear(cyear);
		ck.setCmouth(cmouth);
		ck.setCday(cday);
		ck.setUname(uname);
		this.cs.getckmx(ck);
		response.sendRedirect("CukuServlet.do");
	}
}