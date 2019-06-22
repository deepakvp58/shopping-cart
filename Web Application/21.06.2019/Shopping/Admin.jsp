<html>
  <head>
    <title>Shopping : Admin</title>
  </head>
  <body>
    <div>
      <center><b>Shopping</b></center>
    </div></br>
    <center><i><%
      out.println("Hello!Admin...");
    %></i></center></br></br>
    <center><div class="container">
      <div class="col">
        <div class="row">
          <a href = "Home.jsp" style="color:black;"><b>Home</b></a>
        </div>
      </br>
        <div class="row">
          <form action="Additem.jsp">
            <input type="submit" value="1.Add Item" />
          </form>
        </div>
      </br>
        <div class="row">
          <form action="Dispitem" method = "post">
            <input type="submit" value="2.Display Items" />
          </form>
        </div>
      </br>
        <div class="row">
          <form action="Dispreq" method = "post">
            <input type="submit" value="3.View Requests" />
          </form>
        </div>
      </br>
        <div class="row">
          <form action="Viewpur" method = "post">
            <input type="submit" value="4.View Purchases" />
          </form>
        </div>
      </br>
    </div></center>
  </body>
</html>
