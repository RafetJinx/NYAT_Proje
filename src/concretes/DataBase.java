package concretes;

import java.sql.*;

public class DataBase {
    static String url = "jdbc:postgresql://localhost:5432/NYAT_Project";
    static Connection connection = null;

    static void connect() {
        try {
            connection = DriverManager.getConnection(url, "postgres", "rafetkanepe345");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static ResultSet list(String query) {
        try {
            Statement statement = connection.createStatement();
            return  statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
