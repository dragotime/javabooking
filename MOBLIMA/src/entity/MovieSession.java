package entity;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Movie Session entity class
 * @author Haqim
 *
 */
public class MovieSession {
	
	/**
	 * enum for the different types of days for movie
	 * 3 types: WEEKDAY, WEEKEND, HOLIDAY
	 * Capitalised because they are constants
	 */
	public enum DayOfSession {
	    WEEKDAY,
	    WEEKEND,
	    HOLIDAY
		}
	
	private DayOfSession dayOfSession;
	private MovieInfo movieInfo;
	private Cinema cinema;
	private Cineplex cineplex;
	private Date sessionStart;
	private Date sessionEnd;
	private int sessionID;
	
	/**
	 * MovieSession Constructor: 
	 * Parameters: movieInfo, cinema, cineplex, sessionStart, sessionEnd
	 * @param movieInfo: object containing information of the movie
	 * @param cinema: object containing information of the cinema
	 * @param cineplex: object containing information of the cineplex holding the cinema
	 * @param sessionStart: start time of movie
	 * @param sessionEnd: end time of movie
	 * @param sessionID: unique ID of each session
	 */
	public MovieSession(MovieInfo movieInfo, Cinema cinema, Cineplex cineplex, Date sessionStart, Date sessionEnd, int sessionID) {
        this.movieInfo = movieInfo;
        this.cinema = cinema;
        this.cineplex = cineplex;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
        this.sessionID = sessionID;
    }
	
	/**
	 * Get the information of this cinema of the session
	 * Return String: information of the cinema
	 */
	public String getCinema(){
        return cinema.toString();
    }
	
	/**
	 * Get the information of this movie
	 * Return String: information of the movie
	 */
	public String getMovieInfo() {
        return movieInfo.toString();
    }
	
	/**
	 * Get the start time of this movie
	 * Return sessionStart: time movie starts
	 */
	public Date getSessionStart() {
        return sessionStart;
    }
	
	/**
	 * Get the end time of this movie
	 * Return sessionEnd: time movie ends
	 */
	public Date getSessionEnd() {
        return sessionEnd;
    }
	
	/**
	 * Change the start and end time of this movie
	 */
	public void setSessionTime(Date sessionStart, Date sessionEnd) {
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
    }
	
	/**
	 * Change the day of session of this movie
	 */
	public void setDayOfSession(DayOfSession dayOfSession) {
        this.dayOfSession = dayOfSession;
    }
	
	/**
	 * Get the day of session of this movie
	 * Return dayOfSession: day of session of this movie
	 */
	public DayOfSession getDayOfSession() {
        return dayOfSession;
    }
	
	/**
	 * Change the sessionID
	 */
	public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }
	
	/**
	 * Get the ID of session
	 * Return int: sessionID
	 */
	public int getSessionID() {
        return sessionID;
    }
	
	/**
	 * Include movie details, cinema & cineplex details, time details
	 * Return: String representation of the MovieSession object
	 */
	public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy hh:mm");
        return "Movie title: " + movieInfo.getMovieTitle() +
               "\nType of movie: " + movieInfo.getCategoryOfMovie() +
               "\nType of movie: " + movieInfo.getAgeRatingOfMovie() +
               "\nDay of movie: " + dayOfSession +
               "\nCinema class: " + cinema.getTypeOfCinema() +
               "\nCineplex: " + cineplex.toString() +
               "\nShow starts: " + format.format(sessionStart) +
               "\nShow ends: " + format.format(sessionEnd);
        
        		/*movieInfo.toString() + "\n" + cinema.toString()...
        		 * 
        		 */
    }
}
