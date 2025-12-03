<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
       <h2>Login</h2>
       
       <form action="login" method="post">
           <% if(request.getParameter("e") != null) { %>
           <p style="color:red;">Invalid username or password.</p>
           <% } %>
           
           <label>Username:</label>
           <input type="text" name="username" required><br><br>
           <label>Password:</label>
           <input type="password" name="password" required><br><br>
           
           <button type="Submit">Login</button>
       </form>

  <p>Don't have an account? <a href="register.jsp">Register</a></p>
</body>
</html>
