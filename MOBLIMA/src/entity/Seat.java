package entity;

/**
 * This represents the class for the seat
 * @author Haqim
 *
 */
public class Seat {
	/**
	 * enum for the different types of seat availability
	 * 3 types: AVAILABLE, UNAVAILABLE, OUTOFSCOPE
	 * Capitalised because they are constants
	 */
	public enum Availability {
	    AVAILABLE,
	    UNAVAILABLE,
	    OUTOFSCOPE
		}
	
	/**
	 * Unique seat ID in the form [A][0], where the row or first [] is 
	 * represented by alphabets
	 * and the column or the second [] by digits
	 */
	private String seatID;
	
	/**
	 * type of seat availability according to Availability enum
	 */
	private Availability availability;
	
	/**
	 * Seat Constructor: 
	 * Parameters: Seat ID, availability of seat, 
	 * @param SeatID: ID of seat
	 * @param availability: availability of seat
	 */
	public Seat(String seatID){
		this.seatID = seatID;
	}
	
	/**
	 * Get the seat ID of a particular seat
	 * Return seatID: seat ID
	 */
	public String getSeatID(){
		return this.seatID;
	}
	
	/**
	 * Set unique SeatID in the form [A][0], where the row or first [] is 
	 * represented by alphabets
	 * and the column or the second [] by digits
	 * @param row: total number of rows
	 * @param col: total number of columns
	 */
	public void setSeatID(int row, int col) {
        char base = 'A';
        char letterOfRow = (char)((int)base + row);
        this.seatID = letterOfRow + "" + col;
    }
	
	/**
	 * set the seat availability of a particular seat
	 */
	public void setSeatAvailability(Availability availability) {
        this.availability = availability;
    }
	
	/**
	 * Return: type of seat availability according to enumAvailability 
	 */
	public Availability getSeatAvailability() {
        return this.availability;
    }
	
	/**
	 * Availability display: [X] = unavailable
	 * [ ] = available
	 *    = out of scope
	 * Return: String representation of the seat object
	 */
	public String toString() {
        if(availability == Availability.OUTOFSCOPE){
            return "   ";
        }
        else if (availability == Availability.UNAVAILABLE){
            return "[X]";
        }
        else {
            return "[ ]";
        }
    }
}
