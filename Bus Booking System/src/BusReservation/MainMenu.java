package BusReservation;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to our booking platform");
        try {
            BusDb.getBusInfo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int opt = 0;
        while (opt != 3) {
            System.out.println("Please ENTER your choice:");
            System.out.println("1 for Bookings\n2 for Cancellation\n3 for Exit");
            opt = sc.nextInt();
            if (opt == 1) {
                Booking booking = null;
                try {
                    booking = new Booking();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (booking.isAvailable()) {
                        BookingBb.processBooking(booking);
                    } else {
                        System.out.println("Sorry, the bus is already full in the selected date....");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (opt == 2) {
                try {
                    Cancellation.cancellation();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Thankyou for using our platform. Visit again.... ");
            }
        }

    }
}