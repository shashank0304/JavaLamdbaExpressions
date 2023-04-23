package streams.ch10.exercise;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import streams.ch07.exercise.Genre;
import streams.ch07.exercise.Movie;
import streams.ch07.exercise.MovieUtil;

//Solution to Movies_collectors exercise
public class MovieTest {
	
	public static List<Movie> movies = MovieUtil.getMovieData();
	
	public static void main(String[] args) {
		
		//Exercise one - group movies by genre
		Map<Genre,List<Movie>> movieByGenre = groupByGenre();
		System.out.println(movieByGenre);
		
		//Exercise two - Find the number of movies released in each year
		Map<Integer,Long> groupByYearCount = totalMoviesReleasesInEachYear();
		System.out.println(groupByYearCount);
				
		//Exercise three - Find the gross earning of movies classified by genre
		Map<Genre,Long> grossByGenre =  grossEarningByGenre();
		System.out.println(grossByGenre);
		
		//Exercise four - Group movies with rating >= 4
		Map<Integer,List<Movie>> groupByRating = groupByFourAndAboveRating();				
		System.out.println(groupByRating);
		
		//Exercise five - Group movies with rating >= 4 but only names of movies.
		Map<Integer,List<String>> byRatingMovieName = movieNamesGroupedByRating();
		System.out.println(byRatingMovieName);

	}


	public static Map<Genre, Long> grossEarningByGenre() {
		return movies.stream()
		             .collect(Collectors.groupingBy(
		            		 			  Movie::getGenre,
		            		 			  Collectors.summingLong(Movie::getGrossEarning)
		            		 			)
		            		 );
	}

	public static Map<Genre,List<Movie>> groupByGenre() {
		return movies.stream()
			    	 .collect(Collectors.groupingBy(Movie::getGenre));		
	}
	
	public static Map<Integer, Long> totalMoviesReleasesInEachYear() {
		return movies.stream()
		      .collect(Collectors.groupingBy((Movie movie) -> 
		      								  movie.getDateOfRelease().getYear(),
		      								  Collectors.counting()
		    		   						)
		    		  );
	}
	
	public static Map<Integer, List<Movie>> groupByFourAndAboveRating() {
		return movies.stream()
					 .filter( movie -> movie.getRating() >=4)
					 .collect(Collectors.groupingBy(Movie::getRating));
	}
	
	public static Map<Integer, List<String>> movieNamesGroupedByRating() {
		return movies.stream()
		      .filter(movie -> movie.getRating()>=4)
		      .collect(Collectors.groupingBy
		    		  		(
		    		  			Movie::getRating, 
		    		  			Collectors.mapping(Movie::getName, Collectors.toList())
		    		  		)
		    		  );
	}
	
}
