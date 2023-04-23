package lambdas.ch06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MapMergeMethodReference {
	
	public static void main(String[] args) {
		
		var map = new HashMap<String,Integer>();
		List<String> words = Arrays.asList("football","cricket","basketball","football","football","cricket"); 
		words.forEach( (word) ->  map.merge(word, 1, (prev,latest) -> prev+latest));
		//Method reference.
		//words.forEach( (word) ->  map.merge(word, 1, Integer::sum));
		System.out.println(map);
	}

}
