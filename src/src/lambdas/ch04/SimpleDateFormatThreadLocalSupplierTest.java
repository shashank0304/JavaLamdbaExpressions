package lambdas.ch04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Thread local using Supplier.
public class SimpleDateFormatThreadLocalSupplierTest {

	public final static ThreadLocal<DateFormat> formatter = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

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

			Date date = formatter.get().parse(dateToParse);

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
