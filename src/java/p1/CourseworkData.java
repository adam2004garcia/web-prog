package p1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseworkData {
    public List<Course> listByUser(int userId) throws SQLException {
        String sql = "SELECT id, user_id, course_code, course_title, semester, description " + 
                    "FROM coursework WHERE user_id = ? ORDER BY created_at DESC";
        
        List<Course> result = new ArrayList<>();
        
        try(Connection c = DB.get();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Course course = new Course();
                    course.setId(rs.getInt("id"));
                    course.setUserId(rs.getInt("user_id"));
                    course.setCourseCode(rs.getString("course_code"));
                    course.setCourseTitle(rs.getString("course_title"));
                    course.setSemester(rs.getString("semester"));
                    course.setDescription(rs.getString("description"));
                    result.add(course);
                }
            }
        }
        return result;
    }
    
    public void addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO coursework (user_id, course_code, course_title, semester, description) " + 
                     "VALUES(?, ?, ?, ?, ?)";
        
        try(Connection c = DB.get();
                PreparedStatement ps = c.prepareStatement(sql)) {
            
                ps.setInt(1, course.getUserId());
                ps.setString(2, course.getCourseCode());
                ps.setString(3, course.getCourseTitle());
                ps.setString(4, course.getSemester());
                ps.setString(5, course.getDescription());
                ps.executeUpdate();
        }
    }
}
