<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%
            Integer uid = (Integer) session.getAttribute("uid");
            String username = (String) session.getAttribute("username");
            if(uid == null){
            %>
        <p><a href="login.jsp">Login<a/> | <a href="register.jsp">Register</a></p>
        <% } else { %>
        <p>Welcome, <%= username %>! 
        <a href="profile">Your Profile</a> | <a href="logout">Logout</a>
        </p>
        <% } %>
    </body>
</html>
