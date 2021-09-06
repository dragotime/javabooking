package entity;

/**
 * User entity class
 * @author Haqim
 *
 */
public class User {
	
	/**
	 * enum for the different types of users
	 * 2 types: ADMIN, CUSTOMER
	 * Capitalised because they are constants
	 */
	public enum UserType{
		ADMIN, 
		CUSTOMER
		}
	
	/*
	 * enum for the different types of age groups
	 * 3 types: STUDENT, ELDERLY, ADULT, CHILD
	 * Capitalised because they are constants
	 */
	/*public enum AgeCategory {
	    STUDENT,
	    ELDERLY,
	    NORMAL,
	    CHILD
		}
	*/
	
	/**
	 * Type of User based on UserType enum
	 */
    private UserType userType;
    
	/*
	 * Age group of User based on ageCategory enum
	 */
	//private AgeCategory ageCategory;
	
    /**
	 * Mobile number of user
	 */
	private String mobile;
	
	/**
	 * Email of User
	 */
	private String email;
	
	/**
	 * Username of User
	 */
	private String userName;
	
	/**
	 * Password of User
	 */
	private String password;
	
	/**
	 * User Constructor: 
	 * Parameters: type of User, their mobile number, email, 
	 * username and password
	 * @param userType: type of User
	 * @param mobile: Mobile no. in string format
	 * @param email: email of user
	 * @param userName: username of user
	 * @param password: password of user
	 */
	public User(UserType userType, String userName, String password){
		//Admin
		this.userType = userType;
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * Constructor for admin
	 * @param userType
	 * @param mobile
	 * @param email
	 * @param userName
	 */
	public User(UserType userType, String mobile, String email, String userName){
		//User
		this.userType = userType;
		this.mobile = mobile;
		this.email = email;
		this.userName = userName;
	}
	/**
	 * Get the user name of a user
	 * Return userName: user name
	 */
	public String getUserName(){
		return this.userName;
	}
	
	/**
	 * Get the mobile no. of a user
	 * Return mobile: mobile number
	 */
	public String getMobile(){
		return this.mobile;
	}
	
	/**
	 * Get the email of a user
	 * Return email: email
	 */
	public String getEmail(){
		return this.email;
	}
	
	/*
	 * Get the age group of the user
	 * Returns: the age group of the user
	 */
	/*public AgeCategory getAgeCategory(){
		return this.ageCategory;
	}*/
	
	/*
	 * Set the age group of the user
	 */
	/*public void setAgeCategory(AgeCategory ageCategory){
		this.ageCategory = ageCategory;
	}*/
	
	/**
	 * Get the user type of the user
	 * Returns: the userType of the user in string
	 */
	public String getUserType(){
		return this.userType.name();
	}
	
	/**
	 * Convert to string
	 */
	public String toString(){
		//only to be used by User, if used by Admin got error
		return "\nUser: " + userName + "\nMobile Number: " + mobile + "\nEmail: " + email; 
	}
	/*public List<Booking> getPastBookings() {
        return pastBookings;
    }
	
	public void addBooking(Booking newBooking) {
        pastBookings.add(newBooking);
    }*/
}
