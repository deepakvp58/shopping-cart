import java.io.*;
import java.util.*;
import servletclass.ObjectToFileWrite;
import servletclass.Userpurchase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Writeitem extends HttpServlet{
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
  {
    String biname = request.getParameter("biname");
    //ServletContext context = getServletContext();
    ServletContext context = request.getServletContext();
    int count = (int) context.getAttribute("coun");
    count++;
    HttpSession session = request.getSession();
    String uname = (String) session.getAttribute("uname");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    Userpurchase UP = new Userpurchase();
    UP.setItemname(biname);
    addPurchase(UP,uname);
    context.setAttribute("cou",count);
    RequestDispatcher rd = request.getRequestDispatcher("Enteritem.jsp");
    rd.include(request,response);
    out.close();
  }
  public void addPurchase(Userpurchase UP,String uname) throws IOException
  {
    ObjectToFileWrite<Userpurchase> obu = new ObjectToFileWrite<>();
    obu.saveItem("Purchases\\"+uname+".txt", UP);
  }
}
