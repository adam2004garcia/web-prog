package p1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    private static final int PROFILE_OWNER_USER_ID = 1;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fromName = request.getParameter("name");
        String fromEmail = request.getParameter("email");
        String message = request.getParameter("message");
        
        ContactMessage msg = new ContactMessage();
        msg.setUserId(PROFILE_OWNER_USER_ID);
        msg.setFromName(fromName);
        msg.setFromEmail(fromEmail);
        msg.setMessage(message);
        
        MessagesData data = new MessagesData();
        try {
            data.saveMessage(msg);
            response.sendRedirect("contact.jsp?sent=1");
        } catch(SQLException e) {
            throw new ServletException(e);
        }
    }

}
