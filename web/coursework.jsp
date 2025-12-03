<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@page import="java.util.*, p1.Course"%>

<%
    Integer uid = (Integer) session.getAttribute("uid");
    if (uid == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Course> courses = (List<Course>) request.getAttribute("courses");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Coursework</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="page-shell">
    <header class="top-nav">
        <a href="index.jsp" class="nav-link">Home</a>
        <a href="projects" class="nav-link">Projects</a>
        <a href="coursework" class="nav-link active">Coursework</a>
        <a href="data?page=notes" class="nav-link">Notes</a>
        <a href="logout.jsp" class="nav-link danger">Logout</a>
    </header>

    <main class="main-wrapper">
        <section class="content-card">
            <h2>Your Coursework</h2>

            <% if (courses == null || courses.isEmpty()) { %>
                <p>No coursework added yet.</p>
            <% } else { %>
                <ul class="item-list">
                <% for (Course c : courses) { %>
                    <li class="item">
                        <h3><%= c.getCourseCode() %> — <%= c.getCourseTitle() %></h3>
                        <p><strong>Semester:</strong> <%= c.getSemester() %></p>
                        <p><%= c.getDescription() %></p>
                    </li>
                <% } %>
                </ul>
            <% } %>

            <hr>

            <h3>Add New Coursework</h3>
            <form action="coursework" method="post" class="form-stacked">
                <label>Course Code:</label>
                <input type="text" name="course_code" required>

                <label>Course Title:</label>
                <input type="text" name="course_title" required>

                <label>Semester:</label>
                <input type="text" name="semester" required>

                <label>Description:</label>
                <textarea name="description" rows="4"></textarea>

                <button type="submit" class="btn-primary">Add Coursework</button>
            </form>

        </section>
    </main>
</div>

</body>
</html>

