package lambdas.ch04;

//Another type of exchange
public class NCDEX {

	public static void main(String[] args) {
		NCDEX market = new NCDEX();
		market.trade();

	}

	public void trade() {
		String type = getTypeOfCommodity();

		Commodity commodity = CommodityFactory.getCommodity(type);
		commodity.buy();

	}

	private String getTypeOfCommodity() {
		// can return other values as well..
		return "crudeoil";
	}

}
