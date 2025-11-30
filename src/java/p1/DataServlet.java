package p1;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import java.util.Map;

@WebServlet(name = "DataServlet", urlPatterns = {"/data"})
public class DataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("uid") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (Integer) session.getAttribute("uid");
        String page = request.getParameter("page");
        
        if(page == null){
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            if ("profile".equals(page)) {
                ProfileData pd = new ProfileData();
                Map<String, String> profile = pd.getProfile(userId);
                request.setAttribute("profile", profile);
                
                RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                try {
                    rd.forward(request, response);
                } catch(Exception e) {
                    throw new IOException(e);
                }
            } else if("notes".equals(page)) {
                NotesData nd = new NotesData();
                String notes = nd.getNotes(userId);
                request.setAttribute("notes", notes);
                
                RequestDispatcher rd = request.getRequestDispatcher("notes.jsp");
                try {
                    rd.forward(request, response);
                } catch(Exception e) {
                    throw new IOException(e);
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?e=1");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("uid") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (Integer) session.getAttribute("uid");
        String op = request.getParameter("op");

        try {
            if("profile".equals(op)) {

                String first = request.getParameter("first_name");
                String last = request.getParameter("last_name");
                String about = request.getParameter("about_me");
                String website = request.getParameter("website");
                String linkedin = request.getParameter("linkedin");
                String github = request.getParameter("github");

                ProfileData pd = new ProfileData();
                pd.saveProfile(userId, first, last, about, website, linkedin, github);

                response.sendRedirect("data?page=profile&saved=1");
                return;
            } else if("notes".equals(op)) {
                String content = request.getParameter("content");
                NotesData nd = new NotesData();
                nd.saveNotes(userId, content);

                response.sendRedirect("data?page=notes&saved=1");
                return;
            }else {
                response.sendRedirect("index.jsp");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?e=1");
        }
    }
}
