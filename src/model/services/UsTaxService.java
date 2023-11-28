package model.services;

public class UsTaxService implements TaxService{

	@Override
	public double tax(double amount) {
		if(amount <= 100)
			return amount * 0.3;
		return amount * 0.2;
	}

}
