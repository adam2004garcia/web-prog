<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h2>Register</h2>
        
        <% if(request.getParameter("e") != null) { %>
        <p style="color:red;">There was a problem creating your account.</p>
            <% } %>
            
            <form action="register" method="post">
                <label>Username:</label>
                <input type="text" name="username" required><br><br>
                
                <label>Email:</label>
                <input type="email" name="email" required><br><br>
                
                <label>Password:</label>
                <input type="password" name="password" required><br><br>
                
                <button type="submit">Register</button>
            </form>
            
            <p><a href="login.jsp">Back to Login</a></p>
    </body>
</html>
