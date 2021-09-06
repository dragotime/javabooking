package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import control.MovieListingControl;
import control.SeatController;

/**
 * Book and purchase
 * @author Haqim
 *
 */
public class BookAndPurchase {
	
	/**
	 * User information for input
	 */
	String name, mobile, email,userType;
	
	/**
	 * Movie Listing Controller
	 */
	private MovieListingControl mlc = new MovieListingControl();
	
	/**
	 * Date Controller
	 */
	private DateController dateController = new DateController();
	
	/**
	 * book
	 */
	private int book = 0;
	
	/**
	 * choice
	 */
	private int choice = 0;
	
	/**
	 * sessionID
	 */
	private int sessionID;
	
	/**
	 * Seats
	 */
	private int totalSeats, adultSeats, childSeats, oldSeats;
	
	/**
	 * date
	 */
	private String date;
	
	/**
	 * transactionID
	 */
	private String transactionID = "AA2201710210800";
	
	/**
	 * price
	 */
	private String price = "11";
	
	/**
	 * BookPurchase
	 * @throws IOException
	 */
	public void bookPurchase() throws IOException{
		
		Scanner sc = new Scanner(System.in);		
		MovieListingControl mlc = new MovieListingControl();
		SeatController seatControl = new SeatController();
		CinemaController cineControl = new CinemaController();
		//User user = new User(null, null, null, null);
		
/*		// SimpleDateFormat
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		
		//Using Calendar Class
		Calendar calendar = Calendar.getInstance();
		
		// get Date from Calendar
		Date dateNow = calendar.getTime();*/
		//int day = calendar.get(Calendar.DAY_OF_WEEK);
		
		boolean done = false;

		//Date time = null;
		
		printSelection();
		
		System.out.println("=========================");
		System.out.println("Please choose a movie: ");
		mlc.listAllMovies();
				
		Scanner scan = null;
		//String line;
		//String elementsArray[] = line.split(";");
			
		try {
			scan = new Scanner(new File("txt/Movies3.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		while(!done) {
			try {
				System.out.println("Please enter your choice (Number e.g. 1,2): ");
				book = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Please Enter a valid Option (Number): ");
				continue;
			}
			done = true;
		}
		System.out.println("Please select a Cineplex: ");
		cineControl.cineControl();
		System.out.println("Please Enter choice: ");
		while(!done) {
			try {
				System.out.println("Please enter your choice (Number e.g. 1,2): ");
				book = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Please Enter a valid Option (Number): ");
				continue;
			}
			done = true;
		}
		choice = sc.nextInt();	//must be 1-3
		
		System.out.println("Please select a Cinema: ");
		cineControl.loadCinemas(choice);
		//choice = sc.nextInt();	//must be 1-3
		System.out.println("Please Enter Cinema ID(e.g 1,2,3)to proceed: ");
		choice = sc.nextInt();	//must be 1-3
		
		

		System.out.println("Please select a Date: ");
		cineControl.loadDates(choice, book);
		//dateController.Date();
		System.out.println("Your Choice (in DD/MM/YYYY format as listed in options): ");
		//addDate();
		sc.nextLine(); 
		date = sc.nextLine(); //must make sure its the exact string format though...
		//dateController.getHoliday();
		System.out.println("Please select Showtime: ");
		try {
			cineControl.loadShowtime(date);
			//cineControl.listAllShowtime();
			//cineControl.listShowtime();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Your Choice (key in the index number of session): ");
		sc.nextInt();
		System.out.println("Please choose a seat: ");
		try {
			totalSeats = seatControl.seatLauncher(sessionID);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Please choose the ticket category: ");
		System.out.println("1. How many Adult Tickets: ");
		adultSeats = sc.nextInt();	
		
		do{
			if(adultSeats > totalSeats){
			System.out.println("Too many adult tickets!");
		}
		else totalSeats -= adultSeats;
		
		if(totalSeats > 0){
			System.out.println("2. Child Tickets: ");
			childSeats = sc.nextInt();
			if(childSeats > totalSeats){
				System.out.println("Too many child tickets!");
			}
			else totalSeats -= childSeats;
		}
		
		if(totalSeats > 0){
			System.out.println("3. Senior Citizen Tickets: ");
			oldSeats = sc.nextInt();
			if(oldSeats > totalSeats){
				System.out.println("Too many elderly tickets!");
			}
			else totalSeats -= oldSeats;
		}}while(totalSeats > 0);
				
		sc.nextLine();
		//String name, mobile, email,userType;
		System.out.println("=================================");
		System.out.println("Enter your Personal Information: ");
		System.out.println("=================================");
		System.out.println("Enter your type of user (CUSTOMER or ADMIN) ");
		userType = sc.nextLine();
		System.out.println("Enter your name: ");
		name = sc.nextLine();
		System.out.println("Enter your Mobile number: ");
		mobile = sc.nextLine();
		System.out.println("Enter your email Address: ");
		email = sc.nextLine();
		System.out.println(" Your personal information is: ");
		System.out.println("Type of User : " + userType);
		System.out.println("Name : " + name);
		System.out.println("Mobile : " + mobile);
		System.out.println("Email : " + email);
		System.out.println("TransactionID : " + transactionID);
		System.out.println("Price : " + price);
		PrintWriter out = null;
		String[] elementsArray = new String[6];
		
		elementsArray[0] = userType;
		elementsArray[1] = mobile;
		elementsArray[2] = email;
		elementsArray[3] = name;
		elementsArray[4] = transactionID;
		elementsArray[5] = price;
		
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("txt/UserBookings.txt", true)));
			
			out.println(elementsArray[0] + ";"
					  + elementsArray[1] + ";"
					  + elementsArray[2] + ";"
					  + elementsArray[3] + ";"
					  + elementsArray[4] + ";"
					  + elementsArray[5] );
		}
		catch(Exception e) {
			System.err.println(e);
		}
		finally {
			if (out != null) {
				out.close();
			}
		}
		System.out.println("Ticket booked! Please collect your receipt");

	}
/*	
	private String addDate() {
		
		Scanner sc = new Scanner(System.in);
		String Date = "";
		
		Date = sc.nextLine();
		
		System.out.println("Chosen Date: " + Date);
		
		return Date;
	}*/
	

	/**
	 * Prints selection for instruction
	 */
	private void printSelection() {
		System.out.println("Please follow the following options to book ticket ");
		System.out.println("(1) Choose a movie");
		System.out.println("(2) Choose a Cinema");
		System.out.println("(2) Choose a showtime");
		System.out.println("(3) Choose a seat");
		System.out.println("(4) Please enter User Information to Confirm Selection\n");
	}


}
