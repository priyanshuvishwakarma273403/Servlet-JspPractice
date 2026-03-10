package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/CodingKiDuniya";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pop99558$$";

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
