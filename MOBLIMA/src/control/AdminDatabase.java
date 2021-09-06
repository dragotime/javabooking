package control;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Admin Database class
 * @author Haqim
 *
 */
public class AdminDatabase {
	
	/**
	 * Admin username
	 */
	private final String name = "Admin";
	
	/**
	 * Admin Password
	 */
	private final String pass = "Password";
	
	/**
	 * Admin Login
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password) {
		
		
		if(name.equals(username) && pass.equals(password)) {
			return true;
			
		}
		System.out.println("Wrong Admin ID / Password");
		return false;
	}
	
	
	
	
/*	public void adminID() throws IOException {
		System.out.println("Please Enter Admin ID : ");
		Scanner admin = new Scanner(new FileReader("txt/Admin.txt"));
		Scanner input = new Scanner(System.in);
		
		String input_adminID = input.next();
		String real_adminID = admin.nextLine();
		
				
		while (!input_adminID.equals(real_adminID)) {
			System.out.print("Password Incorrect, please re-enter: ");
			input_adminID = input.next();
		}
		
		System.out.println("Logged In successfully!!!!\n");
		admin.close();
		input.close();
	}*/
	

}
