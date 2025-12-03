<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@page import="java.util.*, p1.Project"%>

<%
    Integer uid = (Integer) session.getAttribute("uid");
    if (uid == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Project> projects = (List<Project>) request.getAttribute("projects");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Projects</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="page-shell">
    <header class="top-nav">
        <a href="index.jsp" class="nav-link">Home</a>
        <a href="projects" class="nav-link active">Projects</a>
        <a href="coursework" class="nav-link">Coursework</a>
        <a href="data?page=notes" class="nav-link">Notes</a>
        <a href="logout.jsp" class="nav-link danger">Logout</a>
    </header>

    <main class="main-wrapper">
        <section class="content-card">
            <h2>Your Projects</h2>

            <% if (projects == null || projects.isEmpty()) { %>
                <p>No projects added yet.</p>
            <% } else { %>
                <ul class="item-list">
                <% for (Project p : projects) { %>
                    <li class="item">
                        <h3><%= p.getTitle() %></h3>
                        <p><%= p.getDescription() %></p>
                        <% if (p.getLink() != null && !p.getLink().isEmpty()) { %>
                            <p><a href="<%= p.getLink() %>" target="_blank">Project Link</a></p>
                        <% } %>
                    </li>
                <% } %>
                </ul>
            <% } %>

            <hr>

            <h3>Add New Project</h3>
            <form action="projects" method="post" class="form-stacked">
                <label>Project Title:</label>
                <input type="text" name="title" required>

                <label>Description:</label>
                <textarea name="description" rows="4"></textarea>

                <label>Link (optional):</label>
                <input type="text" name="link">

                <button type="submit" class="btn-primary">Add Project</button>
            </form>

        </section>
    </main>
</div>

</body>
</html>
