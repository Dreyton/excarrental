package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePerHour;
	private Double pricePerday;
	private BrazilTaxService brazilTaxService;
	
	public RentalService(Double pricePerHour, Double pricePerday, BrazilTaxService brazilTaxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerday = pricePerday;
		this.brazilTaxService = brazilTaxService;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerday() {
		return pricePerday;
	}

	public void setPricePerday(Double pricePerday) {
		this.pricePerday = pricePerday;
	}
	
	public void processInvoice(CarRental carRental) {
		long minutes = Duration.between(carRental.getStart(), 
				                         carRental.getFinish())
				                         .toMinutes();
		double duration = minutes / 60.0;
		
		double basicPayment = duration <= 12?pricePerHour * Math.ceil(duration):
			                          pricePerday * Math.ceil(duration/24.0);
		double tax = brazilTaxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
