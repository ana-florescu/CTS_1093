package ro.ase.csie.cts.g1093.laboratory3.stage3.test;

import java.util.ArrayList;

import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidAccountAgeException;
import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidPriceException;
import ro.ase.csie.cts.g1093.laboratory3.stage3.Product;
import ro.ase.csie.cts.g1093.laboratory3.stage3.ProductType;
import ro.ase.csie.cts.g1093.laboratory3.stage3.services.MarketingInterface;
import ro.ase.csie.cts.g1093.laboratory3.stage3.services.MarketingStrategySpring2021;
import ro.ase.csie.cts.g1093.laboratory3.stage3.services.ValidatorService;

public class TestProduct {
public static ArrayList<Object> services = new ArrayList<>();

public static void startup() {
	services.add(new MarketingStrategySpring2021());
	services.add(new ValidatorService());
}
	public static void main(String[] args) {
	
		Product sales = new Product(new MarketingStrategySpring2021(), new ValidatorService());
		
		try {
			float finalPrice = sales.getFinalPrice(ProductType.DISCOUNT, 100, 5);
			System.out.println("The final price is " + finalPrice);
			
			// anonymous class example
			sales.setMarketingStrategy(new MarketingInterface() {
					public float getFidelityDiscount(int yearsSinceRegistration) {
						return 0.5f;
				}
			});
			finalPrice = sales.getFinalPrice(ProductType.DISCOUNT, 100, 5);
			System.out.println("The final price is " + finalPrice);
			
		} catch (InvalidPriceException e) {
			e.printStackTrace();
		} catch (InvalidAccountAgeException e) {
			e.printStackTrace();
		}
	  
	}

}
