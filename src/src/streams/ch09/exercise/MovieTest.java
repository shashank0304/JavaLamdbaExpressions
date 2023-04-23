package streams.ch09.exercise;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import streams.ch07.exercise.Movie;
import streams.ch07.exercise.MovieUtil;

//Solution for exercise Movies_min_max_sum
public class MovieTest {
	
	public static List<Movie> movies = MovieUtil.getMovieData();
	
	public static void main(String[] args) {
		
		//Exercise one - Find the highest grossing movie.
		Optional<Movie> highestEarningMovie = highestGrossingMovie();
		System.out.println(highestEarningMovie);
		
		//Exercise two - find the lowest grossing movie in the year 2020
		Optional<Movie> lowestEarningMovieIn2020 = lowestGrossingMovieIn2020();
		System.out.println(lowestEarningMovieIn2020);
		
		//Exercise three - Total money - films made by Martin Scorsese
		long sum = sumGrossMoviesByMartinScorsese();
		System.out.println(sum);
		
		//Exercise four - How many movies released in last 5 years ?
		long noLastFiveYears = noOfMoviesInLastFiveYears();
		System.out.println(noLastFiveYears);

	}

	private static long noOfMoviesInLastFiveYears() {
		
		LocalDate lastTenYears = LocalDate.now().minusYears(10);
		
		return movies.stream()
					 .filter(movie -> movie.getDateOfRelease().isAfter(lastTenYears))
					 .count();		
	}

	public static Optional<Movie> highestGrossingMovie() {
		
		Comparator<Movie> byGrossEarning = Comparator.comparing(Movie::getGrossEarning);
		
		return movies.stream()
					 .max(byGrossEarning);
	}
	
	public static Optional<Movie> lowestGrossingMovieIn2020() {
		
		Comparator<Movie> byGrossEarning = Comparator.comparing(Movie::getGrossEarning);
		
		return movies.stream()
					 .filter(movie -> movie.getDateOfRelease().getYear() == 2020)
					 .min(byGrossEarning);
	}
	
	public static long sumGrossMoviesByMartinScorsese() {
		
		return movies.stream()
					 .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
					 .mapToLong(movie -> movie.getGrossEarning())
					 .sum();
	}


	
	
}
