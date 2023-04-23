package lambdas.movie.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MovieTest {
	
	public static List<Movie> movies = MovieUtil.getMovieData();
	
	public static void main(String[] args) {
	
		//Exercise one - movies in 2020
		int year = 2020;
		Predicate<Movie> movieReleasedInYear2020 = movieReleasedInYear(year);
		
		List<Movie> getMoviesInYear = getMovies(movieReleasedInYear2020);
		System.out.println("\n1.Movies released in Year "+year + ": " + getMoviesInYear);
		
		//Exercise two - horror movies
		Predicate<Movie> horrorMovies = movieByGenre(Genre.HORROR);
		
		List<Movie> getHorrorMovies = getMovies(horrorMovies);
		System.out.println("\n2.Horror movies: " +getHorrorMovies);
		
		
		//Exercise three - Get all horror movies in 2020
		Predicate<Movie> horrorInYear = movieReleasedInYear2020.and(horrorMovies);
		
		List<Movie> horrorMoviesIn2020 = getMovies(horrorInYear);
		System.out.println("\n3.Horror movies in the year 2020: "+horrorMoviesIn2020);
		
		//Exercise four - Get all movies where Leonardo DiCaprio is an actor
		Predicate<Movie> moviesWithLeo = movieByStarCast("Leonardo DiCaprio");
		
		List<Movie> movieListWithLeo = getMovies(moviesWithLeo);
		System.out.println("\n4.Leo stars in the following : "+movieListWithLeo);
		
		//Exercise five - Get all movies with Brad Pitt but not with Leonardo DiCaprio
		Predicate<Movie> moviesWithBradPitt = movieByStarCast("Brad Pitt");
		
		List<Movie> moviesWithBradAndNoLeo = getMovies(moviesWithLeo.negate().and(moviesWithBradPitt));
		System.out.println("\n5.Brad without Leo moves : "+moviesWithBradAndNoLeo);
		
		//Exercise six - Get top rated movies
		Predicate<Movie> topRated = movieWithRating(5);
		
		List<Movie> topRatedMovies = getMovies(topRated);
		System.out.println("\n6."+topRatedMovies);
		
		//Exercise seven - Get top rated movies in 2020
		List<Movie> topRated2020 = getMovies(topRated.and(movieReleasedInYear2020));
		System.out.println("\n7.Top rated in 2020 : " +topRated2020);
		
		//Exercise eight - Group movies by genre
		Map<Genre,List<Movie>> movieByGenre = new HashMap<>();
		for(Movie m : movies) {
			movieByGenre.computeIfAbsent(m.getGenre(), k -> new ArrayList<Movie>()					                  
					                    ).add(m);	
		}
	
		System.out.println("\n8."+movieByGenre);
		
		//Exercise nine - BiConsumer example.
		System.out.println("\n9.");
		movieByGenre.forEach((Genre genre,List<Movie> movies) -> {
			System.out.println("Genre: "+genre + "-> Movies: "+getMovieNames(movies));
		});
			
	}
	

	private static String getMovieNames(List<Movie> movies) {
		List<String> movieNames = new ArrayList<>();
		//function
		for(Movie m : movies) {
			movieNames.add(m.getName());
		}
		
		return String.join(",", movieNames);
	}

	public static List<Movie> getMovies(Predicate<Movie> movieFilter) {
		List<Movie> filteredMovies = new ArrayList<>();
		for(Movie m: movies) {
			if(movieFilter.test(m)){
				filteredMovies.add(m);
			}
		}
		return filteredMovies;
	}
	
	private static Predicate<Movie> movieReleasedInYear(int year){
		return movie -> movie.getDateOfRelease().getYear() == year;	
	}
	
	private static Predicate<Movie> movieByGenre(Genre genre){
		return movie -> movie.getGenre() == genre  ;	
	}
	
	private static Predicate<Movie> movieByStarCast(String star){
		return movie -> movie.getCast().contains(star);
	}	
	
	private static Predicate<Movie> movieWithRating(int rating){
		return movie -> movie.getRating() == rating;
	}
	
}
