package lambdas.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exchange {

	// Get symbol of stocks where volume is >= 1 million.
	public static List<String> getHighVolumeStocks(List<Trade> trades) {
		List<String> stocks = new ArrayList<>();
		for (Trade trade : trades) {
			if (trade.getVolume() >= 1000000) {
				stocks.add(trade.getStock().getSymbol());
			}
		}
		return stocks;
	}

	// Get symbol of a stock by type of transaction.
	public static List<String> getStocksByTradeType(List<Trade> trades, TradeType tradeType) {
		List<String> stocks = new ArrayList<>();
		for (Trade trade : trades) {
			if (trade.getTradeType() == tradeType) {
				// get the name of stock along with quantity separated by hyphen.
				stocks.add(trade.getStock().getSymbol() + "-" + trade.getVolume());
			}
		}
		return stocks;
	}

	public static List<String> getStock(List<Trade> trades, Predicate<Trade> tradeFilter,
			Function<Trade, String> tradeTransformer) {

		Objects.requireNonNull(tradeFilter);
		Objects.requireNonNull(tradeTransformer);

		List<String> stocks = new ArrayList<>();
		for (Trade trade : trades) {
			if (tradeFilter.test(trade)) {
				stocks.add(tradeTransformer.apply(trade));
			}
		}
		return stocks;
	}

	public static Function<Trade, String> getStockSymbolWithVolume() {
		return (trade) -> trade.getStock().getSymbol() + "-" + trade.getVolume();
	}
	
	public static Function<Trade, String> getStockNameSymbolWithVolume() {
		return (trade) -> trade.getStock().getName() + "-" + trade.getStock().getSymbol() + "-" + trade.getVolume();
	}
}
