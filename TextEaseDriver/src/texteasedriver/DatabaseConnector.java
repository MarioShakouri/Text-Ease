package texteasedriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/textease";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2005mario";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void testConnection() {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Connection established successfully!");
                connection.close(); // Close the connection after testing
            } else {
                System.out.println("Failed to establish connection!");
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        testConnection(); // Test the connection when running the main method
    }

}