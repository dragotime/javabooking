package control;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import boundary.UIAdminMain;
import entity.MovieInfo;
import entity.RatingAndReview;

import java.util.Arrays;
import java.io.FileReader;
import java.io.File;
import java.io.FileOutputStream;

/**
 * MovieListing Control Class
 * @author Haqim
 *
 */
public class MovieListingControl {
	
	/**
	 * Array List of movies
	 */
	public ArrayList<MovieInfo> moviesArray = new ArrayList<MovieInfo>();
	
	/**
	 * Scan user input
	 */
	private Scanner sc = new Scanner(System.in);
	
	//******************************** List Movies ***************************//
	/**
	 * List of movies
	 * @throws Exception
	 */
	public void listMovies() throws Exception{
		FileReader file = new FileReader("txt/Movies1.txt");
		BufferedReader reader = new BufferedReader(file);
		String line;
		while((line = reader.readLine()) != null){
			//Scan first object
			String text = "";
			text += line;
			
			//Break down first object into its attributes and store in array
			String[] elementsArray = text.split(";");
			
			//convert from String form to desired eNum type
			MovieInfo.MovieStatus movieStatus = MovieInfo.MovieStatus.valueOf(elementsArray[0]);
			MovieInfo.CategoryOfMovie movieCategory = MovieInfo.CategoryOfMovie.valueOf(elementsArray[1]);
			MovieInfo.AgeRatingOfMovie movieAgeRating = MovieInfo.AgeRatingOfMovie.valueOf(elementsArray[2]);
		
			//convert from 1 String to an arrayList of strings
			String tempCast[] = elementsArray[6].split(",");
			ArrayList<String> cast = new ArrayList<String>(Arrays.asList(tempCast));
			
			//array to store all [ratings and reviews] in string form
			String tempRatingAndReview[] = elementsArray[8].split(",");
			
			//create array to store RatingAndReview obj
			int i = tempRatingAndReview.length;
			RatingAndReview ratingAndReviewArray[] = new RatingAndReview[i];
			
			//create arrayList to store RatingAndReview obj
			ArrayList<RatingAndReview> ratingAndReviewList;
			int iCounter = 0;
				while(iCounter < i){
					//break each element of the string RatingAndReview into a double and a string
					String tempIndividualRatingAndReview[] = tempRatingAndReview[iCounter].split("|");
					//store each element of the string RatingAndReview into a double and a string
					double rating = (double) Double.valueOf(tempIndividualRatingAndReview[0]);
					String review = tempIndividualRatingAndReview[1];
					
					//create a ratingAndReview obj with these as parameters, and store them in arr
					ratingAndReviewArray[iCounter] = new RatingAndReview(rating, review);
					
					iCounter++;
				}
			//pass array into list
			ratingAndReviewList = new ArrayList<RatingAndReview>(Arrays.asList(ratingAndReviewArray));

			//instantiate movie object based on above parameters
			MovieInfo M1 = new MovieInfo(movieStatus, movieCategory, movieAgeRating, elementsArray[3], elementsArray[4], elementsArray[5], cast,
					(double) Double.valueOf(elementsArray[7]), ratingAndReviewList, (double) Double.valueOf(elementsArray[9]), (int) Integer.valueOf(elementsArray[10]));
			//**eventually need to move overallRating to the end of MovieInfo obj, can't hardcode it
			//add to array List of Movie
			moviesArray.add(M1);
			
			//test
			//System.out.println(M1.toString());
			
		}
		
		reader.close();
	}
	
	/**
	 * List all movies
	 */
	public void listAllMovies(){
	int iCounter = 1;
	for(MovieInfo m:moviesArray) {
        System.out.println(iCounter + " " + m.getMovieTitle());
        iCounter++;
    	}
	}
	
	/**
	 * get themovies
	 * @param index
	 */
	public void getMovieInfo(int index){
		System.out.println(moviesArray.get(index-1));
		}
	
	/**
	 * list top 5 by rating
	 */
	public void listTop5ByRating(){
		int iCounter = 0;
		
		//Sort by rating in ascending. If descending, compare movie1:movie2 instead
	    Collections.sort(moviesArray, new Comparator<MovieInfo>(){
	    	public int compare(MovieInfo movie1, MovieInfo movie2) {
                return Double.compare(movie2.getOverallRating(), movie1.getOverallRating());
            }
	    });
	    //Create sub-Array with only top 5
	    ArrayList<MovieInfo> newList = new ArrayList<MovieInfo>(moviesArray.subList(0,5));
	    for(MovieInfo m:newList){
	    	System.out.println(iCounter + 1 + ": " + m.getMovieTitle() + ", with an overall rating of " + m.getOverallRating());
	    	iCounter++;
	    }	    
	}
	
