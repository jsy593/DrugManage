package com.wdz.servlet;

import com.wdz.service.CukuService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cuku1Servlet extends HttpServlet {
	CukuService cs;

	public Cuku1Servlet() {
		this.cs = new CukuService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String did = request.getParameter("did");
		try {
			List ck = this.cs.getcuku(Integer.valueOf(Integer.parseInt(did)));
			request.setAttribute("ck", ck);
			request.getRequestDispatcher("cuku.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}