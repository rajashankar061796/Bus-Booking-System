package BusReservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cancellation {
    static int id;
    static String name;
    static String date;
    public static void cancellation() throws ParseException, SQLException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the busNo:");
        id= sc.nextInt();
        sc.nextLine();
        System.out.println("passenger's name: ");
        name= sc.nextLine();
        System.out.println("date(yyyy-mm-dd):");
        date= sc.next();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
        Date input= dateFormat.parse(date);
        Boolean result= BookingBb.cancelBooking(id,name,input);
        if(result == true){
            System.out.println("Cancelled your booking.");
        }
        else{
            System.out.println("Cancellation is not happened.");
        }

    }
}
