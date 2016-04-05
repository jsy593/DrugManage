package com.wdz.servlet;

import com.wdz.bean.RukuQuery;
import com.wdz.service.RukuService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RukuServlet extends HttpServlet {
	RukuService rs;

	public RukuServlet() {
		this.rs = new RukuService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String type1 = request.getParameter("type1");
		String type2 = request.getParameter("type2");

		String dname = request.getParameter("dname");
		String year = request.getParameter("year");
		String mouth = request.getParameter("mouth");
		String day = request.getParameter("day");
		RukuQuery rq = null;
		if ("frist".equals(type1)) {
			session.removeAttribute("rq");
		} else {
			Object obj = session.getAttribute("rq");
			if (obj != null) {
				rq = (RukuQuery) obj;
				if ("query".equals(type2)) {
					rq = new RukuQuery(dname, year, mouth, day);
					request.getSession().setAttribute("rq", rq);
				}
			} else {
				rq = new RukuQuery(dname, year, mouth, day);
				request.getSession().setAttribute("rq", rq);
			}
		}
		int nowPage = 1;
		int pageNumber = 6;
		String page = request.getParameter("page");
		if ((page != null) && (!"".equals(page)))
			nowPage = Integer.parseInt(page);
		try {
			int count = this.rs.count(rq);

			int allPage = count % pageNumber == 0 ? count / pageNumber : count
					/ pageNumber + 1;
			List rukum = this.rs.getinfo(nowPage, pageNumber, rq);

			request.setAttribute("nowPage", Integer.valueOf(nowPage));
			request.setAttribute("pageNumber", Integer.valueOf(pageNumber));
			request.setAttribute("allPage", Integer.valueOf(allPage));
			request.setAttribute("count", Integer.valueOf(count));
			request.setAttribute("rkm", rukum);
			request.getRequestDispatcher("rukum.jsp")
					.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}