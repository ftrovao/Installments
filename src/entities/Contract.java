package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Contract {

	Integer number;
	Date date;
	Double TotalValue;
	List<Installments> installments = new ArrayList<Installments>();
	
	
	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		TotalValue = totalValue;	
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getTotalValue() {
		return TotalValue;
	}


	public void setTotalValue(Double totalValue) {
		TotalValue = totalValue;
	}


	public List<Installments> getInstallments() {
		return installments;
	}


	

	
	
	
}
