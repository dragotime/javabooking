package control;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import datastore.DataStore;

/**
 * Date Controller class
 * @author Haqim
 *
 */
public class DateController implements DataStore {
	
	//DataStore dataStore = new DataStore();
	
	/**
	 * Array List  of holiday
	 */
	private ArrayList<Date> holiday;
	
	
	/**
	 * 
	 *  Constructor for new DateController
	 */
	@SuppressWarnings("unchecked")
	public DateController() {
		File file = new File("holiday.dat");	
		
		if(!file.exists()) {
			holiday = new ArrayList<>();
			write(holiday);			
		}
		else {
			holiday = (ArrayList<Date>) read() ;
		}
		
	}
	
	/**
	 * get holiday
	 * @return
	 */
	public ArrayList<Date> getHoliday(){
		return holiday;
	}
	
	/**
	 * Adding of holiday
	 * @param time
	 */
	public void addHoliday(Date time) {
		if(holiday.contains(time)) {
			System.out.println("The holiday has already been added in the system!!!");
		}
		else {
			holiday.add(time);
			System.out.println("The new holiday has been successfully added in the system!!!");
			write(holiday);
		}
	}
	
	/**
	 * Delete of holiday
	 * @param time
	 */
	public void deleteHoliday(Date time) {
		if(holiday.contains(time)) {
			System.out.println("Successfully deleted holiday in the system!!!");
			holiday.remove(time);
		}
		else {
			System.out.println("This day is not a holiday");
			write(holiday);
		}
	}
	
	/**
	 * Converting the date
	 * @param time
	 * @return
	 */
	public String dateConvert(Date time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d");
		return dateFormat.format(time);
	}
	
	/**
	 * checking of holiday
	 * @param time
	 * @return
	 */
	public boolean checkHoliday(Date time) {
		for (int i = 0; i < holiday.size(); i++) {
			if (dateConvert(holiday.get(i)).equals(dateConvert(time))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * printing of holiday
	 */
	public void printHoliday() {
		if(holiday.isEmpty()) {
			System.out.println("No holiday is in the system");
		}
		else {
			System.out.println("The holiday dates in the system are :");
			for(int i = 0; i< holiday.size(); i++) {
				System.out.println((i+1) + "." + dateConvert(holiday.get(i)));
			}
		}
	}
	
	/**
	 * get date from txt file
	 */
	public void Date() {
    	Scanner scan = null;
		try {
			scan = new Scanner(new File("txt/Date.txt"));
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Write date in serialize data
	 */
	@Override
	public void write(Object holiday) {
		datastore.SerializeDB.writeSerializedObject(HOLIDAY, holiday);
	}
	
	/**
	 * Read date in serialize data
	 */
	@Override
	public Object read() {
		return datastore.SerializeDB.readSerializedObject(HOLIDAY);
	}
	


}
