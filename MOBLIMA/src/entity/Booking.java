package entity;

/**
 * Booking entity class
 * @author Haqim
 *
 */
public class Booking {
	
	/**
	 * transaction
	 */
	private Transaction transaction;
	
	/**
	 * Booking Constructor: 
	 * Parameters: transaction object and movieTicket object
	 * @param transaction: object containing information of the transaction
	 */
	public Booking(Transaction transaction) {
        this.transaction = transaction;
    }
	
	/**
	 * Return: String representation of the seat object
	 */
	public String toString(){
        return transaction.toString();
    }
}
