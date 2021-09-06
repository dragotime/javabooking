package boundary;

import java.util.Scanner;
import java.util.InputMismatchException;

import control.SeatController;
import control.MovieListingControl;
import control.BookingMenu;

/**
 * This represents for the user menu
 * @author Haqim
 *
 */
public class UIMovieGoerMain {
	
	/**
	 * The constant to divide the section
	 */
	private final String line = ("========================================================");
	
	/**
	 * This is use to call the movie control
	 */
	private MovieListingControl mlc = new MovieListingControl();
	
	/**
	 * This represents the booking menu for the user
	 */
	private BookingMenu bm = new BookingMenu();
	
	/**
	 * This is the control class to get the seat availability
	 */
	private SeatController seatControl = new SeatController();
	//TopFiveList tfl = new TopFiveList();
	
	/**
	 * This is the starting menu for the user
	 * @throws Exception
	 */
	public void start() throws Exception{
		mlc.listMovies();
		int option = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(line);
		System.out.println("Welcome User - This is an online booking & purchase of movie tickets system");
		System.out.println(line);
		System.out.println("Choose the following options below to proceed\n");	
		
		do {
			
			System.out.println("(1) Search/List Movies");
			System.out.println("(2) View Booking Menu");
			System.out.println("(3) See the top 5 List of movies by ticket sales or by overall ratings");
			System.out.println("(4) Exit");
			System.out.println("Please Enter option: ");
			
			do{
				try {
					option = sc.nextInt();
					if (option < 1 || option > 4 ) {
						throw new InputMismatchException("Incorrect input!!!!");
					}
					break;
				}
				catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					System.out.println("Please Re-enter option: ");
				}
			}while(option !=5);
			
			switch(option) {
			case 1:
				int i;
				String s;
				mlc.listAllMovies();
				System.out.println("Which movie do you want to know more about?: ");
				i = sc.nextInt(); //must make exception to ensure within range
				mlc.getMovieInfo(i);
				System.out.println("Which movie do you want to search?: ");
				sc.nextLine(); //flush '/n' left after scanInt()
				s = sc.nextLine();
				mlc.searchMovies(s);			
				break;
			case 2:
				//mlc.listAllMovies();
				bm.loadUsers();
				bm.book();//it was .book(), but got error. I think method should be declared .book(), not sure why declared Book() in your BookingMenu class
				break;
			case 3:
				System.out.println("(1) List Movies by Sales");
				System.out.println("(2) List Movies by Ratings");
				System.out.println("(3) Exit");
				System.out.println("Please Enter option: ");
				
				do{
					try {
						option = sc.nextInt();
						if (option < 1 || option > 3 ) {
							throw new InputMismatchException("Incorrect input!!!!");
						}
						break;
					}
					catch (InputMismatchException e) {
						System.out.println(e.getMessage());
						System.out.println("Please Re-enter option: ");
					}
				}while(option !=4);
				if(option == 1)
					mlc.listTop5BySale();
				else if(option == 2)
					mlc.listTop5ByRating();
				break;
			}
			
		} while (option != 4);
		
		System.out.println("Exiting....");
		System.out.println("Program Terminated Successfully.....");
		sc.close();
	}
}
