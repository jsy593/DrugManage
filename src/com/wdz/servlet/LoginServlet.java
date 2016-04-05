package com.wdz.servlet;

import com.wdz.bean.UserBean;
import com.wdz.service.LoginService;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	LoginService ls;

	public LoginServlet() {
		this.ls = new LoginService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String number = request.getParameter("number");
		if ((number != null) && (!"".equals(number))) {
			Object obj = request.getSession().getAttribute("validateCode");
			if (obj != null) {
				String oldCode = obj.toString();
				if (number.equalsIgnoreCase(oldCode)) {
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					try {
						UserBean ub = this.ls.login(username, password);
						if (ub != null) {
							session.setAttribute("user", ub);
							response.sendRedirect("index.jsp");
						} else {
							request.setAttribute("error", "”√ªß√‹¬Î¥ÌŒÛ");
							request.getRequestDispatcher("login.jsp").forward(
									request, response);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			request.setAttribute("error1", "—È÷§¬Î¥ÌŒÛ");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
	}
}