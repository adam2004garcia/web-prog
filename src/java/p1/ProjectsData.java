package p1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectsData {
   public List<Project> listByUser(int userId) throws SQLException {
       String sql = "SELECT id, user_id, title, description, link " + 
                    "FROM projects WHERE user_id = ? ORDER BY created_at DESC";
       
       List<Project> result = new ArrayList<>();
       
       try(Connection c = DB.get();
           PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
               
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Project p = new Project();
                    p.setId(rs.getInt("id"));
                    p.setUserId(rs.getInt("user_id"));
                    p.setTitle(rs.getString("title"));
                    p.setDescription(rs.getString("description"));
                    p.setLink(rs.getString("link"));
                    result.add(p);
                }
            }
       }
       return result;
   }
   
   public void addProject(Project p) throws SQLException {
       String sql = "INSERT INTO projects (user_id, title, description, link) " + 
                    "VALUES(?, ?, ?, ?)";
       
       try(Connection c = DB.get();
           PreparedStatement ps = c.prepareStatement(sql)) {
            
           ps.setInt(1, p.getUserId());
           ps.setString(2, p.getTitle());
           ps.setString(3, p.getDescription());
           ps.setString(4, p.getLink());
           ps.executeUpdate();
       }
   }
}
