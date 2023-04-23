package lambdas.ch04;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestTransactions {

	public static void main(String[] args) {
		List<Trade> trades = TradeUtil.getTrades();
		
		//1. Get symbol of stocks where volume is >= 1 million.
		System.out.println("\nHigh volume stocks:");
		List<String> highVolumeStocks = Exchange.getHighVolumeStocks(trades);
		System.out.println(highVolumeStocks);

		//2. Get all Buy transactions
		System.out.println("\nStocks purchased");
		List<String> stocksPurchased = Exchange.getStocksByTradeType(trades, TradeType.BUY);
		System.out.println(stocksPurchased);

		//3. Get all Sell transactions
		System.out.println("\nStocks sold");
		List<String> stocksSold = Exchange.getStocksByTradeType(trades, TradeType.SELL);
		System.out.println(stocksSold);

		System.out.println("\nRefactored code to use Predicate,Function");
		//1. High Volume
		System.out.println("\nRefactored - High volume stocks:");

		Predicate<Trade> highVolumeStock = (Trade trade) -> trade.getVolume() >= 1000000;
		Function<Trade, String> symbol = (Trade trade) -> trade.getStock().getSymbol();
		
		System.out.println(Exchange.getStock(trades, highVolumeStock, symbol));

		//2. Buy
		System.out.println("\nRefactored - Stocks purchased");
		
		Predicate<Trade> buyTrades = (Trade trade) -> trade.getTradeType() == TradeType.BUY;
		// Notice how getStockSymbolWithVolume has been re-used in next 2 examples.
		System.out.println(Exchange.getStock(trades, buyTrades, Exchange.getStockSymbolWithVolume()));

		System.out.println("\nRefactored - Stocks sold");
		//3. Sell
		Predicate<Trade> sellTrades = (Trade trade) -> trade.getTradeType() == TradeType.SELL;
		System.out.println(Exchange.getStock(trades, sellTrades, Exchange.getStockSymbolWithVolume()));

		//Shows how the getStockNameSymbolWithVolume was plugged into the getStock API.
		System.out.println("\nRefactored - Stocks sold with name and description");
		System.out.println(Exchange.getStock(trades, sellTrades, Exchange.getStockNameSymbolWithVolume()));

	}



}
