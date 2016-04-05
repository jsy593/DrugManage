package com.wdz.servlet;

import com.wdz.bean.UserBean;
import com.wdz.service.RegisterService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	RegisterService rs;

	public RegisterServlet() {
		this.rs = new RegisterService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			UserBean ub = new UserBean();
			ub.setUsername(username);
			ub.setPassword(password);
			ub.setPhone(phone);
			ub.setEmail(email);
			ub.setSex(sex);
			this.rs.register(ub);

			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}