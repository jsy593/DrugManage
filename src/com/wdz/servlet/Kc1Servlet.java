package com.wdz.servlet;

import com.wdz.service.KcService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Kc1Servlet extends HttpServlet {
	KcService ks;

	public Kc1Servlet() {
		this.ks = new KcService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getxx(request, response);
	}

	private void getxx(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowPage = 1;

		int pageNumber = 4;

		String page = request.getParameter("page");
		if ((page != null) && (!"".equals(page))) {
			nowPage = Integer.parseInt(page);
		}
		try {
			int count = this.ks.getcount();

			int allPage = count % pageNumber == 0 ? count / pageNumber : count
					/ pageNumber + 1;
			List list = this.ks.getxx(nowPage, pageNumber);

			request.setAttribute("nowPage", Integer.valueOf(nowPage));
			request.setAttribute("pageNumber", Integer.valueOf(pageNumber));
			request.setAttribute("allPage", Integer.valueOf(allPage));
			request.setAttribute("count", Integer.valueOf(count));
			request.setAttribute("xx", list);
			request.getRequestDispatcher("kc1.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}