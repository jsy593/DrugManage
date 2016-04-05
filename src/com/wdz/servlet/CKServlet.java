package com.wdz.servlet;

import com.wdz.service.CukuService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CKServlet extends HttpServlet {
	CukuService cs;

	public CKServlet() {
		this.cs = new CukuService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String did = request.getParameter("did");
		String cnumber = request.getParameter("cnumber");
		boolean isok = this.cs.addck(did, cnumber);
		if (isok)
			request.getRequestDispatcher("CAddServlet.do").forward(request,
					response);
	}
}