	/**
	 * list top 5 by sales
	 */
	public void listTop5BySale() {
		int iCounter = 0;
        // sort the movies by sale
		//Sort by rating in ascending. If descending, compare movie1:movie2 instead
	    Collections.sort(moviesArray, new Comparator<MovieInfo>(){
	    	public int compare(MovieInfo movie1, MovieInfo movie2) {
                return Double.compare(movie2.getSales(), movie1.getSales());
            }
	    });
	    //Create sub-Array with only top 5
	    ArrayList<MovieInfo> newList = new ArrayList<MovieInfo>(moviesArray.subList(0,5));

        for (MovieInfo m:newList) {
        	System.out.println(iCounter + 1 + ": " + m.getMovieTitle() + ", with an overall sales figure of " + m.getSales());
	    	iCounter++;        
	    	}
	}
	
	/**
	 * search movies
	 * @param s
	 * @throws Exception
	 */
	public void searchMovies(String s) throws Exception{
		ArrayList<MovieInfo> searchResult = new ArrayList<MovieInfo>();
        String movieName;
        int iCounter = 0;
        
        // search by name, then add to movie array
        for (MovieInfo m: moviesArray) {
        	movieName = m.getMovieTitle().toLowerCase();
            if (movieName.contains(s.toLowerCase())){
                searchResult.add(m);
            }
        }

        // display result
        if (searchResult.size() != 0) {
			int index;
        	System.out.println("We found these movies: ");
            for (MovieInfo sR: searchResult) {
            	System.out.println(iCounter + 1 + ": " + sR.getMovieTitle());
    	    	iCounter++;                
    	    	}
            System.out.println("Which one of these do you want to know more about?");
            index = sc.nextInt();
            System.out.println(searchResult.get(index-1));
        } else {
        	System.out.println("Sorry, we did not find what you searched for!");
        }
        
	}
	
