package com.ssangu.lambdas.sec04.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalBeforeJava8Test {
	
	public static void main(String[] args) {
		String date = "2023-05-02";
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Runnable task = () -> parseDate(date);
		
		for(int i=1;i<=10;i++) {
			executorService.submit(task);
		}
		executorService.shutdown();
	}
	
	public static void parseDate(String dateToParse) {
		
		try {
			Date date = ThreadLocalBeforeJava8.get().parse(dateToParse);
			System.out.println(date);
		} catch(ParseException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class ThreadLocalBeforeJava8 {
	
	private static final ThreadLocal<DateFormat> dateFormatter = new ThreadLocal<DateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	
	
	
	public static DateFormat get() {
		return dateFormatter.get();
	}
}
