import java.io.*;
import java.util.*;
import servletclass.Masterpurchase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Viewpur extends HttpServlet{
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
  {
    int slnumber = 1;
    String Buy = "Buy";
  FileInputStream fis = new FileInputStream("maspurchase.txt");
  ObjectInputStream ois = new ObjectInputStream(fis);
  PrintWriter out = response.getWriter();
  out.println("<center>");
  out.println("Purchase no.:"+"&nbsp;&nbsp;&nbsp;"+"Username:"+"&nbsp;&nbsp;&nbsp;"+"</br>");
  while(true)
  {
    try{
      Masterpurchase MP = (Masterpurchase) ois.readObject();
      out.println("</br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+slnumber+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+MP.getUsername());
      slnumber++;
    }
    catch(EOFException ex){
      break;
    }
    catch(FileNotFoundException ex){
      out.println("No items added in the list..:(");
    }
    catch(ClassNotFoundException ex){
      ex.printStackTrace();
    }
    catch(IOException ex){
      ex.printStackTrace();
    }
  }
  out.println("</center>");
  response.setContentType("text/html");
  out.println("<html>\n"+"<head><title>"+Buy+"</title></head>\n"+
                  "<body>\n"+
                  "<center>\n"+"</br>"+
                  "Welcome Admin\n"+
                  "<form action=\"Viewuser\" method=\"post\">\n"+
                "Enter user name:<input type=\"text\" name=\"usename\"/>\n"+
                "<input type=\"submit\" value=\"View\"/>\n"+
                "</form>\n"+
                "</center>\n"+
                "</body>\n"+
                "</html>\n");
  out.println("<a href=\"Admin.jsp\">Admin Home</a>");
//  response.setContentType("text/html");
//  out.println("</br><a href="+"Admin.jsp"+" style='color:black;'><b>Back</b></a>");
}
}
