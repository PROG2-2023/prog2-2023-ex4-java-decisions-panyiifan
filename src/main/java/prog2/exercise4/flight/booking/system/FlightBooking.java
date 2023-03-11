package prog2.exercise4.flight.booking.system;

import java.time.LocalDate;

public class FlightBooking {
    final String flightCompany = "Flights-of-Fancy";
    public String flightID;
    private String passengerFullName;
    public enum TripSource{
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS};
    public enum SourceAirport {
        NanjingLukouInternationalAirport,
        BeijingCapitalInternationalAirport,
        ShanghaiPudongInternationalAirport,
        OuluAirport, HelsinkiAirport,
        ParisCharlesDGaulleAirport};
    public enum TripDestination{
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS};
    public enum DestinationAirport {
        NanjingLukouInternationalAirport,
        BeijingCapitalInternationalAirport,
        ShanghaiPudongInternationalAirport,
        OuluAirport, HelsinkiAirport,
        ParisCharlesDGaulleAirpor};
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    public double departingTicketPrice;
    public double returnTicketPrice;
    private double totalTicketPrice;
    private String ticketNumber;
    public BookingClass bookClass;
    public TripType tripType;
    public TripDestination destination;
    public TripSource source;
    public SourceAirport sourceAirport;
    public DestinationAirport destinationAirport;
    public enum BookingClass {
        FIRST,BUSINESS,ECONOMY
    };
    public enum TripType{
        ONE_WAY,RETURN
    };


    public FlightBooking(String passengerFullName, LocalDate departureDate, LocalDate returnDate, int childPassengers, int adultPassengers) {
        this.passengerFullName = passengerFullName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
    }


    public String toString(){
        return "Dear " + passengerFullName + ". Thank you for booking your flight with " + 
        flightCompany + ". Following are the details of your booking and the trip:" + "\n" + 
        "Ticket Number: " + ticketNumber + "\n" + 
        "From " + source + " to " + destination + "\n" +
        "Date of departure: " + departureDate + "\n" +
        "Date of return: " + returnDate + "\n" +
        "Total passengers: " + totalPassengers + "\n" +
        "Total ticket price in Euros: " + totalTicketPrice;
    }


    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightID(String flightID) {
        this.flightID=flightID;
    }
    public String getFlightID() {
        return flightID;
    }

    public void setPassengerFullName(String PassengerFullName) {
        this.passengerFullName=PassengerFullName;
    }
    public String getPassengerFullName() {
        return passengerFullName;
    }

    public void setTripSource(String choice3) {
        if(choice3 == "1"){
            this.source=TripSource.NANJING;
            this.sourceAirport = SourceAirport.NanjingLukouInternationalAirport;
        }
        if(choice3 == "2"){
            this.source=TripSource.BEIJING;
            this.sourceAirport = SourceAirport.BeijingCapitalInternationalAirport;
        }
        if(choice3 == "3"){
            this.source=TripSource.OULU; 
            this.sourceAirport = SourceAirport.OuluAirport;
        }
        if(choice3 == "4"){
            this.source=TripSource.HELSINKI;
            this.sourceAirport = SourceAirport.HelsinkiAirport;
        }
    }
    public TripSource getTripSource() {
        return source;    
    }
    public SourceAirport getsSourceAirport() {
        return sourceAirport;    
    }


    public void setTripDestination(String choice3,String choice4) {
        if(choice4.equals(choice3)){
            System.out.println("Wrong! Please choose again.");
        }
        else if(choice4 == "1"){
            this.destination = TripDestination.NANJING;
            this.destinationAirport = DestinationAirport.NanjingLukouInternationalAirport;
        }
        else if(choice4 == "2"){
            this.destination = TripDestination.BEIJING;
            this.destinationAirport = DestinationAirport.BeijingCapitalInternationalAirport;
        }
        else if(choice4 == "3"){
            this.destination = TripDestination.OULU; 
            this.destinationAirport = DestinationAirport.OuluAirport;
        }
        else if(choice4 == "4"){
            this.destination = TripDestination.HELSINKI; 
            this.destinationAirport = DestinationAirport.HelsinkiAirport;
        }
    }
    public TripDestination getTripDestination() {
        return destination;
    }
    public DestinationAirport getDestinationAirport() {
        return destinationAirport;
    }


