package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//import boundary.UIMovieGoerMain;
//import control.MovieListingControl;
import entity.Transaction;
import entity.User;
import entity.Booking;

/**
 * BookingMenu
 * @author Haqim
 *
 */
public class BookingMenu {
	
	/**
	 * option
	 */
	private int option;
	
	/**
	 * scan user input
	 */
	private Scanner scan = new Scanner(System.in);
	
	/**
	 * Book AndPurchase
	 */
	private BookAndPurchase bp = new BookAndPurchase();
	
	/**
	 * MovieListingControl
	 */
	private MovieListingControl mlc = new MovieListingControl();
	//private UIMovieGoerMain main = new UIMovieGoerMain();
	
	/**
	 * Array List of User
	 */
	public ArrayList<User> userArray = new ArrayList<User>();
	
	/**
	 * Array List of Admin
	 */
	public ArrayList<User> adminArray = new ArrayList<User>();
	
	/**
	 * Book menu method
	 * @throws IOException
	 */
	public void book() throws IOException {
		
		do {
			System.out.println("Please choose the following options: ");
			System.out.println("(1) Book And Purchase");
			System.out.println("(2) View Booking History");
			System.out.println("(3) Exit");
			System.out.println("Please select choice: ");
			
			do {
				try {
					option = scan.nextInt();
					if ( option < 1 || option > 3) {
						throw new Exception("Incorrect Input!!!");
					}
					break;
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Please Re-Enter Input : ");
				}
			}while (option !=3);
			
			switch(option) {
			case 1:
				System.out.println("==========================");
				System.out.println("Book and purchase option");
				System.out.println("==========================");
				mlc.listAllMovies();
				

				try {
					bp.bookPurchase();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					// TODO Auto-generated catch block
				/*try {
					bp.bookTicketAndChooseSeat();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				break;
			case 2:
				String name, mobile, email;
				System.out.println("View Booking history");
				System.out.println("What is your name?");
				scan.nextLine(); //clear '\n'
				name = scan.nextLine();
				System.out.println("What is your mobile?");
				mobile = scan.nextLine();
				System.out.println("What is your email?");
				email = scan.nextLine();
				try {
					findUsers(name, mobile, email);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				break;	
			}
			
		} while(option != 1 && option != 2 && option != 3);
		
		System.out.println("\nPlease enter the following options");
		

	}
	
	/**
	 * loadUsers
	 * @throws Exception
	 */
	public void loadUsers() throws Exception{
		FileReader file = new FileReader("txt/Users.txt");
		BufferedReader reader = new BufferedReader(file);
		String line;
		while((line = reader.readLine()) != null){
			//Scan first object
			String text = "";
			text += line;
			
			//Break down first object into its attributes and store in array
			String[] elementsArray = text.split(";");
			
			//convert from String form to desired eNum type
			User.UserType userType = User.UserType.valueOf(elementsArray[0]);

			//instantiate movie object based on above parameters
			
			//add to array List of Users
			if(userType == User.UserType.valueOf("CUSTOMER")){
				User U1 = new User(userType, elementsArray[1], elementsArray[2], elementsArray[3]);			
				userArray.add(U1);
			}
			else {
				User U1 = new User(userType, elementsArray[1], elementsArray[2]);			
				adminArray.add(U1);
			}
			//test
			//System.out.println(U1.getUserType());
			
		}	
		reader.close();
	}
	
	/**
	 * Find Users
	 * @param name
	 * @param mobile
	 * @param email
	 * @throws IOException
	 */
	public void findUsers(String name, String mobile, String email) throws IOException{
        String userName, userMobile, userEmail;
        boolean flag = false;
        // search by name, then add to movie array
        for (User uArray: userArray) {
        	userName = uArray.getUserName().toLowerCase();
        	userMobile = uArray.getMobile().toLowerCase();
        	userEmail = uArray.getEmail().toLowerCase();
        	if(flag == false)
        		{
        			if (name.equals(userName.toLowerCase())){
        				if(mobile.equals(userMobile.toLowerCase())){
                        	if(email.equals(userEmail.toLowerCase())){
                        		System.out.println(name + ": Trying to retrieve your bookings now...");
                        		flag = true;
                        		//Load this user's bookings here
                        		System.out.println("Your bookings have been loaded!");
                        		loadUserBooking(userName, userMobile, userEmail);
                        		//Logged in successfully
                        		break;
                        	}
                        	else System.out.println("Wrong userEmail!");
                        }
                        else System.out.println("Wrong userMobile!");
        			}                
        		}
            else System.out.println("Wrong userName!");
      
        }
	}
	
	/**
	 * LoadUsers
	 * @param userName
	 * @param userMobile
	 * @param userEmail
	 * @throws IOException
	 */
	public void loadUserBooking (String userName, String userMobile, String userEmail) throws IOException{
		FileReader file = new FileReader("txt/UserBookings.txt");
		BufferedReader reader = new BufferedReader(file);
		String line;
		ArrayList<Booking> userBookingArray = new ArrayList<Booking>();

		//Transaction (User info), seat[] array,
		while((line = reader.readLine()) != null){
			//Scan first object
			String text = "";
			text += line;
			
			//Break down first object into its attributes and store in array
			String[] elementsArray = text.split(";");
			
			//only process booking if it matches user details
			if(userName.equals(elementsArray[3].toLowerCase()) && userMobile.equals(elementsArray[1].toLowerCase()) && userEmail.equals(elementsArray[2].toLowerCase())){				
				
				User.UserType userType = User.UserType.valueOf(elementsArray[0]);
				User U1 = new User(userType, elementsArray[1], elementsArray[2], elementsArray[3]);
				Transaction T1 = new Transaction(U1, elementsArray[4], (double) Double.valueOf(elementsArray[5]));
				Booking B1 = new Booking(T1);
				System.out.println(B1.toString());				
				//add to array List of Movie
				userBookingArray.add(B1);
			}
			else System.out.println("It looks like you have never booked with us before...");	

		}
		reader.close();
	}
}
