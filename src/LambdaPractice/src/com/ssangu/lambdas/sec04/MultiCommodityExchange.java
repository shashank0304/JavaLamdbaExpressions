package com.ssangu.lambdas.sec04;

public class MultiCommodityExchange {
	
	public static void main(String[] args) {
		MultiCommodityExchange market = new MultiCommodityExchange();
		market.trade();
	}
	
	public void trade() {
		
		String type = getCommodityType();
		
		/*if(type.equals("gold")) {
			commodity = new Gold();
		} else if (type.equals("soy")) {
			commodity = new Soybean();
		} else if(type.equals("crudeoil")) {
			commodity = new CrudeOil();
		}*/
		Commodity commodity = CommodityFactory.getCommodity(type);
		commodity.buy();
	}
	
	public String getCommodityType() {
		return "gold";
	}
}
