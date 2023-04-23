package lambdas.ch04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Thread local before Java 8.
class ThreadLocalBeforeJava8Test {

	public static void main(String[] args) {
		String date = "2020-09-09";

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		Runnable task = () -> parseDate(date);

		for (int i = 0; i < 10; i++) {
			executorService.submit(task);
		}

		executorService.shutdown();
	}

	public static void parseDate(String dateToParse) {
		try {
			//T1 -> parseDate() - x() - y() - z()
			Date date = ThreadLocalBeforeJava8.get().parse(dateToParse);
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

class ThreadLocalBeforeJava8 {

	// Thread local variable
	private static final ThreadLocal<DateFormat> dateFormatter = new ThreadLocal<DateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}

	};

	public static DateFormat get() {
		return dateFormatter.get();
	}
	
	// (Thread1, new SimpleDateFormat())
	// (Thread2, new SimpleDateFormat())
	// (Thread3, new SimpleDateFormat())

}
