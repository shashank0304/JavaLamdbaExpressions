package lambdas.ch04;

import java.util.ArrayList;
import java.util.List;

public class TradeUtil {

	public static List<Trade> getTrades() {
		List<Trade> trades = new ArrayList<>();
		trades.add(new Trade(new Stock("AAPL","Apple", 119.02), 1000000, TradeType.BUY));
		trades.add(new Trade(new Stock("AMZN", "Amazon",3272.00), 50000, TradeType.BUY));
		trades.add(new Trade(new Stock("GOOGL", "Google",1567.70), 10000, TradeType.BUY));
		trades.add(new Trade(new Stock("NFLX", "Netflix",530.79), 2000000, TradeType.SELL));
		trades.add(new Trade(new Stock("FB", "Facebook",265.93), 1000, TradeType.SELL));

		return trades;

	}
}
