package entity;

/**
 * Cinema class
 * @author Haqim
 *
 */
public class Cinema {
	/**
	 * enum for the different types of cinemas
	 * 3 types: PLATINUM, GOLD, NORMAL
	 * Capitalised because they are constants
	 */
	public enum TypeOfCinema {
	    PLATINUM,
	    GOLD,
	    NORMAL
		}
	
	/**
	 * type of cinema according to TypeOfCinema enum
	 */
	private TypeOfCinema typeOfCinema;
	
	/**
	 * Unique cinema ID in the form AA1
	 */
	private String cinemaCode;
	
	/**
	 * No. of Rows of seats in the cinema
	 */
	private int row;
	
	/**
	 * No. of Columns of seats in the cinema
	 */
	private int col;
	
	/**
	 * No. of Empty seats in the cinema
	 */
	private int noOfEmptySeats;
	
	/**
	 * All the seats in the cinema
	 */
	private Seat[][] seats;
	
	/**
	 * Cinema Constructor: 
	 * Parameters: type of Cinema, cinemaCode, number of rows, 
	 * number of columns, seats and number of empty seats in this cinema
	 * @param typeOfCinema: type of Cinema
	 * @param cinemaCode: Cinema code of this cinema
	 * @param row: Number of rows in this cinema
	 * @param col: Number of columes in this cinema
	 * @param numOfEmptySeat: Number of EmptySeats in this cinema
	 * @param seats: Seats in this cinema
	 */
	public Cinema(TypeOfCinema typeOfCinema, String cinemaCode, int row, int col, int noOfEmptySeats, Seat[] seats){
		this.typeOfCinema = typeOfCinema;
		this.cinemaCode = cinemaCode;
		this.row = row;
		this.col = col;
		this.noOfEmptySeats = noOfEmptySeats;

		for (int rowCounter = 0; rowCounter < row; rowCounter++){
			for (int colCounter = 0; colCounter < col; colCounter++){
				
				/* Populate seats by row i.e Row 1, then Row 2 */
				this.seats[rowCounter][colCounter]=seats[rowCounter*col+colCounter];
				
				/* Concurrently set IDs of each seat */
                this.seats[rowCounter][colCounter].setSeatID('A'+rowCounter, colCounter+1);
			}
		}
		
	}
	
	/**
	 * Get the type of this cinema
	 * Returns: the type of this cinema
	 */
	public TypeOfCinema getTypeOfCinema(){
		return this.typeOfCinema;
	}
	
	/**
	 * Get a certain seat number in this cinema
	 * Parameters: row number, column number
	 * @param row: row number
	 * @param column: column number
	 */
	public Seat getSeat(int row, int col){
		return seats[row][col];
	}
	
	/**
	 * Get the number of empty seats in this cinema
	 * Returns: the number of empty seats in this cinema
	 */
	public int getNoOfEmptySeats(){
		return noOfEmptySeats;
	}
	
	/**
	 * Get the number of rows of seats in this cinema
	 * Returns: the number of rows of seats in this cinema
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * Get the number of columns of seats in this cinema
	 * Returns: the number of columns of seats in this cinema
	 */
	public int getCol(){
		return col;
	}
	
	/**
	 * Return: String representation of the cinema object
	 */
	public String toString(){
		return cinemaCode;
	}
}
