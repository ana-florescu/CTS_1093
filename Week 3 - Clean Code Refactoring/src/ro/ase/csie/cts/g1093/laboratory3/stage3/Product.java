package ro.ase.csie.cts.g1093.laboratory3.stage3;


import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidAccountAgeException;
import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidPriceException;
import ro.ase.csie.cts.g1093.laboratory3.stage3.services.MarketingInterface;
import ro.ase.csie.cts.g1093.laboratory3.stage3.services.MarketingStrategySpring2021;
import ro.ase.csie.cts.g1093.laboratory3.stage3.services.ValidatorInterface;
import ro.ase.csie.cts.g1093.laboratory3.stage3.services.ValidatorService;

public class Product {
	
	MarketingInterface mkService = null;
	ValidatorInterface validatorInterface = null;
	
	public Product(MarketingInterface mkStrategy, ValidatorInterface validator) {
		
		this.setMarketingStrategy(mkStrategy);
		
		if( validator == null) {
			throw new NullPointerException();
		}
		this.validatorInterface = validator;
	}


	public void setMarketingStrategy(MarketingInterface mkStrategy) {
		if(mkStrategy == null) {
			throw new NullPointerException();
		}
		this.mkService = mkStrategy;
	}
	
	
	
	public static float getPriceWithDiscount(float initialPrice, float discountValue)
	{
		return initialPrice - (discountValue * initialPrice);
	}
	
	public float getFinalPrice(ProductType productType, float initialPrice, int accountAgeInYears) throws InvalidPriceException, InvalidAccountAgeException {
		validatorInterface.validatePrice(initialPrice);	
		validatorInterface.validateAccountAgeInYears(accountAgeInYears);

		float fidelityDiscount = 
				(productType == ProductType.NEW) ? 0 : mkService.getFidelityDiscount(accountAgeInYears);
		
		float discountValue = productType.getDiscount();
	    float priceWithDiscount = getPriceWithDiscount(initialPrice ,discountValue);
	    float  finalPrice = priceWithDiscount * (1-fidelityDiscount);
		       
	    return finalPrice;
	}
}