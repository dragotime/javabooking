package entity;

/**
 * MovieTicket entity class
 * @author Haqim
 *
 */
public class MovieTicket {
	
	/**
	 * MovieSession
	 */
	private MovieSession movieSession;
	
	/**
	 * seat 
	 */
	private Seat seat;
	
	/**
	 * price
	 */
	private double price;
	
	/**
	 * MovieTicket Constructor: 
	 * Parameters: movieSession object and Seat object and price of ticket
	 * @param movieSession: object containing information of the movie session
	 * @param seat: object containing information of the movie seat assigned
	 * @param price: price of the movie ticket
	 */
	public MovieTicket(MovieSession movieSession, Seat seat, double price){
		this.movieSession = movieSession;
		this.seat = seat;
		this.price = price;
	}
	
	/**
	 * Return: String representation of the seat object
	 */
	public String toString(){
		return movieSession.toString() + "\nTicket price: SGD" + price + "\nSeat: " + seat.getSeatID();
    }
	
}
