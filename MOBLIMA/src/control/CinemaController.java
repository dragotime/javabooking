package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import datastore.Loader;

/**
 * Cinema controller class
 * @author Haqim
 *
 */
public class CinemaController implements Loader{
	
	/**
	 * Scanner input
	 */
    private Scanner sc = new Scanner(System.in);
    
    /**
     * This is used to load the available showtime
     */
    public void loadShowtime() { 	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/Showtime.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * The method to load the cineplex into the program
     */
	public void cineControl() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/Cineplex.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * The method to read Cinemas under Cineplex
	 */	
	public void loadCinemas(int choice) throws IOException{
		int iCounter = 0;
		String line;
		File inputFile = new File("txt/Cinemas.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		try {
			while((line = reader.readLine()) != null){
			//Scan first object
			//Break down first object into its attributes and store in array
				String[] elementsArray = line.split(";");
				if(Integer.parseInt(elementsArray[0]) == (choice)){						
					System.out.println(++iCounter + ": " + elementsArray[2]);
					}
					else 
					{	
						//Skip over the movie and don't input back into the file	    
					}
					
			}
		}catch (IOException e) {
			System.err.println(e);
		}		
				
	    finally{
	    	reader.close(); 
		}		
	}
	
	/**
	 * load Dates
	 * @param choice
	 * @param movieID
	 */
	public void loadDates(int choice, int movieID){
		Scanner scan = null;
		try {
			File tempFile = new File("txt/temp.txt");
			File inputFile = new File("txt/Sessions.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			int iCounter = 0;
			String line;
			PrintWriter out = null;
			out = new PrintWriter(new BufferedWriter(new FileWriter(tempFile, true)));
			try {
				while((line = reader.readLine()) != null && iCounter < 7){
				//Scan first object
				//Break down first object into its attributes and store in array
					String[] elementsArray = line.split(";");
					if(Integer.parseInt(elementsArray[1]) != (choice) || Integer.parseInt(elementsArray[2]) != (movieID)){
						//Skip over the movie and don't input back into the file
					}
					else 
					{	

					    out.print(elementsArray[0] + ";"
					    		+ elementsArray[1] + ";"
					    		+ elementsArray[2] + ";"
					    		+ elementsArray[3] + ";"
					    		+ elementsArray[4] + ";"
					    		+ elementsArray[5] + ";"
					    		+ elementsArray[6] + "\n");
					    
					  	System.out.println(++iCounter + ": " +  elementsArray[3]);						  	
					}					
					
				}
				}catch (IOException e) {
					System.err.println(e);
				}finally{
					if(out != null){
						out.close();
					}			
				} 
			writer.close(); 
		    reader.close(); 
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	/**
	 * The method to load Showtime to Cinema by user, method overload
	 * @throws IOException 
	 */	
	
	public void loadShowtime(String date) throws IOException{
		int iCounter = 0;
		String line;
		File inputFile = new File("txt/temp.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		try {
			while((line = reader.readLine()) != null){
			//Scan first object
			//Break down first object into its attributes and store in array
				String[] elementsArray = line.split(";");
				if(elementsArray[3].equals(date)){						
						System.out.println(elementsArray[0] + ": " + elementsArray[4]);
					}
					else 
					{	
						//Skip over the movie and don't input back into the file	    
					}
					
			}
		}catch (IOException e) {
			System.err.println(e);
		}		
				
	    finally{
	    	reader.close(); 
	    }
	}
	
	/**
	 * The method to add Showtime to Cinema by admin
	 */	
	public void addShowtime() {
		Scanner sc = new Scanner(System.in);
		MovieListingControl mlc = new MovieListingControl();
		
		System.out.println("Would you like to add showtime");
		System.out.println("1. Single showtime");
		//System.out.println("2. Weekly showtime");
		System.out.println("Your choice: ");
		int show = 0;
		do {
			try{
				show = sc.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.println("Please re-enter choice: ");
				show = 1;
				sc.nextLine();
			}
		}while(true);
		mlc.listAllMovies();
		if(show == 1) {
			System.out.println("Single showtime:");
			add();

		}
		else {
			System.out.println("No showtime available");
		}
		System.out.println("Showtime added successfully");
	}
	
	/**
	 * Remove the showtime of cinema
	 * @param showtime
	 * @throws IOException
	 */
	public void removeShowtime(String showtime) throws IOException {
		File inputFile = new File("txt/Showtime.txt");
		File tempFile = new File("myTempFile1.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(showtime)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/Showtime.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" + showtime);
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid showtime!!!");
	}
	
	/**
	 * updateShowtime
	 * @param showtime
	 */
	public void updateShowtime(String showtime){
		//System.out.println("update showtime\n");
		boolean successfulRemove;
		
		try {
			BufferedReader file = new BufferedReader(new FileReader("txt/Showtime.txt"));
	        String line;
	        StringBuffer inputBuffer = new StringBuffer();
	        
	        PrintWriter out = null;
	        
	        while ((line = file.readLine()) != null) {
	        	
	        	//Scan first object
	        	String[] elementsArray = line.split(";"); 
	        	
				if(elementsArray[0].equals(showtime)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
				}
				else {
					out.println(elementsArray[0] + ";");
				}
	        	
	        	inputBuffer.append(elementsArray);
	        	inputBuffer.append("\n");
	        	
	        }
	        String inputStr = inputBuffer.toString();

	        file.close();

	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("txt/Showtime.txt");
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();
		}
		catch (Exception e) {
			System.out.println("Problem reading file.");
		}
		
	}
	
	/**
	 * load cinema
	 */
	@Override
	public void load() throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/Cinemas.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * the method to write to the text file
	 */	
	public void add() {
		PrintWriter out = null;
		String[] elementsArray = new String[1];
		
		elementsArray[0] = addShow();
		
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("txt/Showtime.txt", true)));
			
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
	}
	
	/**
	 * The method to add Showtime
	 * @return
	 */
	public String addShow() {
		String showtime = "";
		
		System.out.println("Please enter showtime: ");
		showtime = sc.nextLine();
		
		return showtime;
		
	}
	
	/**
	 * remove Movie CC1
	 * @param title
	 * @throws IOException
	 */
	public void removeCinemaMovie(String title) throws IOException{
		File inputFile = new File("txt/CC1.txt");
		File tempFile = new File("myTempFile2.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(title)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/CC1.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" );
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid showtime!!!");
	}
	
	/**
	 * Remove movie CC2
	 * @param title
	 * @throws IOException
	 */
	public void removeCinemaMovie2(String title) throws IOException{
		File inputFile = new File("txt/CC2.txt");
		File tempFile = new File("myTempFile3.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(title)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/CC2.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" );
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid showtime!!!");
	}
	
	/**
	 * Remove Movie CC3
	 * @param title
	 * @throws IOException
	 */
	public void removeCinemaMovie3(String title) throws IOException{
		File inputFile = new File("txt/CC3.txt");
		File tempFile = new File("myTempFile3.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(title)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/CC3.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" );
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid showtime!!!");
	}
	
	/**
	 * Remove Movie GV1
	 * @param title
	 * @throws IOException
	 */
	public void removeCinemaMovie4(String title) throws IOException{
		File inputFile = new File("txt/GV1.txt");
		File tempFile = new File("myTempFile3.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(title)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/GV1.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" );
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid showtime!!!");
	}
	
	/**
	 * Remove Movie GV2
	 * @param title
	 * @throws IOException
	 */
	public void removeCinemaMovie5(String title) throws IOException{
		File inputFile = new File("txt/GV1.txt");
		File tempFile = new File("myTempFile3.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(title)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/GV2.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" );
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid movie!!!");
	}
	
	/**
	 * Remove Movie ST1
	 * @param title
	 * @throws IOException
	 */
	public void removeCinemaMovie6(String title) throws IOException{
		File inputFile = new File("txt/ST1.txt");
		File tempFile = new File("myTempFile3.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(title)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/ST1.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" );
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid movie!!!");
	}
	
	/**
	 * Remove movie GV3
	 * @param title
	 * @throws IOException
	 */
	public void removeCinemaMovie7(String title) throws IOException{
		File inputFile = new File("txt/GV3.txt");
		File tempFile = new File("myTempFile3.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(title)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/GV3.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" );
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid movie!!!");
	}
	
	/**
	 * Remove movie ST2
	 * @param title
	 * @throws IOException
	 */
	public void removeCinemaMovie8(String title) throws IOException{
		File inputFile = new File("txt/ST2.txt");
		File tempFile = new File("myTempFile3.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(title)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/ST2.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" );
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid movie!!!");
	}
	
	/**
	 * Remove movie ST3
	 * @param title
	 * @throws IOException
	 */
	public void removeCinemaMovie9(String title) throws IOException{
		File inputFile = new File("txt/ST3.txt");
		File tempFile = new File("myTempFile3.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(inputFile, true)));
		try {
			while ((line = reader.readLine()) != null) {
				//Scan first object
				
				String[] elementsArray = line.split(";");
				if(elementsArray[0].equals(title)) {
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
					FileOutputStream fileOut = new FileOutputStream("txt/ST3.txt");
				}
				else {
					out.println(elementsArray[0] + ";");
				}
				
			}			
						
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
		writer.close();
		reader.close();
		boolean successfulOverwrite = tempFile.renameTo(inputFile);
		if(successfulRemove == true && successfulOverwrite == true) {
			System.out.println("Successfully Removed" );
		}
		else if(successfulOverwrite != true) {
			System.out.println("Removed!!!");
		}
		else System.out.println("Sorry, invalid movie!!!");
	}
	
	/**
	 * load CC1
	 */
    public void loadCC1() { 	
    	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/CC1.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    /**
     * load CC2
     */
    public void loadCC2() { 	
    	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/CC2.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * load CC3
     */
    public void loadCC3() { 	
    	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/CC3.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * load GV1
     */
    public void loadGV1() { 	
    	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/GV1.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * load GV2
     */
    public void loadGV2() { 	
    	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/GV2.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * load GV3
     */
    public void loadGV3() { 	
    	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/GV3.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * load ST1
     */
    public void loadST1() { 	
    	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/ST1.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * load ST2
     */
    public void loadST2() { 	
    	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/ST2.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * load ST3
     */
    public void loadST3() { 	
    	
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/ST3.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Flush cinema
     */
	@Override
	public void flush() throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter writer = new PrintWriter("txt/Cinemas");
		writer.close();
	}

}
