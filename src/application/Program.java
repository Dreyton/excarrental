package application;

import java.time.LocalDateTime;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {
	public static void main(String[] args) {
		Vehicle v = new Vehicle("Civic");
		CarRental cr = new CarRental(LocalDateTime.parse("2018-06-25T10:30:00"), 
				                     LocalDateTime.parse("2018-06-25T14:40:00"), 
				                     v);
		RentalService rs = new RentalService(10.0, 130.0, 
				           new BrazilTaxService());
		
		rs.processInvoice(cr);
		
		System.out.println("FATURA: ");
		System.out.println("Pagamento basico: " + cr.getInvoice().getBasicPayment());
		System.out.println("Imposto: " + cr.getInvoice().getTax());
		System.out.println("Pagamento total: " + cr.getInvoice().totalPayment());
	}
}





