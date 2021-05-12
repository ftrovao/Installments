package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installments;
import services.ContractService;
import services.OnlinePaymentService;
import services.PayPalService;

public class Program {
	public static void main(String[] args) throws ParseException  {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		System.out.print("number: ");
		Integer number = sc.nextInt();
		System.out.println("Date: ");
		Date date = sdf.parse(sc.next());
		System.out.println("Contract Value: ");
		Double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.println("Number of installments: ");
		int N = sc.nextInt();
		
		//preciso processar o contrato. Para isso, preciso criar um servico.
		//injeto a dependencia com o "new PayPalService
		ContractService cs = new ContractService(new PayPalService());
		
		cs.processContract(contract, N);
		
		System.out.println("Installments");
		for(Installments it : contract.getInstallments()) {
			System.out.println(it);
		}
	
		
		
		
		
		
		sc.close();
	}
}
