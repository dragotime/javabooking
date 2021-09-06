package control;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.IOException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;

/**
 * Ticket Pricing class
 * @author Haqim
 *
 */
public class TicketPricing {
	
	/**
	 * price to add to text file
	 */
	public void price() {
		PrintWriter out = null;
		String[] elementsArray = new String[3];
		
		elementsArray[0] = addAdultPrice();
		elementsArray[1] = addChildPrice();
		elementsArray[2] = addSeniorPrice();
		
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("txt/Ticket.txt", true)));
			
			out.println("\n" +  elementsArray[0] + ";");
			out.println("\n" +  elementsArray[1] + ";");
			out.println("\n" +  elementsArray[2] + ";");

		}
		catch (IOException e){
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		
	}

	
	/**
	 * Input the seniorprice
	 * @return
	 */
	private String addSeniorPrice() {
		// TODO Auto-generated method stub
		String SeniorPrice = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Senior Price for 3D Movie: ");
		System.out.println("For Weekday (Normal,Platinum): ");
		SeniorPrice = sc.next() + ",";
		System.out.println("For Weekend/ Holidays (Normal/ Platinum): ");
		SeniorPrice += (sc.next() + ",");
		System.out.println("Enter Price for Blockbluster Movie: ");
		System.out.println("For Weekday (Normal,Platinum): ");
		SeniorPrice += (sc.next() + ",");
		System.out.println("For Weekend/ Holidays (Normal/ Platinum): ");
		SeniorPrice += (sc.next() + ",");
		System.out.println("Enter Price for Normal Movie: ");
		System.out.println("For Weekday (Normal,Platinum): ");
		SeniorPrice += (sc.next() + ",");
		System.out.println("For Weekend/ Holidays (Normal/ Platinum): ");
		SeniorPrice += sc.next();
		return SeniorPrice;
	}

	/**
	 * inputing the child price
	 * @return
	 */
	private String addChildPrice() {
		// TODO Auto-generated method stub
		String ChildPrice = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Child Price for 3D Movie: ");
		System.out.println("For Weekday (Normal,Platinum): ");
		ChildPrice = sc.next() + ",";
		System.out.println("For Weekend/ Holidays (Normal/ Platinum): ");
		ChildPrice += (sc.next() + ",");
		System.out.println("Enter Price for Blockbluster Movie: ");
		System.out.println("For Weekday (Normal,Platinum): ");
		ChildPrice += (sc.next() + ",");
		System.out.println("For Weekend/ Holidays (Normal/ Platinum): ");
		ChildPrice += (sc.next() + ",");
		System.out.println("Enter Price for Normal Movie: ");
		System.out.println("For Weekday (Normal,Platinum): ");
		ChildPrice += (sc.next() + ",");
		System.out.println("For Weekend/ Holidays (Normal/ Platinum): ");
		ChildPrice += sc.next();
		return ChildPrice;
	}


	/**
	 * Input the adult price
	 * @return
	 */
	private String addAdultPrice() {
		// TODO Auto-generated method stub
		String AdultPrice = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Adult Ticket Price for 3D Movie: ");
		System.out.println("For Weekday (Normal,Platinum): ");
		AdultPrice = sc.next() + ",";
		System.out.println("For Weekend/ Holidays (Normal/ Platinum): ");
		AdultPrice += (sc.next() + ",");
		System.out.println("Enter Price for Blockbluster Movie: ");
		System.out.println("For Weekday (Normal,Platinum): ");
		AdultPrice += (sc.next() + ",");
		System.out.println("For Weekend/ Holidays (Normal/ Platinum): ");
		AdultPrice += (sc.next() + ",");
		System.out.println("Enter Price for Normal Movie: ");
		System.out.println("For Weekday (Normal,Platinum): ");
		AdultPrice += (sc.next() + ",");
		System.out.println("For Weekend/ Holidays (Normal/ Platinum): ");
		AdultPrice += sc.next();
		return AdultPrice;
	}

}
