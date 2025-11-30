package p1;

import java.sql.*;

public class MessagesData {
   public void saveMessage(ContactMessage msg) throws SQLException {
       String sql = "INSERT INTO messages (user_id, from_name, from_email, message) " + 
                    "VALUES(?, ?, ?, ?)";
       
       try(Connection c = DB.get();
          PreparedStatement ps = c.prepareStatement(sql)) {
           
          ps.setInt(1, msg.getUserId());
          ps.setString(2, msg.getFromName());
          ps.setString(3, msg.getFromEmail());
          ps.setString(4, msg.getMessage());
          ps.executeUpdate();
       }
   } 
}
