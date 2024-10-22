package BusReservation;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {

    String passengerName;
    int busNo;
    Date date;


     Booking() throws ParseException {
         Scanner sc= new Scanner(System.in);
         System.out.println("Enter Passenger Name: ");
         passengerName= sc.nextLine();
         System.out.println("Enter bus no: ");
         busNo= sc.nextInt();
         sc.nextLine();
         System.out.println("Enter date: ");
         String userinput= sc.nextLine();
         SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");
         try {
             date= df.parse(userinput);
         } catch (ParseException e) {
             throw new RuntimeException(e);
         }

    }

    public boolean isAvailable() throws SQLException {
        int ovrcap=BusDb.busCapacity(this.busNo);
        int curcap=BookingBb.isBooked(this.busNo,this.date);
        return ovrcap>=curcap;
    }

}