    public void setDepartureDate(LocalDate departureDate){
        this.departureDate=departureDate;
    }
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setReturnDate(LocalDate returnDate){
        int result = returnDate.compareTo(departureDate);
        if(result >= 2){
            this.returnDate=returnDate;
        }else if(result == 1){
            this.returnDate = returnDate.plusDays(1);
        }else if(result == 0){
            this.returnDate = returnDate.plusDays(2);
        }else System.out.println("Wrong!");
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }


    public int getChildrenPassengers() {
        return childPassengers;
    }
    public int getAdultPassengers() {
        return adultPassengers;
    }
    public void setTotalPassengers(int childPassengers,int adultPassengers) {
        this.totalPassengers = childPassengers + adultPassengers;
    }
    public int getTotalPassengers() {
        return totalPassengers;
    }


    private String type;
    private String booking_class;
    private String place;
    public String getTicketNumber() {
        if(tripType.equals(TripType.ONE_WAY)){
            type = "11";
        }
        if(tripType.equals(TripType.RETURN)){
            type = "22";
        }
        if(bookClass.equals(BookingClass.FIRST)){
            booking_class = "F";
        }
        if(bookClass.equals(BookingClass.BUSINESS)){
            booking_class = "B";
        }
        if(bookClass.equals(BookingClass.ECONOMY)){
            booking_class = "E";
        }
        if(((source == TripSource.NANJING) && (destination == TripDestination.BEIJING))||
        ((source == TripSource.BEIJING) && (destination == TripDestination.NANJING))||
        ((source == TripSource.OULU) && (destination == TripDestination.HELSINKI))||
        ((source == TripSource.HELSINKI) && (destination == TripDestination.OULU)))
        {
            place = "DOM";
        }else{
            place = "INT";
        }
        this.ticketNumber=type+booking_class+"ILCN"+place;
        return ticketNumber;
    }


    private static double base_ticket_price = 300;
    private double Taxes;
    private double Service_fees;
    private double booking_class_charge;
    public void setDepartingTicketPrice(int child,int adults){
        if(((source == TripSource.NANJING) && (destination == TripDestination.BEIJING))||
        ((source == TripSource.BEIJING) && (destination == TripDestination.NANJING))||
        ((source == TripSource.OULU) && (destination == TripDestination.HELSINKI))||
        ((source == TripSource.HELSINKI) && (destination == TripDestination.OULU)))
        {
            Taxes=30;
            Service_fees=15;
        }else{
            Taxes=45;
            Service_fees=30;
        }
        this.departingTicketPrice = (child+adults)*(base_ticket_price + Taxes + Service_fees);

    }
    public double getDepartingTicketPrice() {
        return departingTicketPrice;
    }
    public void setReturnTicketPrice(){
        this.returnTicketPrice = departingTicketPrice;
    }
    public double getReturnTicketPrice() {
        return returnTicketPrice;
    }
    public void setTotalTicketPrice(){
        if(bookClass.equals(BookingClass.FIRST)){
            booking_class_charge = 250;
        }
        if(bookClass.equals(BookingClass.BUSINESS)){
            booking_class_charge = 150;
        }
        if(bookClass.equals(BookingClass.ECONOMY)){
            booking_class_charge = 50;
        }
        if(tripType.equals(TripType.ONE_WAY)){
        this.totalTicketPrice = departingTicketPrice + booking_class_charge;
    }
        if(tripType.equals(TripType.RETURN)){
        this.totalTicketPrice = departingTicketPrice + returnTicketPrice + booking_class_charge * 2;
    }
    }
    public double getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setBookingClass(String choice1) {
        if(choice1 == "1"){
            this.bookClass = BookingClass.FIRST; 
        }
        if(choice1 == "2"){
            this.bookClass = BookingClass.BUSINESS;
        }
        if(choice1 == "3"){
            this.bookClass = BookingClass.ECONOMY; 
        }
    }
    public BookingClass getBookingClass() {
        return bookClass;
    }

    public void setTripType(String choice2) {
        if(choice2 == "1"){
            this.tripType = TripType.ONE_WAY;
        }
        if(choice2 == "2"){
            this.tripType = TripType.RETURN;
        }
    }
    public TripType getTripType() {
        return tripType;
    }
}
