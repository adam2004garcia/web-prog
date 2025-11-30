package p1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            UserData data = new UserData();
            
            User user = data.verifyLogin(username, password);
            if(user == null){
                response.sendRedirect("login.jsp?e=1");
                return;
            }
            
            HttpSession s = request.getSession(true);
            s.setAttribute("uid", user.getId());
            s.setAttribute("username", user.getUsername());
            
            response.sendRedirect("index.jsp");
        } catch(Exception ex){
            ex.printStackTrace();
            response.sendRedirect("login.jsp?e=2");
        }
    }

}
