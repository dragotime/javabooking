package boundary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.InputMismatchException;
import java.util.Scanner;

import control.AdminDatabase;
import control.MovieListingControl;
import control.CinemaController;
import control.SystemSetting;

/**
 * This represents the main class for the admin menu
 * @author Haqim
 *
 */
public class UIAdminMain {
	
	/**
	 * The line constant
	 */
	private final static String line = ("============================================");
	
	/**
	 * admin database to access login info
	 */
	private AdminDatabase ad = new AdminDatabase();
	
	/**
	 * Movie Listing controller
	 */
	private MovieListingControl mlc = new MovieListingControl();
	//TopFiveList topFive = new TopFiveList();
	/**
	 * Cinema controller
	 */
	private CinemaController cineControl = new CinemaController();
	
	/**
	 * The System Setting
	 */
	private SystemSetting systemSetting = new SystemSetting();
	
	/**
	 * Scanner input
	 */
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Login to enter the Admin Menu
	 * @throws IOException
	 */
	public void loggedIn() throws IOException {
		boolean logon = false;
		logon = login(logon);
		
		if (logon) {
			System.out.println("Logged in Successfully!!!!!");
			begin();
		}
	}
	
	/**
	 * Begin the Admin Menu to start 
	 * @throws IOException
	 */
	public void begin() throws IOException {	
		adminMenu();
		int choice = 0;
		do {
			
			while(sc.hasNextLine()) {
				
				choice = sc.nextInt();
				
				switch(choice) {
				case 1:
					mlc.addMovies();
					break;
				case 2:
					System.out.println("Key in the Movie Title to remove : ");
					//Remove trailing line
					sc.nextLine();
					String movieTitle = sc.nextLine();
					mlc.removeMovie(movieTitle);
					break;
				case 3:
					System.out.println("Option 3");
					adminMenu();
					break;
				case 4:
					int option = 0;
					System.out.println("Which Cinema you want to add Movie:");
					cineControl.load();
					System.out.println("Please Enter a choice (Number):");
					System.out.println("Please Enter 10 to exit.");
					do {
						option = sc.nextInt();
						
						if (option == 1) {
							System.out.println("Please Choose Movie to add into Cinema: ");
							loadMovie();
							PrintWriter out = null;
							String[] elementsArray = new String[1];
							
							elementsArray[0] = mlc.addMovieTitle();
							
							try {
								out = new PrintWriter(new BufferedWriter(new FileWriter("txt/CC1.txt", true)));
								
								out.println(elementsArray[0] + ";");
							}
							catch(Exception e) {
								System.err.println(e);
							}
							finally {
								if (out != null) {
									out.close();
								}
							}
							
							System.out.println("Please Enter 10 to exit: ");							
						}
						else if (option == 2) {
							System.out.println("Please Choose Movie to add into Cinema: ");
							loadMovie();
							PrintWriter output = null;
							String[] elementsArray = new String[1];
							
							elementsArray[0] = mlc.addMovieTitle();
							
							try {
								output = new PrintWriter(new BufferedWriter(new FileWriter("txt/CC2.txt", true)));
								
								output.println(elementsArray[0] + ";");
							}
							catch (Exception e) {
								System.err.println(e);
							}
								finally {
									if (output != null) {
										output.close();
									}
							}
							System.out.println("Please Enter 10 to exit: ");
						}
						else if (option == 3) {
							System.out.println("Please Choose Movie to add into Platinum Cinema: ");
							loadMovie();
							PrintWriter out3 = null;
							String[] elementsArray = new String[1];
							
							elementsArray[0] = mlc.addMovieTitle();
							
							try {
								out3 = new PrintWriter(new BufferedWriter(new FileWriter("txt/CC3.txt", true)));
								
								out3.println(elementsArray[0] + ";");
							}
							catch (Exception e) {
								System.err.println(e);
							}
								finally {
									if (out3 != null) {
										out3.close();
									}
							}
							
							System.out.println("Please Enter 10 to exit: ");
						}
						else if (option == 4) {
							System.out.println("Please Choose Movie to add into Cinema: ");
							loadMovie();
							PrintWriter out4 = null;
							String[] elementsArray = new String[1];
							
							elementsArray[0] = mlc.addMovieTitle();
							
							try {
								out4 = new PrintWriter(new BufferedWriter(new FileWriter("txt/GV1.txt", true)));
								
								out4.println(elementsArray[0] + ";");
							}
							catch (Exception e) {
								System.err.println(e);
							}
								finally {
									if (out4 != null) {
										out4.close();
									}
							}
							System.out.println("Please Enter 10 to exit: ");
						}
						else if (option == 5) {
							System.out.println("Please Choose Movie to add into Cinema: ");
							loadMovie();
							PrintWriter out5 = null;
							String[] elementsArray = new String[1];
							
							elementsArray[0] = mlc.addMovieTitle();
							
							try {
								out5 = new PrintWriter(new BufferedWriter(new FileWriter("txt/GV2.txt", true)));
								
								out5.println(elementsArray[0] + ";");
							}
							catch (Exception e) {
								System.err.println(e);
							}
								finally {
									if (out5 != null) {
										out5.close();
									}
							}							
							System.out.println("Please Enter 10 to exit: ");
						}
						else if (option == 6) {
							System.out.println("Please Choose Movie to add into Platinum Cinema: ");
							loadMovie();
							PrintWriter out6 = null;
							String[] elementsArray = new String[1];
							
							elementsArray[0] = mlc.addMovieTitle();
							
							try {
								out6 = new PrintWriter(new BufferedWriter(new FileWriter("txt/GV3.txt", true)));
								
								out6.println(elementsArray[0] + ";");
							}
							catch (Exception e) {
								System.err.println(e);
							}
								finally {
									if (out6 != null) {
										out6.close();
									}
							}
							System.out.println("Please Enter 10 to exit: ");
						}
						else if (option == 7) {
							System.out.println("Please Choose Movie to add into Cinema: ");
							loadMovie();
							PrintWriter out7 = null;
							String[] elementsArray = new String[1];
							
							elementsArray[0] = mlc.addMovieTitle();
							
							try {
								out7 = new PrintWriter(new BufferedWriter(new FileWriter("txt/ST1.txt", true)));
								
								out7.println(elementsArray[0] + ";");
							}
							catch (Exception e) {
								System.err.println(e);
							}
								finally {
									if (out7 != null) {
										out7.close();
									}
							}
							System.out.println("Please Enter 10 to exit: ");
						}
						else if (option == 8) {
							System.out.println("Please Choose Movie to add into Cinema: ");
							loadMovie();
							PrintWriter out8 = null;
							String[] elementsArray = new String[1];
							
							elementsArray[0] = mlc.addMovieTitle();
							
							try {
								out8 = new PrintWriter(new BufferedWriter(new FileWriter("txt/ST2.txt", true)));
								
								out8.println(elementsArray[0] + ";");
							}
							catch (Exception e) {
								System.err.println(e);
							}
								finally {
									if (out8 != null) {
										out8.close();
									}
							}
							System.out.println("Please Enter 10 to exit: ");
						}
						else if (option == 9) {
							System.out.println("Please Choose Movie to add into Platinum Cinema: ");
							loadMovie();
							PrintWriter out9 = null;
							String[] elementsArray = new String[1];
							
							elementsArray[0] = mlc.addMovieTitle();
							
							try {
								out9 = new PrintWriter(new BufferedWriter(new FileWriter("txt/ST3.txt", true)));
								
								out9.println(elementsArray[0] + ";");
							}
							catch (Exception e) {
								System.err.println(e);
							}
								finally {
									if (out9 != null) {
										out9.close();
									}
							}
							System.out.println("Please Enter 10 to exit: ");
						}
					}while (option != 10);
					adminMenu();
					break;
				case 5:
					int opt = 0;
					System.out.println("Which Cinema you want to remove movie: ");
					cineControl.load();
					System.out.println("Please Enter a choice (Number):");
					System.out.println("Please Enter 10 to exit.");
					do {
						opt = sc.nextInt();
						
						if(opt == 1) {
							System.out.println("Please Choose Movie to remove from Cinema: ");
							cineControl.loadCC1();
							System.out.println("Enter input: ");
							sc.nextLine();
							String title = sc.nextLine();
							cineControl.removeCinemaMovie(title);
							System.out.println("Please Enter 10 to exit.");
						}
						else if(opt == 2) {
							System.out.println("Please Choose Movie to remove from Cinema: ");
							cineControl.loadCC2();
							System.out.println("Enter input: ");
							sc.nextLine();
							String title = sc.nextLine();
							cineControl.removeCinemaMovie2(title);
							System.out.println("Please Enter 10 to exit.");
						}
						else if(opt == 3) {
							System.out.println("Please Choose Movie to remove from Cinema: ");
							cineControl.loadCC3();
							System.out.println("Enter input: ");
							sc.nextLine();
							String title = sc.nextLine();
							cineControl.removeCinemaMovie3(title);
							System.out.println("Please Enter 10 to exit.");
						}
						else if(opt == 4) {
							System.out.println("Please Choose Movie to remove from Cinema: ");
							cineControl.loadGV1();
							System.out.println("Enter input: ");
							sc.nextLine();
							String title = sc.nextLine();
							cineControl.removeCinemaMovie4(title);
							System.out.println("Please Enter 10 to exit.");
						}
						else if(opt == 5) {
							System.out.println("Please Choose Movie to remove from Cinema: ");
							cineControl.loadGV2();
							System.out.println("Enter input: ");
							sc.nextLine();
							String title = sc.nextLine();
							cineControl.removeCinemaMovie5(title);
							System.out.println("Please Enter 10 to exit.");
						}
						else if(opt == 6) {
							System.out.println("Please Choose Movie to remove from Cinema: ");
							cineControl.loadGV3();
							System.out.println("Enter input: ");
							sc.nextLine();
							String title = sc.nextLine();
							cineControl.removeCinemaMovie6(title);
							System.out.println("Please Enter 10 to exit.");
						}
						else if(opt == 7) {
							System.out.println("Please Choose Movie to remove from Cinema: ");
							cineControl.loadST1();
							System.out.println("Enter input: ");
							sc.nextLine();
							String title = sc.nextLine();
							cineControl.removeCinemaMovie7(title);
							System.out.println("Please Enter 10 to exit.");
						}
						else if(opt == 8) {
							System.out.println("Please Choose Movie to remove from Cinema: ");
							cineControl.loadST2();
							System.out.println("Enter input: ");
							sc.nextLine();
							String title = sc.nextLine();
							cineControl.removeCinemaMovie8(title);
							System.out.println("Please Enter 10 to exit.");
						}
						else if(opt == 9) {
							System.out.println("Please Choose Movie to remove from Cinema: ");
							cineControl.loadST3();
							System.out.println("Enter input: ");
							sc.nextLine();
							String title = sc.nextLine();
							cineControl.removeCinemaMovie9(title);
							System.out.println("Please Enter 10 to exit.");
						}
						
					} while(opt != 10);
					//cineControl.loadCC1();
					//System.out.println("Enter input: ");
					//sc.nextLine();
					//String title = sc.nextLine();
					//cineControl.removeCinemaMovie(title);
					adminMenu();
					break;
				case 6:
					System.out.println("Which Cinema to update movie: ");
					cineControl.load();
					sc.nextLine();
					break;
				case 7:
					cineControl.addShowtime();
					adminMenu();
					break;
				case 8:
					System.out.println("Which showtime to remove :");
					cineControl.loadShowtime();
					System.out.println("Enter input: ");
					sc.nextLine();
					String showtime = sc.nextLine();
					cineControl.removeShowtime(showtime);
					adminMenu();
					break;
				case 9:
					System.out.println("Which Showtime to update: ");
					cineControl.load();
					adminMenu();
					break;
				case 10:
					systemSetting.configuration();
					break;
				case 11:
					System.out.println("Exiting........");
					System.out.println("Program Terminating...............");
					//start = false;
					break;
				}	
			}
		}while(choice != 13);
		sc.close();
	}
	/**
	Print Administrator Menu
	*/
	public void adminMenu() {
		System.out.println(line);
		System.out.println("Welcome Administrator!!");
		System.out.println(line);
		System.out.println("Please Choose the following options : ");
		System.out.println("(1) Add Movie into List ");
		System.out.println("(2) Remove Movie from List ");
		System.out.println("(3) Update Movie from List ");//
		System.out.println("(4) Add new Movie to cinema");
		System.out.println("(5) Remove Movie from cinema");//
		System.out.println("(6) Update Movie to cinema");//
		System.out.println("(7) Add Cinema Showtime ");
		System.out.println("(8) Remove Cinema Showtime ");
		System.out.println("(9) Update Cinema Showtime ");//
		//System.out.println("(10) Add Current Top 5 movies from list by ticket sales");
		//System.out.println("(11) Add Current Top 5 movies from list by overall rating  ");
		System.out.println("(10) Configure System Settings ");
		System.out.println("(11) Exit ");
		System.out.println("\nPlease enter your choice: ");
	}
	
	/**
	 * Login menu to access the Admin System
	 * @param logon
	 * @return
	 */
	private boolean login(boolean logon) {
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Please Login to access the System");
			System.out.println("Admin ID : ");
			String username = sc.nextLine();
			System.out.println("Password : ");
			String password = sc.nextLine();
			logon = ad.login(username, password);
			if(logon) break;
			else System.out.println("Please Try again!!!");
		}
		return logon;
	}
	
	/**
	 * load of Movie
	 */
	private void loadMovie() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/Movies3.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
