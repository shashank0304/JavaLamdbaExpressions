package lambdas.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Example - MultiMap
//Input - ["bengaluru,paris,barcelona,madrid"]

//Output- {b=["bengaluru","barcelona"], m =["madrid"] , p =["paris"]}

public class MultiMapFunctionTest {

	public static void main(String[] args) {

		List<String> cities = getCities();
		
		beforeLambdas(cities);

		afterLambdas(cities);
	}

	private static void beforeLambdas(List<String> cities) {
		
		//Input - ["bengaluru,paris,barcelona,madrid"]
		// {, [] }
		// {, [] }
		// {, [] }
		Map<Character, List<String>> cityMap = new HashMap<>();

		for (String city : cities) {
			List<String> cityList = cityMap.get(city.charAt(0));
			if (cityList == null) {
				cityList = new ArrayList<>();
				cityMap.put(city.charAt(0), cityList); 
			}
			cityList.add(city);
		}
		System.out.println("Before Lambdas : ");
		System.out.println(cityMap);
	}

	private static void afterLambdas(List<String> cities) {
		
		//Input - ["bengaluru,paris,barcelona,madrid"]
		
		Map<Character, List<String>> cityMap = new HashMap<>();

		for (String city : cities) {
			// {, [] }
			// {, [] }
			// {, [] }
			// {, [] }
			cityMap.computeIfAbsent(city.charAt(0), k -> new ArrayList<String>()).add(city);
		}
		System.out.println("Using lambdas: ");
		System.out.println(cityMap);
	}

	private static List<String> getCities() {
		return Arrays.asList("bengaluru", "paris", "madrid", "barcelona");
	}

}
