package texteasedriver;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import texteasedriver.DatabaseConnector;

public class User implements Serializable{
    private String username;
    private String password;

    //for storing user objects
    private static List<User> userList = new ArrayList<>();

    public User(String firstName, String lastName, String email, String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //static connection to object for database connectivity
    private static Connection connection;

    // Static block to initialize the connection when the class is loaded
    static {
        try {
            connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to create a new user account
    public static boolean createAccount(String username, String password) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO mysql.user (username, password) VALUES ( ?, ?)")) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            return true; // Return true if account creation is successful
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Return false if account creation fails
        }
    }

    public static boolean logIn(String username, String password) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM mysql.user WHERE BINARY username = ? AND BINARY password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Return true if login is successful
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Return false if login fails
        }
    }

}

