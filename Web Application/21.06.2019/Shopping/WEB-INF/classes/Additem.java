import java.io.*;
import java.util.*;
import servletclass.Items;
import servletclass.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Additem extends HttpServlet{
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
  {
    String iname = request.getParameter("iname");
    String price = request.getParameter("price");
    ServletContext sc = getServletContext();
    String path = sc.getRealPath("/WEB-INF/itlis.txt");
    Items I = new Items();
    I.setIname(iname);
    I.setPrice(price);
    Admin a = new Admin();
    a.addItem(I);
    response.setContentType("text/html");
    PrintWriter out= response.getWriter();
/*    out.println("<html>
                <body>
                <center>");*/
    out.println("Added Successfully..");
    out.println("</br><a href="+"Additem.jsp"+" style='color:black;'><b>Back</b></a>");
  }
}
