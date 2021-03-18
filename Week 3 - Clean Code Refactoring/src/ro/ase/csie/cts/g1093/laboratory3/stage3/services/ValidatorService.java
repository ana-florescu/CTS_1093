package ro.ase.csie.cts.g1093.laboratory3.stage3.services;

import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidAccountAgeException;
import ro.ase.csie.cts.g1093.laboratory3.exceptions.InvalidPriceException;

public class ValidatorService implements ValidatorInterface {

	@Override
	public void validatePrice(float price) throws InvalidPriceException {
		if ( price <= 0 ) {
			throw new InvalidPriceException();
		}	
	}

	@Override
	public void validateAccountAgeInYears(int age) throws InvalidAccountAgeException {
		if( age < 0 ) {
			throw new InvalidAccountAgeException();
		}	
	}

}
