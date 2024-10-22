package BusReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDb {
    private static String busInfoQuery="SELECT * FROM BUS";
    public static void getBusInfo() throws SQLException {
        Connection con= DatabaseConnection.getConnection();
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(busInfoQuery);
        while(rs.next()){
            System.out.println("BusNo: "+rs.getInt(1));
            System.out.println("Bus Capacity: "+rs.getInt(2));
            if(rs.getInt(3)==1){
                System.out.println("AC Status: AC");
            }
            else{
                System.out.println("AC Status: NON-AC");
            }
        }
        System.out.println("-----------------------------");
    }
    public static int busCapacity(int id) throws SQLException {
        String busCapacityQuery="SELECT CAPACITY FROM BUS WHERE Bus_No="+id;
        Connection con= DatabaseConnection.getConnection();
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(busCapacityQuery);
        rs.next();
        return rs.getInt(1);
    }
}
