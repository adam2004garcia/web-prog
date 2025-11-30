package p1;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name="RegisterServlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String passwordHash = pass;
        
        try {
            UserData data = new UserData();
            int newId = data.create(username, email, passwordHash);
            if(newId <= 0){
                response.sendRedirect("register.jsp?e=insert");
                return;
            }
            
            HttpSession s = request.getSession(true);
            s.setAttribute("uid", newId);
            s.setAttribute("username", username);
            
            response.sendRedirect("index.jsp");
        } catch(Exception ex){
            ex.printStackTrace();
            response.sendRedirect("register.jsp?e=dup");
        }
    }

}
