package BusReservation;


import java.sql.*;
import java.util.*;
import java.lang.Math;
import java.util.Date;

public class BookingBb  {
    public static int isBooked(int id, Date date) throws SQLException {
        String busCapacityQuery="SELECT COUNT(Bus_No) FROM BOOKINGS WHERE Bus_No=? AND Travelling_Date=?";
        Connection con= DatabaseConnection.getConnection();
        PreparedStatement pst= con.prepareStatement(busCapacityQuery);
        pst.setInt(1,id);
        java.sql.Date sqldate= new java.sql.Date(date.getTime());
        pst.setDate(2,sqldate);
        ResultSet rs= pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public static void processBooking(Booking booking) throws SQLException{


        Connection con = DatabaseConnection.getConnection();
        String currentBookingQuery = "INSERT INTO BOOKINGS VALUES(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(currentBookingQuery);
        pst.setInt(1, booking.busNo);
        pst.setString(2, booking.passengerName);
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        pst.setDate(3, sqldate);
        Random rand = new Random();
        int randomNumber = 10000000 + rand.nextInt(90000000);
        pst.setInt(4, randomNumber);
        int rs = pst.executeUpdate();
        System.out.println("Booked your bus successfully.");
    }
     public static boolean cancelBooking(int id, String name, Date date) throws SQLException {
         String currentBookingQuery="DELETE FROM BOOKINGS WHERE Bus_No=? AND Passenger_Name=? AND Travelling_Date=?";
         Connection con= DatabaseConnection.getConnection();
         PreparedStatement pst= con.prepareStatement(currentBookingQuery);
         pst.setInt(1,id);
         pst.setString(2,name);
         java.sql.Date sqldate= new java.sql.Date(date.getTime());
         pst.setDate(3,sqldate);
         int rs= pst.executeUpdate();
         if(rs == 1){
             return true;
         }
         return false;
     }
}
