package p1;

import java.sql.*;

public class DB {
    private static final String URL ="jdbc:mysql://localhost:3306/projectdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Sugarjrt3";
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            throw new RuntimeException("MySQL JDBC Driver not found" + e);
        }
    }
    
    public static Connection get() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
