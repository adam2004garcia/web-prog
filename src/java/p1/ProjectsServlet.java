package p1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;
import java.util.List;

@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        Integer uid = (s != null) ? (Integer) s.getAttribute("uid") : null;
        
        if(uid == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        ProjectsData data = new ProjectsData();
        try {
            List<Project> projects = data.listByUser(uid);
            request.setAttribute("projects", projects);
            request.getRequestDispatcher("/projects.jsp").forward(request, response);
        } catch(SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        Integer uid = (s != null) ? (Integer) s.getAttribute("uid") : null;
        
        if(uid == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        String title = request.getParameter("title");
        String desc = request.getParameter("description");
        String link = request.getParameter("link");
        
        Project p = new Project();
        p.setUserId(uid);
        p.setTitle(title);
        p.setDescription(desc);
        p.setLink(link);
        
        ProjectsData data = new ProjectsData();
        try {
            data.addProject(p);
            response.sendRedirect("projects");
        } catch(SQLException e) {
            throw new ServletException(e);
        }
    }

}
