<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="servletclass.Items"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Usermenu></title>
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
      <center><b>Buy Items</b></center>
    </div></br>
<%
   List<Items> item = (ArrayList<Items>) request.getAttribute("items");
   int slnumber=1;
%>
<center><table>
  <tr>
  <th>Slot No.</th><th>Item name</th><th>Price</th><th>Buy</th>
</tr>
<%
    for(Items items : item)
    {
      %>
      <tr>
        <td>
          <%out.println(slnumber);%>
        </td>
      <td name="it">
       <%
       out.println(items.getIname());%></td>
       <td>
       <%
       out.println(items.getPrice());
       %>
     </td>
       <td>
         <form action="Writeitem" method="post">
           <input type="hidden" name="it" value="<%=items.getIname()%>"/>
           <input type="submit" value="Buy"/>
         </form>
     </td></tr>
     <%
     slnumber++;
    }
    %>


</table></center></br>
<center><div class="row">
  <a href = "Login.jsp" style="color:black;"><b>Logout</b></a>
</div></center></br>
</body>
</html>
