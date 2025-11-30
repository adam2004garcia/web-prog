package p1;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ProfileData {
    public void saveProfile(int userId, String first, String last, String about, String website, String linkedin, String github) throws SQLException {

        String sql = 
            "INSERT INTO profiles (user_id, first_name, last_name, about_me, website, linkedin, github) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)" + 
            "ON DUPLICATE KEY UPDATE " +
              "first_name = VALUES(first_name), " +
              "last_name = VALUES(last_name), " +
              "about_me = VALUES(about_me), " +
              "website = VALUES(website), " +
              "linkedin = VALUES(linkedin), " +
              "github = VALUES(github)";

        try (Connection c = DB.get();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setString(2, first);
            ps.setString(3, last);
            ps.setString(4, about);
            ps.setString(5, website);
            ps.setString(6, linkedin);
            ps.setString(7, github);
            ps.executeUpdate();
        }
    }
    
    public Map<String, String> getProfile(int userId) throws Exception {
        String sql = "SELECT first_name, last_name, about_me, website, linkedin, github " + 
                     "FROM profiles WHERE user_id = ?";
        
        Map<String, String> m = new HashMap<>();
        m.put("first_name", "");
        m.put("last_name", "");
        m.put("about_me", "");
        m.put("website", "");
        m.put("linkedin", "");
        m.put("github", "");
        
        try(Connection c = DB.get();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    m.put("first_name", rs.getString("first_name"));
                    m.put("last_name", rs.getString("last_name"));
                    m.put("about_me", rs.getString("about_me"));
                    m.put("website", rs.getString("website"));
                    m.put("linkedin", rs.getString("linkedin"));
                    m.put("github", rs.getString("github"));
                }
            }
        }
        return m;
    }
}
