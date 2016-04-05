package com.wdz.servlet;

import com.wdz.bean.ruku;
import com.wdz.service.AddrukuService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RAddServlet extends HttpServlet {
	AddrukuService as;

	public RAddServlet() {
		this.as = new AddrukuService();
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
		String rnumber = request.getParameter("rnumber");
		String year = request.getParameter("year");
		String mouth = request.getParameter("mouth");
		String day = request.getParameter("day");
		String uname = request.getParameter("uname");
		ruku rk = new ruku();
		rk.setDid(did);
		rk.setDname(dname);
		rk.setRnumber(rnumber);
		rk.setYear(year);
		rk.setMouth(mouth);
		rk.setDay(day);
		rk.setUname(uname);
		this.as.addruku(rk);
		response.sendRedirect("RukuServlet.do");
	}
}