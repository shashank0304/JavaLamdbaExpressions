package lambdas.ch04;

import java.util.function.Consumer;



//Shows an example of the andThen method in Consumer.
public class ConsumerChainingTest {

	public static void main(String[] args) {
		
		Response response = getResponse();

		// void accept(T t);

		Consumer<Response> kafka = (Response r) -> sendMessage(r);
		Consumer<Response> db = (Response r) -> storeInDb(r);
		Consumer<Response> email = (Response r) -> sendEmail(r);

		

		//Compose them.
		Consumer<Response> chainResponse = kafka.andThen(db).andThen(email);
		
		processResponse(chainResponse, response);
	}

	private static void sendEmail(Response r) {
		System.out.println("Sending email...");
	}

	public static void processResponse(Consumer<Response> processResponse, Response r) {
		processResponse.accept(r);
	}

	public static void sendMessage(Response response) {
		System.out.println("Sending response to kafka...");
	}

	public static void storeInDb(Response response) {
		System.out.println("Storing response in db...");
	}
	
	private static Response getResponse() {
		return new Response(404, "Resource not found");
	}

}
