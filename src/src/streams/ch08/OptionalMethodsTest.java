package streams.ch08;

import java.util.Optional;

public class OptionalMethodsTest {
	
	public static void main(String[] args) {

		//use when we know it can never be null else NullPointer - bug indicator
		Optional<String> str = Optional.of("Hello Streams"); // 

		System.out.println(str.isPresent()); //checks for != null
		
		System.out.println(str.isEmpty());   //checks for == null
				
		//orElse
		Optional<String> canBeEmpty = Optional.empty();
		System.out.println(canBeEmpty.orElse("Lambdas"));
		
		//convenience method- uses 'empty' and 'of' together.
		Optional<String> object = Optional.ofNullable(getObject());	// might return null
		System.out.println(object.orElse("Streams"));
		
		func(1L,Optional.of("Gerard"));
		func(1L,Optional.empty());
		
		//func(1L, "Gerard");
		//func(1L,"");				
	}
	
	private static String getObject() {
		return "Learning"; // might return null
	}
	
	
	public static void func(Long id,Optional<String> middleName) {
		
	}
	
	public static void fun(Long id) {
		
	}
	
	public static void fun(Long id,String middleName) {
		
	}

}
