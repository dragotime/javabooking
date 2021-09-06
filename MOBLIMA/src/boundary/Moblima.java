package boundary;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents the Main Movie booking System
 * @author Haqim
 *
 */
public class Moblima {
	
	/**
	 * The main function to start the application
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("\nWelcome to MOBLIMA\n");
			System.out.println(" 1. User \n 2. Admin \n 3. Exit\n");
			System.out.println("Please select a option: ");
			
			do {
				try {
					choice = scan.nextInt();
					if (choice < 1 || choice > 3 ) {
						throw new InputMismatchException("Incorrect input!!!!");
					}
					break;
				}
				catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					System.out.println("Please Re-Enter Option: ");
				}
			} while(choice != 3);
			
			if (choice == 1) {
				UIMovieGoerMain user = new UIMovieGoerMain();
				user.start();
			}
			else if (choice == 2) {
				UIAdminMain admin = new UIAdminMain();
				admin.loggedIn();
			}
			else if (choice == 3) {
				System.out.println("Exiting program......");
				System.out.println("Program terminate successfully........");
			}
		} while (choice != 1 && choice != 2 && choice != 3);
		scan.close();
	}
}
