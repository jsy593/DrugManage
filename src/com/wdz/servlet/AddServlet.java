package com.wdz.servlet;

import com.wdz.bean.DrugBean;
import com.wdz.service.AddService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	AddService as;

	public AddServlet() {
		this.as = new AddService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String method = request.getParameter("method");
		if ("add".equals(method)){
			add(request, response);
		}
		else if ("update".equals(method)){
			update(request, response);
		}
		else if ("update1".equals(method)){
			update1(request, response);
		}
		else if ("delete".equals(method)){
			delete(request, response);
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String dname = request.getParameter("dname");
			String guige = request.getParameter("guige");
			String price = request.getParameter("price");
			String effect = request.getParameter("effect");
			String type = request.getParameter("type");
			String factory = request.getParameter("factory");
			String date = request.getParameter("date");
			String indate = request.getParameter("indate");
			String anumber = request.getParameter("anumber");
			DrugBean db = new DrugBean();
			db.setDname(dname);
			db.setGuige(guige);
			db.setPrice(price);
			db.setEffect(effect);
			db.setType(type);
			db.setFactory(factory);
			db.setDate(date);
			db.setIndate(indate);
			db.setAnumber(anumber);
			this.as.addinfo(db);

			request.setAttribute("success", "添加成功！");
			request.getRequestDispatcher("addinfo.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String did = request.getParameter("did");
		try {
			List drug = this.as.getdruginfo1(Integer.valueOf(Integer
					.parseInt(did)));
			request.setAttribute("dr", drug);
			request.getRequestDispatcher("druginfo1.jsp").forward(request,
					response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String did = request.getParameter("did");
			String dname = request.getParameter("dname");
			String guige = request.getParameter("guige");
			String price = request.getParameter("price");
			String effect = request.getParameter("effect");
			boolean isok = this.as.update(did, dname, guige, price, effect);
			if (isok) {
				request.setAttribute("success", "修改成功");
				request.getRequestDispatcher("HomeServlet.do?type2=frist")
						.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String did = request.getParameter("did");
		boolean isk = this.as.delete(did);
		if (isk){
			response.sendRedirect("HomeServlet.do?type2=frist");
		}
	}
}