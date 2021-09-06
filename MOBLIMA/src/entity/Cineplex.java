package entity;

/**
 * Cineplex entity class
 * @author Haqim
 *
 */
public class Cineplex {
	
	/**
	 * Unique name of Cineplex
	 */
	private String nameOfCineplex;
	
	/**
	 * Cineplex is an array of 3 or more cinemas
	 * The check for >3 cinemas is done in the UI
	 */
	private Cinema[] cinemas;
	
	/**
	 * Cineplex constructor with a set name, set array of cinemas
	 * @param nameOfCineplex Name of this Cineplex
	 * @param cinemas: Array of >3 cinemas in this Cineplex
	 * @param noOfCinema: Number of cinemas in this Cineplex
	 */
	public Cineplex(String nameOfCineplex, Cinema[] cinemas, int noOfCinema){
		this.nameOfCineplex = nameOfCineplex;
		cinemas = new Cinema[noOfCinema]; 
		
		for (int i = 0; i < noOfCinema; i++){
			this.cinemas[i]=cinemas[i];
		}
	}
	
	/**
	 * Get the array of cinemas in this cineplex
	 * Return cinemas: the array of Cinemas
	 */
	public Cinema[] getCinemas() {
		return cinemas;
	}
	
	/**
	 * Get the cineplex name of this cineplex
	 * Return nameOfCineplex: name of this cineplex
	 */
	public String getCineplexName() {
		return nameOfCineplex;
	}
	
	/**
	 * set the cineplex name of this cineplex
	 * @param nameOfCineplex: New name of cineplex
	 */
	public void setCineplexName(String nameOfCineplex) {
		this.nameOfCineplex = nameOfCineplex;
	}
	
	/**
	 * Return: String representation of the cineplex object
	 */
	public String toString() {
		return nameOfCineplex;
	}
}
