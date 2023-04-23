package streams.ch08;

import java.math.BigDecimal;

public class Stock {

	private String name;
	private BigDecimal value;

	public Stock(String name, BigDecimal value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public BigDecimal getValue() {
		return value;
	}
	
	
}
