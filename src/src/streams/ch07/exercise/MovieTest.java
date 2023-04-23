package streams.ch07.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Solution to the exercise Movies_stream_filter_collect
public class MovieTest {
	
	public static List<Movie> movies = MovieUtil.getMovieData();
	
	public static void main(String[] args) {
	
		//movies in 2020
		int year = 2020;
		Predicate<Movie> movieReleasedInYear2020 = movieReleasedInYear(year);
		
		//exercise one- 
		List<Movie> getMoviesInYear = getFiteredMovies(movieReleasedInYear2020);
		System.out.println("\nMovies released in Year "+year + ": " + getMoviesInYear);
		
		//exercise two - retrieve the names of movies that belong to the Action genre 
		List<String> movies  = getActionMovieNames();
		System.out.println("\nNames of Action Movies: "+movies);
		
		//exercise three - action movie names sorted alphabetically.
		List<String> actionMoviesSortedByName  = getActionMovieNamesSorted();
		System.out.println("\nNames of Action movies sorted: "+actionMoviesSortedByName);
		
		//exercise four - retrieve action movies sorted by release date.
		List<Movie> actionMoviesByReleaseDate  = getActionMovieSortedByReleaseDate();
		System.out.println("\nAction movies sorted by release date: "+actionMoviesByReleaseDate);
		
		//exercise five - Get unique names of the directors that have a movie released after 2000.
		List<String > directors = getDirectorNamesOfMoviesAfter2000();
		System.out.println("\nNames of directors that have released movies "
				+ "after year 2000: " +directors);
		
	}


	//exercise 1 - re-factor this method to use stream/filter/collect
	public static List<Movie> getFiteredMovies(Predicate<Movie> movieFilter) {
		List<Movie> filteredMovies = new ArrayList<>();
		for(Movie m: movies) {
			if(movieFilter.test(m)){
				filteredMovies.add(m);
			}
		}
		return filteredMovies;
	}
	
	//exercise 2 - Using map
	public static List<String> getActionMovieNames() {
		
		return movies.stream()
					 .filter(movie -> movie.getGenre().equals(Genre.ACTION))
					 .map(movie -> movie.getName())
					 .collect(Collectors.toList());
	}
	
	//exercise 3- using sorted- sort action movies by name
	public static List<String> getActionMovieNamesSorted() {
		
		return movies.stream()
					 .filter(movie -> movie.getGenre().equals(Genre.ACTION))
					 .map(movie -> movie.getName())
					 .sorted()
					 .collect(Collectors.toList());
	}
	
	//exercise 4- using sorted- sort action movies by release date

	public static List<Movie> getActionMovieSortedByReleaseDate() {
		
		Comparator<Movie> byReleaseDate = Comparator.comparing(Movie::getDateOfRelease);
		
		return movies.stream()
					 .filter(movie -> movie.getGenre().equals(Genre.ACTION))
					 .sorted(byReleaseDate)
					 .collect(Collectors.toList());
	}
	
	//exercise 5 - Retrieve the names of directors that have released movie after year 2000
	public static List<String> getDirectorNamesOfMoviesAfter2000() {
		
		return movies.stream()
					 .filter(movie -> movie.getDateOfRelease().getYear() > 2000)
					 .map(movie -> movie.getDirectorName())		
					 .distinct()
					 .collect(Collectors.toList());
	}
	
	private static Predicate<Movie> movieReleasedInYear(int year){
		return movie -> movie.getDateOfRelease().getYear() == year;	
	}
	
}
