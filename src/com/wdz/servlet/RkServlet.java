package com.wdz.servlet;

import com.wdz.service.RkService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RkServlet extends HttpServlet {
	RkService rs;

	public RkServlet() {
		this.rs = new RkService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String did = request.getParameter("did");
		String rnumber = request.getParameter("rnumber");
		boolean isok = this.rs.addrk(did, rnumber);
		if (isok)
			request.getRequestDispatcher("RAddServlet.do").forward(request,
					response);
	}
}