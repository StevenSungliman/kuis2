package kuis2.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kuis2.model.CategoryUser;
import kuis2.model.User;

/**
 *
 * @author lenovo
 */
public class DatabaseController {

    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean add() {
        conn.connect();
        return true;
    }

    public static boolean addUser(User user) {
        conn.connect();
        String query = "INSERT INTO user VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getIdCategory());
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public static ArrayList getUser(int idCategory) {
        conn.connect();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String query = "SELECT * FROM user WHERE category='" + idCategory + "'";
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("category"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
    
    public static User getUserByID(int id) {
        conn.connect();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String query = "SELECT * FROM user WHERE id='" + id + "'";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }
    
    public static User getUserByEmail(String email) {
        conn.connect();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String query = "SELECT * FROM user WHERE email='" + email + "'";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }
    
    public static boolean updateUser(User user) {
        conn.connect();
        String query = "UPDATE user SET "
                + "name='" + user.getName() + "', "
                + "email='" + user.getEmail() + "', "
                + "password='" + user.getPassword() + "', "
                + "category='" + user.getIdCategory() + "'"
                + "WHERE id='" + user.getId() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean deleteUser(int id) {
        conn.connect();

        String query = "DELETE FROM user WHERE id='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static ArrayList getCategory() {
        conn.connect();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String query = "SELECT * FROM category_user";
        ArrayList<CategoryUser> categories = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser category = new CategoryUser();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (categories);
    }
}
