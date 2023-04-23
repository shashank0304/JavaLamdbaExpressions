package lambdas.ch04;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

//Factory using Supplier.
public class CommodityFactory {

	private static final Map<String, Supplier<? extends Commodity>> commodities = new HashMap<>();

	static {
		commodities.put("gold", () -> new Gold());
		commodities.put("crudeoil", () -> new CrudeOil());
		commodities.put("soy", () -> new Soybean());
	}

	public static void registerNewCommodity(String type, Supplier<? extends Commodity> supplier) {
		commodities.put(type, supplier);
	}

	public static Commodity getCommodity(String typeOfCommodity) {

		Supplier<? extends Commodity> commoditySupplier = commodities.get(typeOfCommodity);
		if (null != commoditySupplier) {
			return commoditySupplier.get();
		}

		throw new IllegalArgumentException("Unknown commodity:  " + typeOfCommodity);
	}
}

interface Commodity {
	public void buy();
}

class CrudeOil implements Commodity {
	public void buy() {
		System.out.println("Buying crude oil...");
	}
}

class Gold implements Commodity {
	public void buy() {
		System.out.println("Buying Gold...");
	}
}

class Soybean implements Commodity {
	public void buy() {
		System.out.println("Buying SoyBeans...");

	}
}

class Silver implements Commodity {
	public void buy() {
		System.out.println("Buying Silver...");

	}
}
