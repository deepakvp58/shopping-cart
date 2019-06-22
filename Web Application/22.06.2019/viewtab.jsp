<html>
  <body>
<%
   List<String> iname = (List<String>) request
            .getAttribute("iname");

   List<String> price = (List<String>) request
            .getAttribute("price");

    String myString="";
%>
<table>
<tr><td>
<%

    for(int i = 0; i < iname.size(); i++)
    {
       out.println((String)iname.get(i));
    }

    %>
</td><td>
<%

    for(int i = 0; i < price.size(); i++)
    {
       out.println((String)price.get(i));
    }

%>
</td>
</tr>
</table>
</body>
</html>
