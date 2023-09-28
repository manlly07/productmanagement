package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/productmanagenet?useSSL=false";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }catch (Exception error) {
            throw new RuntimeException("Error" + error.getMessage());
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
