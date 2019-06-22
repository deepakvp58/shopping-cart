import java.io.*;
import java.util.*;
import servletclass.Masterpurchase;
import servletclass.ObjectToFileWrite;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Username extends HttpServlet{
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
  {
    int count=0;
    String usname = request.getParameter("usname");
    HttpSession session = request.getSession();
    session.setAttribute("uname",usname);
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    Masterpurchase MP = new Masterpurchase();
    MP.setUsername(usname);
    MP.setCount(count);
    addMpurchase(MP);
    /*out.println("<html>\n"+"<head><title>"+Buy+"</title></head>\n"+
                    "<body>\n"+
                    "<center>\n"+
                    "Welcome"+usname+"\n"+
                    "<form action=\"Writeitem\" method=\"post\">\n"+
                  "Item name:<input type=\"text\" name=\"biname\"/>\n"+
                  "<input type=\"submit\" value=\"Buy\"/>\n"+
                  "</form>\n"+
                  "</center>\n"+
                  "</body>\n"+
                  "</html>\n");*/
    ServletContext context = request.getServletContext();
    context.setAttribute("coun",count);
    RequestDispatcher rd = request.getRequestDispatcher("Enteritem.jsp");
    //count = (int) context.getAttribute("cou");
    rd.include(request,response);
    out.close();
  }
  public void addMpurchase(Masterpurchase MP) throws IOException
  {
    ObjectToFileWrite<Masterpurchase> obm = new ObjectToFileWrite<>();
    obm.saveItem("maspurchase.txt", MP);
  }
}
