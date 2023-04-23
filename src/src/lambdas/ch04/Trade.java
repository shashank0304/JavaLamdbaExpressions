package lambdas.ch04;

public class Trade {

	private Stock stock;
	private int volume;
	private TradeType tradeType;

	public Trade(Stock stock, int volume, TradeType tradeType) {
		this.stock = stock;
		this.volume = volume;
		this.tradeType = tradeType;
	}

	public Stock getStock() {
		return stock;
	}

	public int getVolume() {
		return volume;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

}
