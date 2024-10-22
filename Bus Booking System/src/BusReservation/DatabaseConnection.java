package BusReservation;
import java.sql.*;

public class DatabaseConnection {
    private static String url= "jdbc:mysql://localhost:3306/busreservation";
    private static String un= "root";
    private static String pw= "becky";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,un,pw);
    }
}
