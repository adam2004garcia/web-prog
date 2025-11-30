package p1;

import java.sql.*;

public class NotesData {
    public String getNotes(int userId) throws Exception {
        String sql = "SELECT content FROM notes WHERE user_id = ?";
                
        try(Connection c = DB.get();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    String text = rs.getString("content");
                    return (text != null) ? text : "";
                } else {
                    return "";
                }
            }
        }
    } 
    
    public void saveNotes(int userId, String content) throws Exception {
        String sql = "INSERT INTO notes (user_id, content) " + 
                     "VALUES(?, ?) " + 
                     "ON DUPLICATE KEY UPDATE content = VALUES(content)";
        
        try(Connection c = DB.get();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setString(2, content);
            ps.executeUpdate();
        }
    }
}
