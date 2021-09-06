package entity;

import java.util.*;

/**
 * MovieInfo entity class
 * @author Haqim
 *
 */
public class MovieInfo {
	
	/**
	 * enum for the different types of movie status
	 * 4 types: COMINGSOON, PREVIEW, NOWSHOWING, ENDOFSHOWING
	 * Capitalised because they are constants
	 */
	public enum MovieStatus{
		COMINGSOON, 
		PREVIEW, 
		NOWSHOWING, 
		ENDOFSHOWING
		}
	
	/**
	 * enum for the different categories of movies
	 * 3 types: THREED, BLOCKBUSTER, NORMAL
	 * Capitalised because they are constants
	 */
	public enum CategoryOfMovie{
		THREED,
		BLOCKBUSTER,
		NORMAL
	}
	
	/**
	 * enum for the different age ratings of movies
	 * 4 types: PG, NC16, M18, R21
	 * Capitalised because they are constants
	 */
	public enum AgeRatingOfMovie{
		PG,
		NC16,
		M18,
		R21
	}
	
	/**
	 * type of movie status according to MovieStatus enum
	 */
	private MovieStatus movieStatus;
	
	/**
	 * type of movie category according to CategoryOfMovie enum
	 */
	private CategoryOfMovie categoryOfMovie;
	
	/**
	 * type of age ratings according to AgeRatingOfMovie enum
	 */
	private AgeRatingOfMovie ageRatingOfMovie;
	
	/**
	 * Title of Movie
	 */
	private String movieTitle;
	
	/**
	 * Synopsis of Movie
	 */
	private String movieSynopsis;
	
	/**
	 * Director of Movie
	 */
	private String movieDirector;
	
	/**
	 * Cast of Movie
	 */
	private ArrayList<String> movieCast;
	
	/**
	 * Overall rating of Movie based on past viewer feedback
	 */
	private double overallRating;
	
	/**
	 * List of Movie reviews
	 */
	private List<RatingAndReview> pastReviews;
	
	/**
	 * Base Price of Movie Ticket
	 */
	private double basePrice;
	
	/**
	 * Sales of Movie
	 */
	private int sales;
	
	/**
     * Movie information Constructor
     * with given movie status, movie category, movie age rating,
     * movie title, synopsis, director, cast,
     * overall rating, past reviews,
     * base ticket price, and movie sales
     * @param movieStatus: The showing status of the movie
     * @param categoryOfMovie: The genre of the movie
     * @param ageRatingOfMovie: The age rating of this movie
     * @param movieTitle: The title of the movie
     * @param movieSynopsis: The synopsis of the movie
     * @param movieDirector: The name of the director of the movie
     * @param movieCast: The list of actors in the movie
     * @param overallRating: The overall Rating of the movie
     * @param pastReviews: The list of past reviews of the movie
     * @param basePrice: The base ticket price of the movie
     * @param sales: The sales figure of the movie
     */
    public MovieInfo(MovieStatus movieStatus, CategoryOfMovie categoryOfMovie, AgeRatingOfMovie ageRatingOfMovie, String movieTitle, String movieSynopsis, String movieDirector, ArrayList<String> movieCast, double overallRating, List<RatingAndReview> pastReviews, double basePrice, int sales) {
        this.movieStatus = movieStatus;
        this.categoryOfMovie = categoryOfMovie;
        this.ageRatingOfMovie = ageRatingOfMovie;
        this.movieTitle = movieTitle;
        this.movieSynopsis = movieSynopsis;
        this.movieDirector = movieDirector;
        this.movieCast = movieCast;
        this.overallRating = overallRating;
        this.pastReviews = pastReviews;
        this.basePrice = basePrice;
        this.sales = sales;
    }
    
    /**
	 * Get the movie status of this movie
	 * Return movieStatus: status of this movie
	 */
    public MovieStatus getMovieStatus() {
        return movieStatus;
    }
    
    /**
	 * Change the show status of this movie
	 * @param movieStatus: New status to be added
	 */
    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }
    
    /**
	 * Get the category of this movie
	 * Return categoryOfMovie: category of this movie
	 */
    public CategoryOfMovie getCategoryOfMovie() {
        return categoryOfMovie;
    }
    
    /**
	 * Change the genre of this movie
	 * @param categoryOfMovie: New genre to be added
	 */
    public void setCategoryOfMovie(CategoryOfMovie categoryOfMovie) {
        this.categoryOfMovie = categoryOfMovie;
    }
    
    /**
	 * Get the age rating of this movie
	 * Return ageRatingOfMovie: age rating of this movie
	 */
    public AgeRatingOfMovie getAgeRatingOfMovie() {
        return ageRatingOfMovie;
    }
    
    /**
	 * Change the age rating of this movie
	 * @param ageRatingOfMovie: New age rating to be added
	 */
    public void setAgeRatingOfMovie(AgeRatingOfMovie ageRatingOfMovie) {
        this.ageRatingOfMovie = ageRatingOfMovie;
    }
    
    /**
	 * Get the title of this movie
	 * Return movieTitle: title of this movie
	 */
    public String getMovieTitle() {
        return movieTitle;
    }
    
    /**
	 * Get the synopsis of this movie
	 * Return movieSynopsis: synopsis of this movie
	 */
    public String getMovieSynopsis() {
        return movieSynopsis;
    }
	
    /**
	 * Change the synopsis of this movie
	 * @param movieSynopsis: New synopsis to be added
	 */
    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }
    
    /**
	 * Get the overall user rating of this movie
	 * Return overallRating: overall rating of this movie
	 */
    public double getOverallRating() {
        return overallRating;
    }
    
    /**
	 * Get the past user reviews of this movie
	 * Return pastReviews: past user reviews of this movie in a list
	 */
    public List<RatingAndReview> getPastReviews() {
        return pastReviews;
    }
    
    /**
	 * Add a review to the list of reviews of this movie
	 * @param userReview: New review to be added
	 */
    public void addReview(RatingAndReview userReview) {
        pastReviews.add(userReview);
    }
    
    /**
	 * Get the base price of the movie ticket for this movie
	 * Return basePrice: base price of the movie ticket for this movie
	 */
    public double getBasePrice() {
        return basePrice;
    }
    
    /**
     * Change the base ticket price of this movie
     * @param basePrice: The new base price of this movie
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    
    /**
   	 * Get the sales for all the movie tickets for this movie
   	 * Return sales: total sales for the movie tickets for this movie
   	 */
       public double getSales() {
           return sales;
       }
    
       /*
       * (non-Javadoc)
       * @see java.lang.Object#toString()
       */
    public String toString() {
        if (pastReviews.size() > 1) {
        	return "Title: " + movieTitle + "\nShowing status: " + movieStatus + "\nRating: " + ageRatingOfMovie + "\nSynopsis: " + movieSynopsis + "\nCast" + movieCast + "\nViewer rating: " + overallRating;
        }
        else return "Title: " + movieTitle + "\nShowing status: " + movieStatus + "\nRating: " + ageRatingOfMovie + "\nSynopsis: " + movieSynopsis + "\nViewer rating: NA";
    }
    
    
}