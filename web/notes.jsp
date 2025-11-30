<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
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
        <title>Notes</title>
    </head>
    <body>
        <h2>Notes</h2>
        <% if(request.getParameter("saved") != null) { %>
            <p style="color:green;">Notes saved.</p>
        <% } %>
        
        <form action="data" method="post">
            <input type="hidden" name="op" value="notes">
            <textarea name="content" rows="10" cols="60">${notes}</textarea><br><br>
            <button type="submit">Save Notes</button>
        </form>
            <p><a href="index.jsp">Back to Home</a></p>
    </body>
</html>
