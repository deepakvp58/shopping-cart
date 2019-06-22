import java.io.*;
import java.util.*;
import servletclass.Requests;
import servletclass.ObjectToFileWrite;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Reqitem extends HttpServlet{
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
  {
    String itname = request.getParameter("itname");
    Requests R = new Requests();
    R.setRequest(itname);
    addRequest(R);
    response.setContentType("text/html");
    PrintWriter out= response.getWriter();
    out.println("Your request has been sent Successfully...");
    out.println("</br><a href="+"Reqitem.jsp"+" style='color:black;'><b>Back</b></a>");
  }
  public void addRequest(Requests R) throws IOException
  {
    ObjectToFileWrite<Requests> obr = new ObjectToFileWrite<>();
    obr.saveItem("relis.txt", R);
  }
}
