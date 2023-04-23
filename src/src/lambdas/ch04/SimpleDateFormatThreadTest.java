package lambdas.ch04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Unsafe code.
public class SimpleDateFormatThreadTest {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		String date = "2020-09-09";

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		Runnable task = () -> parseDate(date);

		for (int i = 0; i < 10; i++) {
			executorService.submit(task);
		}

		executorService.shutdown();
	}

	public static  void parseDate(String dateToParse) {
		try {
			
			//T1 -> parseDate() - x() - y() - z()

			// Can result in an Exception - Unsafe code.
			Date date = simpleDateFormat.parse(dateToParse);

			System.out.println("Successfully Parsed Date " + date);
		} catch (ParseException e) {
			// Should log.
			System.out.println("ParseError " + e.getMessage());
		} catch (Exception e) {
			// Should log.
			e.printStackTrace();
		}
	}
}
