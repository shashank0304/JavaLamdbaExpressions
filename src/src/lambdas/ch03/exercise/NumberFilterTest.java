package lambdas.ch03.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberFilterTest {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,43,5,-234,23,6,7,19);
		
		filterNumbers(numbers, (number) -> number % 2 == 0);
		filterNumbers(numbers,(number) -> number % 2 != 0);
		filterNumbers(numbers,(number) -> number > 0);
		filterNumbers(numbers,(number) -> number < 0);
		filterNumbers(numbers,(number) -> isPrime(number));
	}

	public static void filterNumbers(List<Integer> numbers,NumberFilter filter) {
		
		List<Integer> filteredNumbers = new ArrayList<>();
		for(Integer number : numbers) {
			if(filter.filterNumber(number)) {
				filteredNumbers.add(number);
			}
		}
		System.out.println(filteredNumbers);
		
	}
	
	private static boolean isPrime(int number) {
		if(number == 1 || number < 0) return false;
		for(int i = 2; i< Math.sqrt(number);i++) {
			if(number % i  == 0)
				return false;
		}
		return true;
	}

}
