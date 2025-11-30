package p1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.sql.*;

@WebServlet("/coursework")
public class CourseWorkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        Integer uid = (s != null) ? (Integer) s.getAttribute("uid") : null;
        
        if(uid == null){
            response.sendRedirect("login.jsp");
            return;
        }
        
        CourseworkData data = new CourseworkData();
        try {
            List<Course> courses = data.listByUser(uid);
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("/coursework.jsp").forward(request, response);
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
        
        String code = request.getParameter("courseCode");
        String title = request.getParameter("courseTitle");
        String semester = request.getParameter("semester");
        String description = request.getParameter("description");
        
        Course c = new Course();
        c.setUserId(uid);
        c.setCourseCode(code);
        c.setCourseTitle(title);
        c.setSemester(semester);
        c.setDescription(description);
        
        CourseworkData data = new CourseworkData();
        try {
            data.addCourse(c);
            response.sendRedirect("coursework");
        } catch(SQLException e) {
            throw new ServletException(e);
        }
    }

}
