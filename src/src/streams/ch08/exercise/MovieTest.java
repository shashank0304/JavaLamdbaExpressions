package streams.ch08.exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import streams.ch07.exercise.Movie;
import streams.ch07.exercise.MovieUtil;


public class MovieTest {
	
	public static List<Movie> movies = MovieUtil.getMovieData();
	
	public static void main(String[] args) {
		
		//exercise 2 - Find the first rocky movie.
		findFirstRockyMovie();
		
		//exercise 3-Are there any movies starring  Will Smith in 2020 ?
		willSmithMovie2020();
	}



	public static void findFirstRockyMovie() {

		Comparator<Movie> byReleaseDate = Comparator.comparing(Movie::getDateOfRelease);

		Optional<Movie> movie = movies.stream()
								      .filter(m -> m.getName().contains("Rocky"))
								      .sorted(byReleaseDate)
								      .findFirst();
		
		System.out.println(movie.orElseThrow());
		
	}
	
	public static void willSmithMovie2020() {
		boolean willSmithMovie2020 = 
				                   movies.stream()
							             .filter(movie -> movie.getDateOfRelease().getYear() == 2020)
							             .anyMatch(movie -> movie.getCast().contains("Will Smith"));
		
		System.out.println(willSmithMovie2020);
	}


	
	
}