	/**
	 * Remove movies
	 * @param movieTitle
	 * @throws IOException
	 */
	public void removeMovie(String movieTitle) throws IOException{
		File inputFile = new File("txt/Movies1.txt");
		File tempFile = new File("myTempFile.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String line;
		PrintWriter out = null;
		boolean successfulRemove = false;
		out = new PrintWriter(new BufferedWriter(new FileWriter(tempFile, true)));
		try {
			while((line = reader.readLine()) != null){
			//Scan first object
			//Break down first object into its attributes and store in array
				String[] elementsArray = line.split(";");
				if(elementsArray[3].equals(movieTitle)){
					//Skip over the movie and don't input back into the file
					successfulRemove = true;
				}
				else 
				{	

				    out.print(elementsArray[0] + ";"
				    		+ elementsArray[1] + ";"
				    		+ elementsArray[2] + ";"
				    		+ elementsArray[3] + ";"
				    		+ elementsArray[4] + ";"
				    		+ elementsArray[5] + ";"
				    		+ elementsArray[6] + ";"
				    		+ elementsArray[7] + ";"
				    		+ elementsArray[8] + ";"
				    		+ elementsArray[9] + ";"
				    		+ elementsArray[10] + "\n");
				  				    
				}
				
			}
			}catch (IOException e) {
				System.err.println(e);
			}finally{
				if(out != null){
					out.close();
				}			
			} 
		writer.close(); 
	    reader.close(); 
	    boolean successfulOverwrite = tempFile.renameTo(inputFile);
	    if(successfulRemove == true && successfulOverwrite == true){
        	System.out.println("Successfully removed " + movieTitle);
	    }
	    else if(successfulOverwrite != true){
	    	System.out.println("Problem with file overwrite");
	    }
	    else System.out.println("Sorry, we did not find what you searched for!");

	}
	    
	
	/**
	 * Add movies
	 */
	public void addMovies(){
		PrintWriter out = null;
		String[] elementsArray = new String[11];
		
		elementsArray[0] = addMovieStatus();			
		elementsArray[1] = addMovieCategory();
		elementsArray[2] = addMovieAgeRating();			
		elementsArray[3] = addMovieTitle();
		elementsArray[4] = addMovieSynopsis();			
		elementsArray[5] = addMovieDirector();
		elementsArray[6] = addMovieCast();	
		elementsArray[7] = addMovieOverallRating();
		elementsArray[8] = addMovieReview();
		elementsArray[9] = addMoviePrice();			
		elementsArray[10] = addMovieSales();
		try {
		    out = new PrintWriter(new BufferedWriter(new FileWriter("txt/Movies1.txt", true)));
	    
		    out.print("\n" + elementsArray[0] + ";"
		    		+ elementsArray[1] + ";"
		    		+ elementsArray[2] + ";"
		    		+ elementsArray[3] + ";"
		    		+ elementsArray[4] + ";"
		    		+ elementsArray[5] + ";"
		    		+ elementsArray[6] + ";"
		    		+ elementsArray[7] + ";"
		    		+ elementsArray[8] + ";"
		    		+ elementsArray[9] + ";"
		    		+ elementsArray[10] + "\n");
		}catch (IOException e) {
		    System.err.println(e);
		}finally{
		    if(out != null){
		        out.close();
		    }
		} 
		UIAdminMain admin = new UIAdminMain();
		admin.adminMenu();
	}
	
	/**
	 * Add movies Status
	 * @return
	 */
	public String addMovieStatus(){
		int option = 0;
		System.out.println("Input if movie is 1) COMINGSOON, 2) PREVIEW, 3) NOWSHOWING, 4) ENDOFSHOWING");
	    do{
			try {
				option = sc.nextInt();
				if (option < 1 || option > 4 ) {
					throw new InputMismatchException("Incorrect input!!!!");
				}
				break;
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("Please Re-enter option: ");
			}
		}while(option > 0 && option < 5);
		
		switch(option) {
		case 1:
			return "COMINGSOON";
		case 2:
			return "PREVIEW";
		case 3:
			return "NOWSHOWING";
		case 4:
			return "ENDOFSHOWING";
		}
		
		System.out.println("Bad Input!");
		return "";
	}
	
	/**
	 * Add Movie Category
	 * @return
	 */
	public String addMovieCategory(){
		int option = 5;
		System.out.println("Input if movie is 1) 3D, 2) BLOCKBUSTER, 3) NORMAL");
	    do{
			try {
				option = sc.nextInt();
				if (option < 1 || option > 3 ) {
					throw new InputMismatchException("Incorrect input!!!!");
				}
				break;
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("Please Re-enter option: ");
			}
		}while(option > 0 && option < 4);
		
		switch(option) {
		case 1:
			return "THREED";
		case 2:
			return "BLOCKBUSTER";
		case 3:
			return "NORMAL";
		}
		
		System.out.println("Bad Input!");
		return "";
	}
	
	/**
	 * Add movie Age Rating
	 * @return
	 */
	public String addMovieAgeRating(){
		int option = 5;
		System.out.println("Input if movie is 1) PG, 2) NC16, 3) M18, 4) R21");
	    do{
			try {
				option = sc.nextInt();
				if (option < 1 || option > 4 ) {
					throw new InputMismatchException("Incorrect input!!!!");
				}
				break;
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("Please Re-enter option: ");
			}
		}while(option > 0 && option < 5);
		
		switch(option) {
		case 1:
			return "PG";
		case 2:
			return "NC16";
		case 3:
			return "M18";
		case 4:
			return "R21";
		}
		
		System.out.println("Bad Input!");
		return "";
	}
	
	/**
	 * Add movie Cast
	 * @return
	 */
	public String addMovieCast(){
		int i = 0;
		System.out.println("Input how many cast members there are?");
		/*need to use catch if its not int	
		 * 
		 */
		i = sc.nextInt();
		
		//to scan the trailing \n
		sc.nextLine();
			
		String cast = "";
		String temp = "";
		StringBuilder stringBuilder = new StringBuilder();
		while(i != 0){
			System.out.println("Input name of cast member");
			temp = sc.nextLine();
			stringBuilder.append(temp);
			i--;
			if(i - 1 != 0)
				stringBuilder.append(",");
		}
		cast = stringBuilder.toString();
		return cast;
	}
	
	/**
	 * Add Movie Review
	 * @return
	 */
	public String addMovieReview(){
		int option = 0;
		System.out.println("Rate the Movie from 0 - 5. Input 6 for NA");
		StringBuilder stringBuilder = new StringBuilder();
		String temp = "";
		String movieReview = "";
	    do{
			try {
				option = sc.nextInt();
				if (option < 1 || option > 6 ) {
					throw new InputMismatchException("Incorrect input!!!!");
				}
				break;
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("Please Re-enter option: ");
			}
		}while(option > 0 && option < 7);
		
		switch(option) {
		case 1:
			stringBuilder.append("1|");
		case 2:
			stringBuilder.append("2|");
		case 3:
			stringBuilder.append("3|");
		case 4:
			stringBuilder.append("4|");
		case 5:
			stringBuilder.append("5|");
		case 6:
			stringBuilder.append("NA|");
		}
		//scan the \n
		sc.nextLine();
		System.out.println("Input your review of the movie:");
		temp = sc.nextLine();
		stringBuilder.append(temp);
		movieReview = stringBuilder.toString();
		return movieReview;
		
	}
	
	/**
	 * Add Movie Title
	 * @return
	 */
	public String addMovieTitle(){
		String title = "";
		
		System.out.println("Please Enter Movie Title : ");
		title = sc.nextLine();
		title = sc.nextLine();
	    System.out.println("Movie Title : " + title);

		return title;
	}
	
	/**
	 * Add Movie Price
	 * @return
	 */
	public String addMoviePrice(){
		int moviePrice;
		
		System.out.println("Please Enter the Price of this movie ticket: ");
		moviePrice = sc.nextInt();
		
		return Integer.toString(moviePrice);
	}
	
	/**
	 * Add movie Sales
	 * @return
	 */
	public String addMovieSales(){
		int movieSales;
		
		System.out.println("Please Enter the current total sales of the movie: ");
		movieSales = sc.nextInt();
		
		return Integer.toString(movieSales);
	}
	
	//Delete this method because we should not hardcode it in the end!
	/**
	 * Add Movie Overall Rating
	 * @return
	 */
	public String addMovieOverallRating(){
		int movieSales;
		
		System.out.println("Please Enter the overall rating of the movie: ");
		movieSales = sc.nextInt();
		
		return Integer.toString(movieSales);
	}
	
	/**
	 * Add Movie Synopsis
	 * @return
	 */
	public String addMovieSynopsis(){
		String synopsis = "";
		
		System.out.println("Please Enter Movie Synopsis : ");
		synopsis = sc.nextLine();
		//synopsis = sc.nextLine();
	   //System.out.println("Movie Title : " + title);

		return synopsis;
	}
	
	/**
	 * Add Movie Direcotr
	 * @return
	 */
	public String addMovieDirector(){
		String director = "";
		
		System.out.println("Please Enter Movie Director : ");
		director = sc.nextLine();
		//director = sc.nextLine();
	    //System.out.println("Movie Title : " + title);

		return director;
	}
	
	/**
	 * Update Movie
	 * @param listAllMovies
	 */
	public void updateMovie(String listAllMovies) {
		try {
			BufferedReader file = new BufferedReader(new FileReader("txt/Movies1.txt"));
			String line;
			StringBuffer inputBuffer = new StringBuffer();
			String[] elementsArray = listAllMovies.split(";");
		}
		catch(Exception e) {
			System.out.println("Problem reading file. Please Try Again");
		}
	}
	
	
	
/*	public void updateMovie() {
		int id;
		listAllMovies();
		System.out.println("Please Enter the Movie to update : ");
		while (true) {
			try {
				id = Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("Please Enter a valid movie : ");
				continue;
			}
			break;
		}
		boolean printed = false;
		if(printed) {
			int p = 1;
			do{
				System.out.println("Choose the category to change: ");
				System.out.println("1. Movie Status: ");
				System.out.println("2. Movie Category: ");
				System.out.println("3. Movie Age Rating: ");
				System.out.println("5. Movie Synopsis: ");
				System.out.println("6. Movie Director: ");
				System.out.println("7. Movie Cast: ");
				System.out.println("8. Movie OverallRating: ");
				System.out.println("9. Movie Review: ");
				System.out.println("10. Movie Price: ");
				System.out.println("11. Movie Sales: ");
				System.out.println("12. Exit: ");
				try {
					p = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Please Enter a valid choice!!!");
				}
				
				switch(p) {
				case 1:
					System.out.println("Please Enter new Status: ");
					String st = sc.nextLine();
					break;
				case 2:
					System.out.println("Please Enter a valid choice!!!");
					break;
				case 3:
					System.out.println("Please Enter a valid choice!!!");
					break;
				case 4:
					System.out.println("Please Enter a valid choice!!!");
					break;
				case 5:
					System.out.println("Please Enter a valid choice!!!");
					break;
				case 6:
					System.out.println("Please Enter a valid choice!!!");
					break;
				case 7:
					System.out.println("Please Enter a valid choice!!!");
					break;
				case 8:
					System.out.println("Please Enter a valid choice!!!");
					break;
				case 9:
					System.out.println("Please Enter a valid choice!!!");
					break;
				case 10:
					System.out.println("Please Enter a valid choice!!!");
					break;
				case 11:
					System.out.println("Please Enter a valid choice!!!");
					break;
				default:
					break;
				}
			}while(p < 12);
		}
		else{
			System.out.println("No movie of the selected movie is in the system. Please Try again");
		}		
	}*/
}
