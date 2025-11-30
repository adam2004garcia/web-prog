<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%
  Integer uid = (Integer) session.getAttribute("uid");
  if(uid == null){
    response.sendRedirect("login.jsp");
    return;
  }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Profile</title>
    </head>
    <body>
        <h2>Your Profile</h2>
        
        <% if("1".equals(request.getParameter("saved"))) { %>
        <p style="color:green;">Profile saved.</p>
        <% } %>
        
        <form action="data" method="post">
              <input type="hidden" name="op" value="profile"
               
            <label>First name:</label>
            <input type="text" name="first_name" value="${profile.first_name}"><br>
            
            <label>Last name:</label>
            <input type="text" name="last_name" value="${profile.last_name}"><br>
            
            <label>About me:</label>
            <textarea name="about_me" rows="4" cols="50">${profile.about_me}</textarea><br><br>
            
            <label>Website:</label>
            <input type="text" name="website" value="${profile.website}"><br>
            
            <label>LinkedIn:</label>
            <input type="text" name="linkedin" value="${profile.linkedin}"><br>
            
            <label>GitHub:</label>
            <input type="text" name="github" value="${profile.github}"><br>
            
            <button type="submit">Save</button>
        </form>
        
        <p><a href="index.jsp">Home</a></p>
    </body>
</html>
