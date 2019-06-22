<%@page import="servletclass.Items"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Shopping:User:Enteritem</title>
  </head>
  <body>
    <div>
      <center><b>Shopping</b></center>
    </div></br>
    <center>
    <div>
      Slot no.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Item name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Price &nbsp;&nbsp;&nbsp;</br>
      <%
        int slnumber = 1;
        FileInputStream fis = new FileInputStream("itlis.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        try{
          while(true){
            Items I = (Items) ois.readObject();%>
            </br>
            <%=slnumber%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=I.getIname()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=I.getPrice()%>
            <%
            slnumber++;
            %>
          <%
        }
      }
      catch(Exception ex){
        ex.printStackTrace();
      }
      %>
    </div>
    </center>
    </br>
    <div>
      <center><b>Enter Item</b></center>
    </div></br>
    <center><div class="row">
      <a href = "User.jsp" style="color:black;"><b>Home</b></a>
    </div></center></br>
    <center><form action="Writeitem" method="post">
      Enter item name:<input type="text" name="biname" align="left"></br></br>
      <input type="submit" value="buy"></br>
      <a href="User.jsp"> Logout </a>
    </form></center>
  </body>
</html>
