package entity;

/**
 * This represents the class for Rating Adnd Review
 * @author Group 2
 *
 */
public class RatingAndReview {
	
	/**
	 * 
     * The rating of the movie
     */
	private double rating;
	
	/**
     * The comments on the movie
     */
	private String review;
	
	/**
     * RatingAndReview object constructor based on user rating and review
     * @param review: The comment on the movie
     * @param rating: The rating on the movie
     */
	public RatingAndReview(double rating, String review){		
        this.rating = rating;
        this.review = review;
	}
	
	/**
	 * Get the review of the movie
	 * Return review: the review of the movie
	 */
	public String getReview(){
		return this.review;
	}
	
	/**
	 * Get the rating of the movie
	 * Return rating: the review of the movie
	 */
	public double getRating(){
		return this.rating;
	}
	
	/**
	 * Set the rating of the movie
	 */
	public void setRating(double rating){
		this.rating = rating;
	}
	
	/**
     * Display the string representation of this RatingAndReview Object
     * @return The string representation of this RatingAndReview
     */
	public String toString() {
        return review;
    }
}
