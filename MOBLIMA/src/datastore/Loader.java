package datastore;

import java.io.FileNotFoundException;

/**
 * Loader interface
 * @author Haqim
 *
 */
public interface Loader {
	
	/**
	 * load abstract method
	 * @throws FileNotFoundException
	 */
	public void load() throws FileNotFoundException;
	
	/**
	 * flush abstract method
	 * @throws FileNotFoundException
	 */
	public void flush() throws FileNotFoundException;
	
	

}
