package dao;

import model.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {

    @Override
    public boolean addUser(User user) {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try(Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isValidUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try(Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
