import java.io.*;
import java.util.*;
import servletclass.Items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispitem extends HttpServlet{
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
  {
    int slnumber = 1;
  FileInputStream fis = new FileInputStream("itlis.txt");
  ObjectInputStream ois = new ObjectInputStream(fis);
  PrintWriter out = response.getWriter();
  out.println("Number of Items available:\nSlot no.\tItem name\tPrice\n");
  while(true)
  {
    try{
      Items I = (Items) ois.readObject();
      out.println(slnumber+"\t\t"+I.getIname()+"\t\t"+I.getPrice());
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
//  response.setContentType("text/html");
//  out.println("</br><a href="+"Admin.jsp"+" style='color:black;'><b>Back</b></a>");
}
}
