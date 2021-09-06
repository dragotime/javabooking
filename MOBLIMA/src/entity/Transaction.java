package entity;

/**
 * Transaction class
 * @author Haqim
 *
 */
public class Transaction {
	
	/**
	 * Transaction ID
	 * form of XXXYYYYMMDDhhmm 
	 * (Y : year, M : month, D : day, h : hour, m : minutes, 
	 * XXX : cinema code in letters)
	 * The format is checked in UI
	 */
	private String transactionID;
	
	/**
	 * amount paid for ticket
	 */
	private double payment;
	
	/**
	 * The user buying the ticket
	 */
	private User user;
	
	/**
	 * Transaction Constructor: 
	 * Parameters: Transaction ID of booking and amount paid by the user
	 * @param transactionID: ID of transaction
	 * @param payment: amount paid for ticket
	 */
	public Transaction(User user, String transactionID, double payment){
		this.user = user;
		this.transactionID = transactionID;
		this.payment = payment;
	}
	
	/**
	 * Include transaction ID, personal details, payment details
	 * Return: String representation of the Transaction object
	 */
	public String toString() {
        return  user.toString() + "\nTransactionID: " + transactionID + "\nPayment amount: " + "SGD" + payment ;
    }
}
