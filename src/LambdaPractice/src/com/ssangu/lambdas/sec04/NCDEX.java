package com.ssangu.lambdas.sec04;

public class NCDEX {

	public static void main(String[] args) {
		NCDEX market = new NCDEX();
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
		if(null != commodity) {
			commodity.buy();
		} else {
			CommodityFactory.registerNewCommodity(type, () -> new Silver());
			CommodityFactory.getCommodity(type).buy();
		}
		
	}
	
	public String getCommodityType() {
		return "silver";
	}
}
