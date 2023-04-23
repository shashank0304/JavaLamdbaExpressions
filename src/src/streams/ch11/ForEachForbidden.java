package streams.ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachForbidden {
	
	public static void main(String[] args) {
		
		List<String> data = Arrays.asList("abcded","bcdefe","cdedf","def");
		for(int i = 0 ; i < 10 ;i ++) {
			List<String> result = new ArrayList<>();
			data.parallelStream()
			    .filter(s -> s.length() >3)
			    .forEach(s -> result.add(s));			
			System.out.println(result);
		}
	}

}
