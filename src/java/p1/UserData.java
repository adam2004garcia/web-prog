package p1;

import java.sql.*;

public class UserData {
    
    public int create(String username, String email, String passwordHash) throws SQLException {
        String sql = "INSERT INTO users (username,email,password_hash) VALUES (?,?,?)";
        try(Connection c = DB.get();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, passwordHash);
            ps.executeUpdate();
            
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }
    
    public User findByUsername(String username) throws SQLException {
        String sql = "SELECT id, username, email, password_hash, created_at FROM users WHERE username = ?";
        try(Connection c = DB.get();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try(ResultSet rs = ps.executeQuery()) {
                if(!rs.next()) return null;
                return map(rs);
            }
        }
    }
    
        public User findById(int id) throws SQLException {
        String sql = "SELECT id, username, email, password_hash, created_at FROM users WHERE id = ?";
        try(Connection c = DB.get();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if(!rs.next()) return null;
                return map(rs);
            }
        }
    }
        
            public boolean existsByUsernameOrEmail(String username, String email) throws SQLException {
        String sql = "SELECT 1 FROM users WHERE username = ? OR email = ? LIMIT 1";
        try(Connection c = DB.get();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, email);
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
            
            public User verifyLogin(String username, String passwordPlain) throws SQLException{
                User u = findByUsername(username);
                if(u == null) return null;
                if(passwordPlain != null && passwordPlain.equals(u.getPasswordHash())){
                    return u;
             }
                return null;
            }
            
            private User map(ResultSet rs) throws SQLException {
                return new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password_hash"),
                rs.getTimestamp("created_at")
                );
            }
}
