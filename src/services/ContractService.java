package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installments;

public class ContractService {

	//Injecao de dependencia. Alguem de fora vai injetar e dizer
	//de quem vai depender.
	//nao fazer private OnlinePaymentService paymentService = new Paypal...;
	//tem que deixar em aberto, soh com a interface.
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService (OnlinePaymentService onlinePaymentService) {
		
		this.onlinePaymentService = onlinePaymentService;
	}
	
	//esse process vai instanciar as parcelas no contrato.
	public void processContract(Contract  contract, int months) {
		double basicQuota = contract.getTotalValue()/months;
		// basicQuota = 200;
		for (int i=1; i<=months; i++) {
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			//updatedQuota = 202;
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			// fullquota = 206.40
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installments(dueDate, fullQuota));
		}
	}
	
	private Date addMonths (Date date, int N) {
		Calendar calendar = Calendar.getInstance();//instancia calendario
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
	
}
