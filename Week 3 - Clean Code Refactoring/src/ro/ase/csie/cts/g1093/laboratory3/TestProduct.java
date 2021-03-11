package ro.ase.csie.cts.g1093.laboratory3;

import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidAccountAgeException;
import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidPriceException;
import ro.ase.csie.cts.g1093.laboratory3.stage1.Product;
import ro.ase.csie.cts.g1093.laboratory3.stage1.ProductType;

public class TestProduct {

	public static void main(String[] args) throws InvalidPriceException, InvalidAccountAgeException {
		Product product = new Product();
		
		product.getFinalPrice(ProductType.NEW, 23.4f, 3);
		
	}

}
