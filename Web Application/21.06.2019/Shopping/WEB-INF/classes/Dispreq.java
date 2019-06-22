import java.io.*;
import java.util.*;
import servletclass.Requests;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispreq extends HttpServlet{
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
  {
    int slnumber = 1;
  FileInputStream fis = new FileInputStream("relis.txt");
  ObjectInputStream ois = new ObjectInputStream(fis);
//  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  out.println("Requested items are..\nSlot no.\tItem name\n");
  while(true)
  {
    try{
      Requests R = (Requests) ois.readObject();
      out.println(slnumber+"\t\t"+R.getRequest());
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
  //out.println("</br><a href="+"Admin.jsp"+" style='color:black;'><b>Back</b></a>");
}
}
