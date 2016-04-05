package com.wdz.servlet;

import com.wdz.bean.DrugQuery;
import com.wdz.service.DrugService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet
{
  DrugService ds;

  public HomeServlet()
  {
    this.ds = new DrugService();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    drugInfo(request, response);
  }

  private void drugInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    HttpSession session = request.getSession();
    String type1 = request.getParameter("type1");
    String type2 = request.getParameter("type2");

    String dname = request.getParameter("dname");
    String price1 = request.getParameter("price1");
    String price2 = request.getParameter("price2");
    String type = request.getParameter("type");

    DrugQuery dq = null;
    if ("frist".equals(type2))
    {
      session.removeAttribute("dq");
    } else {
      Object obj = session.getAttribute("dq");
      if (obj != null) {
        dq = (DrugQuery)obj;
        if ("query".equals(type1)) {
          dq = new DrugQuery(dname, price1, price2, type);
          request.getSession().setAttribute("dq", dq);
        }
      } else {
        dq = new DrugQuery(dname, price1, price2, type);
        request.getSession().setAttribute("dq", dq);
      }
    }

    int nowPage = 1;
    int pageNumber = 6;
    String page = request.getParameter("page");
    if ((page != null) && (!"".equals(page)))
      nowPage = Integer.parseInt(page);
    try
    {
      int count = this.ds.getCount(dq);

      int allPage = count % pageNumber == 0 ? count / pageNumber : count / pageNumber + 1;
      List drugs = this.ds.getinfo1(nowPage, pageNumber, dq);

      request.setAttribute("nowPage", Integer.valueOf(nowPage));
      request.setAttribute("pageNumber", Integer.valueOf(pageNumber));
      request.setAttribute("allPage", Integer.valueOf(allPage));
      request.setAttribute("count", Integer.valueOf(count));
      request.setAttribute("druginfo", drugs);
      request.getRequestDispatcher("druginfo.jsp").forward(request, response);
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }
}