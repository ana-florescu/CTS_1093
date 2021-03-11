package ro.ase.csie.cts.g1093.laboratory3.stage1;

import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidAccountAgeException;
import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidPriceException;

public class Product {
	public static final int MAX_ACCOUNT_AGE = 10;
	public static final float MAX_FIDELITY_DISCOUNT = 0.15f;
	
	public float getFinalPrice(ProductType productType, float initialPrice, int accountAgeInYears) throws InvalidPriceException, InvalidAccountAgeException {
		if ( initialPrice <= 0 ) {
			throw new InvalidPriceException();
		}
		
		if( accountAgeInYears < 0 ) {
			throw new InvalidAccountAgeException();
		}
		
		float finalPrice = 0;
		float fidelityDiscount = (accountAgeInYears > MAX_ACCOUNT_AGE) ? (float) MAX_FIDELITY_DISCOUNT : (float) accountAgeInYears / 100;
		  switch(productType) {
		    case NEW:
			    finalPrice = initialPrice;
			    break;
	    	case DISCOUNT:
			    finalPrice = (initialPrice - (ProductType.DISCOUNT.getDiscount() * initialPrice)) - fidelityDiscount * (initialPrice - (ProductType.DISCOUNT.getDiscount() * initialPrice));
			    break;
	    	case LIMITED_STOCK:
			    finalPrice = (initialPrice - (ProductType.LIMITED_STOCK.getDiscount() * initialPrice)) - fidelityDiscount * (initialPrice - (ProductType.LIMITED_STOCK.getDiscount() * initialPrice));
			    break;
	    	case LEGACY:
			    finalPrice = (initialPrice - (ProductType.LEGACY.getDiscount() * initialPrice)) - fidelityDiscount * (initialPrice - (ProductType.LEGACY.getDiscount() * initialPrice));
			    break;
			default:
				throw new UnsupportedOperationException("New enum symbol processed");
		    }
		    
		    return finalPrice;
	}
}