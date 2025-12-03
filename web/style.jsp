<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Simple session check (adjust to match your app)
    Integer uid = (Integer) session.getAttribute("uid");
    String username = (String) session.getAttribute("username");

    if (uid == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Projects &amp; Coursework – Style Guide</title>
    <!-- Assumes styles.css is already in your web/ folder -->
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="page-shell">
    <!-- Top nav / header -->
    <header class="top-nav">
        <div class="top-nav-left">
            <span class="app-title">Academic Homepage</span>
        </div>
        <div class="top-nav-right">
            <span class="user-pill">Hi, <%= username %></span>
            <a href="index.jsp" class="nav-link">Home</a>
            <a href="profile.jsp" class="nav-link">Profile</a>
            <a href="notes.jsp" class="nav-link">Notes</a>
            <a href="logout.jsp" class="nav-link">Logout</a>
        </div>
    </header>

    <main class="content-wrapper">
        <!-- Page title / intro -->
        <section class="section">
            <h1 class="page-title">Projects &amp; Coursework Style Guide</h1>
            <p class="page-subtitle">
                This page shows how your <strong>projects</strong> and <strong>coursework</strong>
                should be displayed across the site. You can copy these card layouts into
                your other JSP pages (e.g., <code>index.jsp</code>, <code>profile.jsp</code>).
            </p>
        </section>

        <!-- Projects section -->
        <section class="section">
            <h2 class="section-title">Project Cards</h2>
            <p class="section-text">
                Each project is shown as a card with a title, short description, tech stack,
                and optional link. Keep everything short and scannable.
            </p>

            <!-- Example project grid -->
            <div class="card-grid">
                <!-- Project 1 example -->
                <article class="card project-card">
                    <h3 class="card-title">Academic Homepage Portal</h3>
                    <p class="card-subtitle">Full-stack web application</p>
                    <p class="card-body">
                        JSP/Servlet-based academic dashboard with login, profile, notes,
                        and persistent user data. Deployed on Apache Tomcat.
                    </p>
                    <p class="card-meta">
                        <span class="tag">Java</span>
                        <span class="tag">JSP</span>
                        <span class="tag">MySQL</span>
                    </p>
                    <a href="#" class="card-link">View repository</a>
                </article>

                <!-- Project 2 example -->
                <article class="card project-card">
                    <h3 class="card-title">Networking Simulator</h3>
                    <p class="card-subtitle">Custom star topology switch</p>
                    <p class="card-body">
                        Simulates a star network with custom frame format, buffering, and
                        basic switching logic. Includes feature checklist and README.
                    </p>
                    <p class="card-meta">
                        <span class="tag">Java</span>
                        <span class="tag">Networking</span>
                    </p>
                    <a href="#" class="card-link">View report</a>
                </article>
            </div>

            <ul class="helper-list">
                <li>Use clear, action-focused titles.</li>
                <li>Limit descriptions to 2–4 sentences.</li>
                <li>Group technologies into small tags (e.g., Java, JSP, SQL).</li>
                <li>Optional: add buttons/links for GitHub, demo, or report.</li>
            </ul>
        </section>

        <!-- Coursework section -->
        <section class="section">
            <h2 class="section-title">Coursework Cards</h2>
            <p class="section-text">
                Coursework entries highlight key classes and what you learned in each.
                Show course code, name, semester, and skills or topics.
            </p>

            <div class="card-stack">
                <!-- Course 1 -->
                <article class="card course-card">
                    <header class="course-header">
                        <span class="course-code">CSE 3021</span>
                        <span class="course-name">Internet &amp; Web Programming</span>
                    </header>
                    <p class="course-semester">Semester: Fall 2025</p>
                    <p class="card-body">
                        Covered HTML, CSS, JavaScript, JSP/Servlets, sessions, and
                        deployment on Tomcat through a semester-long academic homepage
                        project.
                    </p>
                    <p class="card-meta">
                        <span class="tag">Web Dev</span>
                        <span class="tag">Full Stack</span>
                    </p>
                </article>

                <!-- Course 2 -->
                <article class="card course-card">
                    <header class="course-header">
                        <span class="course-code">CSCI 2230</span>
                        <span class="course-name">Computer Organization &amp; Assembly</span>
                    </header>
                    <p class="course-semester">Semester: Fall 2025</p>
                    <p class="card-body">
                        Focused on Y86-64/x86-64 assembly, stack frames, calling
                        conventions, and low-level program behavior.
                    </p>
                    <p class="card-meta">
                        <span class="tag">Assembly</span>
                        <span class="tag">Systems</span>
                    </p>
                </article>

                <!-- Course 3 -->
                <article class="card course-card">
                    <header class="course-header">
                        <span class="course-code">CSE/IT 3053</span>
                        <span class="course-name">Networking</span>
                    </header>
                    <p class="course-semester">Semester: Fall 2025</p>
                    <p class="card-body">
                        Explored TCP/IP, custom MAC protocols, star networks, and
                        socket-based Java implementations.
                    </p>
                    <p class="card-meta">
                        <span class="tag">Networking</span>
                        <span class="tag">Java</span>
                    </p>
                </article>
            </div>

            <ul class="helper-list">
                <li>Always show course code, full name, and semester.</li>
                <li>Describe projects, labs, or major topics instead of listing homework.</li>
                <li>Highlight skills that connect to your projects or career goals.</li>
            </ul>
        </section>
    </main>
</div>
</body>
</html>
