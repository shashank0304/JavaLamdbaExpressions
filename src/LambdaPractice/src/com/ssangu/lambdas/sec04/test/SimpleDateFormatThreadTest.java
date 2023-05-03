package com.ssangu.lambdas.sec04.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatThreadTest {
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) {
		
		String date = "2023-05-02";
		Runnable task = () -> parseDate(date);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for(int i=1;i<=10;i++) {
			executorService.submit(task);
		}
		executorService.shutdown();
	}
	
	public static void parseDate(String dateToParse) {
		try {
			Date date = simpleDateFormat.parse(dateToParse);
			System.out.println("Successfully parsed date:"+date);
		} catch(ParseException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
