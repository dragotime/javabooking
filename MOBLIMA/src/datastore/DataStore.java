package datastore;

/**
 * DataStore interface
 * @author Haqim
 *
 */
public interface DataStore {
	
	/**
	 * The file to access the serialize file
	 */
	public final String HOLIDAY = "holiday.dat";
	
	/**
	 * The abstract method  to write int serialize file 
	 * @param object
	 */
	public void write(Object object);
	
	/**
	 * Abstract method to read the serailize object
	 * @return
	 */
	public Object read();

}
