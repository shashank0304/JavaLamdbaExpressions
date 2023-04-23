package lambdas.ch04;

import java.time.Duration;

public class CachedItem {

	private String stock;
	private Duration duration;

	public CachedItem(String stock, Duration duration) {
		this.stock = stock;
		this.duration = duration;
	}
	
	public String getName() {
		return stock;
	}
	
	public Duration getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return " Stock : " + stock;
	}

}
