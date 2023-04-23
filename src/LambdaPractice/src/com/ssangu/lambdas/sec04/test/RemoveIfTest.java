package com.ssangu.lambdas.sec04.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ssangu.lambdas.sec04.CachedItem;

public class RemoveIfTest {
	
	public static void main(String[] args) {
		List<CachedItem> cachedItems = getCachedItems();
		
		//Causes error as concurrent modification of collections is not allowed
		//usingForLoop(cachedItems); 
		
		//usingIterator(cachedItems);
		
		usingLambdas(cachedItems);
	}
	
	private static void usingLambdas(List<CachedItem> cachedItems) {
		cachedItems.removeIf((cachedItem) -> {return isStale(cachedItem);});
		System.out.println(cachedItems.toString());
	}
	private static void usingIterator(List<CachedItem> cachedItems) {
		
		Iterator<CachedItem> iterator = cachedItems.iterator();
		while(iterator.hasNext()) {
			CachedItem item = iterator.next();
			if(isStale(item)) {
				iterator.remove();
			}
		}
		System.out.println(cachedItems.toString());
	}
	private static void usingForLoop(List<CachedItem> cachedItems) {
		for(CachedItem stock: cachedItems) {
			if(isStale(stock)) {
				cachedItems.remove(stock);
			}
		}
		System.out.println(cachedItems);
		
	}
	
	private static boolean isStale(CachedItem cachedItem) {
		return cachedItem.getDuration().compareTo(Duration.ofSeconds(60)) > 0;
	}
	private static List<CachedItem> getCachedItems() {
		
		List<CachedItem> items = new ArrayList<>();
		items.add(new CachedItem("AAPL", Duration.ofSeconds(30)));
		items.add(new CachedItem("AMZN", Duration.ofSeconds(40)));
		items.add(new CachedItem("MSFT", Duration.ofSeconds(50)));
		items.add(new CachedItem("GOOGL", Duration.ofSeconds(60)));
		items.add(new CachedItem("NFLX", Duration.ofSeconds(90)));
		return items;
	}
}
