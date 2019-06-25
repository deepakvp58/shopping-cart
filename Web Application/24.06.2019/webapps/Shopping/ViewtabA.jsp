<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="servletclass.Masterpurchase"%>
<%@page import="servletclass.Userpurchase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Purchase Menu</title>
  </head>
  <style>
  table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 30%;
    }
  th{
    border: 1px solid #dddddd;
    text-align:center;
    padding:20px;
  }
  td {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
  }

  tr:nth-child(odd) {
      background-color: #dddddd;
  }
  </style>
  <body>
    <div>
      <center><b>Purchases</b></center>
    </div></br>
<%
   List<Masterpurchase> maspur = (ArrayList<Masterpurchase>) request.getAttribute("maspur");
   int slnumber=1;
%>
<center><table>
  <tr>
  <th>Slot No.</th><th>User Name</th><th>Count</th><th>View Details</th>
</tr>
<%
    for(Masterpurchase maspurs: maspur)
    {
      %>
      <tr>
        <td>
          <%out.println(slnumber);%>
        </td>
      <td>
       <%
       out.println(maspurs.getUsername());%></td>
       <td>
       <%
       String usn;
       int count = 0;
       usn = maspurs.getUsername();
       FileInputStream fis = new FileInputStream("Purchases\\"+usn+".txt");
       ObjectInputStream ois = new ObjectInputStream(fis);
       while(true)
        {
          try
          {
            Userpurchase UP = (Userpurchase) ois.readObject();
            count++;
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
        out.println(count);
       %>
     </td>
       <td>
         <form action="Dispuser" method="post">
           <input type="hidden" name="us" value="<%=maspurs.getUsername()%>"/>
           <input type="submit" value="View"/>
         </form>
     </td></tr>
     <%
     slnumber++;
    }
    %>


</table></center></br>
<center><div class="row">
  <a href = "DispitemA" style="color:black;"><b>Admin Home</b></a>
</div></center></br>
</body>
</html>
