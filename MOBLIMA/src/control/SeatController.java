package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import entity.Seat;
import entity.Seat.Availability;

/**
 * Seat Controller Class
 * @author Haqim
 *
 */
public class SeatController {	
	//maybe seatLauncher not necessary
	/**
	 * Launching the seat layout
	 * @param sessionID
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public int seatLauncher(int sessionID) throws NumberFormatException, IOException {
		ArrayList<Seat> seatList = new ArrayList<Seat>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Seat Control");
		int iCounterRow, iCounterCol, seats;
		char rowLetter = 'A';
		//assume seat structure in every cinema is the same, 10 rows (alphabet) and 20 columns (numbers)
		for(iCounterRow = 0; iCounterRow < 10; iCounterRow++){
			for(iCounterCol = 0; iCounterCol < 20; iCounterCol++){
				
				String seatID = "" + rowLetter + iCounterCol;
				Seat seat = new Seat(seatID);
				seat.setSeatAvailability(Availability.AVAILABLE);
				seatList.add(seat);
			}
			rowLetter++;
		}
		
		String text = seatDisplay(sessionID);
		System.out.print("How many seats do you want to book? ");
		seats = sc.nextInt();
		//if text = "Session not Found", do something
		String bookedSeats = findBookedSeats(text);
		String newBookedSeats = bookSeats(bookedSeats, seats);
		
		recordSeatsBooked(newBookedSeats,sessionID);
		return seats;
	}
	
	//retrieve bookings from text files to mark out those already booked
	/**
	 * Display the seat layout
	 * @param sessionID
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public String seatDisplay(int sessionID) throws NumberFormatException, IOException{
		FileReader file = new FileReader("txt/Sessions.txt");
		BufferedReader reader = new BufferedReader(file);
		String line;
		
		while((line = reader.readLine()) != null){
			//Scan first object
			String text = "";
			text += line;
			String takenSeats = "";
			
			//Break down first object into its attributes and store in array
			String[] elementsArray = text.split(";");
			if(Integer.parseInt(elementsArray[0]) == sessionID){
				return text;
			}
				
			}
			reader.close();
			return "Session not found!";
		}
	
	/**
	 * find the booked seat
	 * @param text
	 * @return
	 */
	public String findBookedSeats(String text){
		String[] elementsArray = text.split(";");
		int iCounter;
		char rowChar = 'J';
		String takenSeats = "";
		System.out.print("     1  2  3  4  5     6  7  8  9 10    11 12 13 14 15    16 17 18 19 20     ");
		String tempSeats[] = elementsArray[6].split(",");
		//Seats with 0 are available, 1 is unavailable
		
		for(iCounter = 0; iCounter < 200 /*200 seats total*/; iCounter++){
			if((iCounter == 0) || (iCounter)%20 == 0){
				System.out.print("\n" + rowChar + "   ");
				rowChar--;
			}
			
			if(Integer.parseInt(tempSeats[iCounter]) == 1){
				System.out.print("|x|");
				takenSeats += "" + tempSeats[iCounter] + ",";
			}
			else System.out.print("| |");
			
			if((iCounter+1)%5 == 0){
				System.out.print("   ");
			}
			
		}
		
		System.out.println("\n________________________________________________________________________");
		System.out.println("\t\t\t\t  Screen");
		System.out.println("\nLegend:  |x| = booked,  | | = available");
		
		return takenSeats;
	}
	
	
		
	/**
	 * Book Seats
	 * @param takenSeats
	 * @param seats
	 * @return
	 */
	public String bookSeats(String takenSeats, int seats){
		Scanner sc = new Scanner(System.in);
		
		String[] elementsArray = takenSeats.split(";");
		String bookedSeats = "";
		while (seats != 0) {
			if (seats > 0) {
				System.out.print("Enter a seat number that is empty, in the format 'A1', 'A2' etc: ");
				
				String temp = sc.nextLine();
				int iCounter;
				
				for(iCounter = 0; iCounter < elementsArray.length; iCounter++){
					if (elementsArray[iCounter].equalsIgnoreCase(temp) != true) {
						bookedSeats += temp ;
						seats--;
					}
				}
			} 
			if (seats == 0) {
				System.out.print("\nAre these the seats you want (Y/N)?\n");
				System.out.println(bookedSeats.toUpperCase());
				char choice = sc.nextLine().charAt(0);
					do{
						if (choice == 'N') {
							System.out.print("How many seats do you want to book?");
							seats = sc.nextInt();
							bookedSeats = "";
						}
						else if (choice == 'Y'){
							bookedSeats += takenSeats + ",";
							return bookedSeats;
						}
						else {
							System.out.print("Wrong input! Please re-enter your choice (Y/N)?\n:");
							choice = sc.nextLine().charAt(0);
						}
					}while(choice != 'N' || choice != 'Y');								
			}
			bookedSeats +=  ", ";
		}		
		return bookedSeats;
	}	
	
	/**
	 * Record the Seats that is being booked
	 * @param bookedSeats
	 * @param sessionID
	 */
	public void recordSeatsBooked(String bookedSeats, int sessionID){
		try {
	        BufferedReader file = new BufferedReader(new FileReader("txt/Sessions.txt"));
	        String line;
	        StringBuffer inputBuffer = new StringBuffer();	        
	        
	        while ((line = file.readLine()) != null) {
	        	String[] elementsArray = line.split(";");
	        	if(Integer.parseInt(elementsArray[0]) == sessionID ){
	        		String tempSeats[] = elementsArray[6].split(",");
	        		String changedSeats[] = bookedSeats.split(",");
	
	        		int iCounter;
	        		int letterInNum;
	        		for(iCounter = 0; iCounter < changedSeats.length; iCounter++){
	        			letterInNum = changedSeats[iCounter].charAt(0);
	        			changedSeats[iCounter].replaceAll("[^0-9.]", "");
	        			System.out.print("\nNot Changed: ");
	        			int i = 0;
	        			switch(letterInNum){
	        			case 'A': i = 0;
	        					break;
	        			case 'B': i = 20;
    							break;
	        			case 'C': i = 40;
								break;			
	        			case 'D': i = 60;
								break;	
	        			case 'E': i = 80;
								break;	
	        			case 'F': i = 100;
								break;	
	        			case 'G': i = 120;
								break;	
	        			case 'H': i = 140;
								break;	
	        			case 'I': i = 160;
								break;	
	        			case 'J': i = 180;
								break;	        				
	        			}
	        			i += iCounter - 1;
	        			
	        			if(Integer.parseInt(changedSeats[iCounter]) == Integer.parseInt(tempSeats[i])){
	        				System.out.print("\nChanged: " + iCounter);
	        				tempSeats[iCounter] = "1";
	        			}
	        			else System.out.println("Not Changed: ");	        			            	
	        	}
	        elementsArray[6] = "";
	        elementsArray[6] = Arrays.toString(tempSeats);
	        inputBuffer.append(elementsArray);
	        inputBuffer.append('\n');
	        String inputStr = inputBuffer.toString();

	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("txt/Sessions.txt");
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();

	    }}}catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }		
	}		
}