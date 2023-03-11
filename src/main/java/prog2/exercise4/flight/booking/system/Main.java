package prog2.exercise4.flight.booking.system;

/**
 * Hello world!
 *
 */
import java.util.Scanner;
import java.time.LocalDate;


public class Main 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please give your fullname");
        String passengerFullName = input.nextLine();
        FlightBooking fb = new FlightBooking(passengerFullName, null, null, 0, 0);   
        
        System.out.println("Please pick your choice of class you would like to travel in\n1. First\n2. Business\n3. Economy"); 
        int a = input.nextInt();
        String choice1 = new String();
        switch(a){
            case 1:
            choice1 = "1";
            fb.setBookingClass(choice1);
            break;
            case 2:
            choice1 = "2";
            fb.setBookingClass(choice1);
            break;
            case 3:
            choice1 = "3";
            fb.setBookingClass(choice1);
            break;
        }
        
        System.out.println("Please choose your tripType\n1. One way\n2. Return");
        int b = input.nextInt();
        String choice2 = new String();
        switch(b){
            case 1:
            choice2 = "1";
            fb.setTripType(choice2);
            break;
            case 2:
            choice2 = "2";
            fb.setTripType(choice2);
            break;
        }
        
        System.out.println("Please choose your sources\n1. Nanjing\n2. Beijing\n3. Oulu\n4. Helsinki");
        int c = input.nextInt();
        String choice3 = new String();
        switch(c){
            case 1:
            choice3 = "1";
            fb.setTripSource(choice3);
            break;
            case 2:
            choice3 = "2";
            fb.setTripSource(choice3);
            break;
            case 3:
            choice3 = "3";
            fb.setTripSource(choice3);
            break;
            case 4:
            choice3 = "4";
            fb.setTripSource(choice3);
            break;
        }
          
        System.out.println("Please choose your destinations\n1. Nanjing\n2. Beijing\n3. Oulu\n4. Helsinki");
        int d = input.nextInt();
        String choice4 = new String();
        switch(d){
            case 1:
            choice4 = "1";
            fb.setTripDestination(choice3,choice4);
            break;
            case 2:
            choice4 = "2";
            fb.setTripDestination(choice3,choice4);
            break;
            case 3:
            choice4 = "3";
            fb.setTripDestination(choice3,choice4);
            break;
            case 4:
            choice4 = "4";
            fb.setTripDestination(choice3,choice4);
            break;
        }

        fb.getBookingClass();
        fb.getTripType();
        fb.getTripSource();
        fb.getTripDestination();

        Scanner input1 = new Scanner(System.in);
        System.out.println("Please give the date of departure");
        String sdepart = input1.nextLine();
        LocalDate depart = LocalDate.parse(sdepart);
        fb.setDepartureDate(depart);
        
        System.out.println("Please give the date of return");
        String sreturn = input1.nextLine();
        LocalDate returnDate = LocalDate.parse(sreturn);
        fb.setReturnDate(returnDate);
       
        input.close();
        input1.close();

        fb.setTotalPassengers(2, 3);
        fb.setFlightID("FOF"+"0345"+"IN");        
        fb.setDepartingTicketPrice(2, 3);
        fb.setReturnTicketPrice();
        fb.setTotalTicketPrice();
        fb.getDepartingTicketPrice();
        fb.getReturnTicketPrice();
          
        String company = fb.getFlightCompany();
        String ticketNumber = fb.getTicketNumber();
        LocalDate departure = fb.getDepartureDate();
        LocalDate returningDate = fb.getReturnDate();
        int totalPassengers = fb.getTotalPassengers();
        double totalTicketPrice = fb.getTotalTicketPrice();
        
        System.out.println("Dear " + passengerFullName + ". Thank you for booking your flight with " + 
        company + ". Following are the details of your booking and the trip:" + "\n" + 
        "Ticket Number: " + ticketNumber + "\n" + 
        "From " + fb.getTripSource() + " to " + fb.getTripDestination() + "\n" +
        "Date of departure: " + departure + "\n" +
        "Date of return: " + returningDate + "\n" +
        "Total passengers: " + totalPassengers + "\n" +
        "Total ticket price in Euros: " + totalTicketPrice);

        int result = returnDate.compareTo(departure);
        if(result==1||result==0){
            System.out.println("\nIMPORTANT NOTICE: As per our policy, the return date was changed because it was less than two days apart from your departure date.");
        }
    }
}
