package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import boundary.UIAdminMain;
import control.DateController;
import control.TicketPricing;
//import entity.MovieTicket;

/**
 * System Setting class
 * @author Haqim
 *
 */
public class SystemSetting {
	
	/**
	 * Date Controller
	 */
	private DateController dateControl = new DateController();
	
	/**
	 * Ticket Pricing
	 */
	private TicketPricing ticketpricing = new TicketPricing();
	
	/**
	 * Setting Menu
	 */
	public void settingMenu() {
		
		final String line = ("============================================");
		
		System.out.println(line);
		System.out.println("This is the System Setting");
		System.out.println("Choose the following option:");
		System.out.println("(1) Change ticket price");
		System.out.println("(2) Add holiday");
		System.out.println("(3) Remove Holiday");
		System.out.println("(4) Check Holiday");
		System.out.println("(5) Return back to Main menu");
		System.out.println("Please enter Your choice: ");
					
	}
	
	/**
	 * Configuration
	 * @throws IOException
	 */
	public void configuration() throws IOException {
		
		final String line = ("============================================");
		
		int option = 0;
		String date;
		Date day;
		boolean choice = true;
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat dateFormat;
		dateFormat = new SimpleDateFormat("dd/MM");
		
		do {
			while(choice) {
				settingMenu();
				
			try {
				option = Integer.parseInt(sc.nextLine());
				
				}
			catch (InputMismatchException e) {
				System.out.println("Please Re-enter option :");
			}
				
				switch(option) {
				case 1:
					System.out.println(line);
					ticketpricing.price();
					break;
				case 2:
					System.out.println(line);
					dateControl.printHoliday();
					System.out.println("Enter the new holiday you want to add (dd/MM):");
					date = sc.nextLine();
					while (true) {
						try {
							day = dateFormat.parse(date);
							dateControl.addHoliday(day);
						}
						catch (ParseException e) {
							System.out.println("Invalid input!!!");
						}
						break;
					}
					break;
				case 3:
					System.out.println(line);
					dateControl.printHoliday();
					System.out.println("Enter the new holiday you want to delete (dd/MM):");
					date = sc.nextLine();
					while (true) {
						try {
							day = dateFormat.parse(date);
							dateControl.deleteHoliday(day);
						}
						catch (ParseException e) {
							System.out.println("Invalid input!!!");
						}
						break;
					}
					break;
				case 4:
					System.out.println(line);
					dateControl.printHoliday();
					break;
				default:
					UIAdminMain admin = new UIAdminMain();
					admin.begin();
					choice = false;
					break;
				}
			}

		} while( option < 5);
		sc.close();
	}
	
}
