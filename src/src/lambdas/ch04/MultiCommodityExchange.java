package lambdas.ch04;

//One type of exchange
public class MultiCommodityExchange {

	public static void main(String[] args) {
		MultiCommodityExchange market = new MultiCommodityExchange();
		market.trade();

	}

	public void trade() {

		String type = getTypeOfCommodity();

		Commodity commodity = CommodityFactory.getCommodity(type);
		commodity.buy();

	}

	private String getTypeOfCommodity() {
		// can return other values as well..
		return "gold";

	}

}
