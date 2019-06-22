<%@page import="servletclass.Items"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Shopping:Admin:Viewitem</title>
  </head>
  <body><center><div>
    Item name &nbsp;&nbsp;&nbsp;&nbsp; Price &nbsp;&nbsp;&nbsp;</br>
    <%
      FileInputStream fis = new FileInputStream("itlis.txt");
      ObjectInputStream ois = new ObjectInputStream(fis);
      try{
        while(true){
          Items I = (Items) ois.readObject();%>
          </br>
          <%=I.getIname()%><%=I.getPrice()%>
        <%
      }
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
    %>
  </div>
  </center>
  <div>
    <a href="Admin.jsp" style="color:black;"><b>Admin menu</b></a>
  </div>
</body>
</html>
