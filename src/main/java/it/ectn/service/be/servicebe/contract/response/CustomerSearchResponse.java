package it.ectn.service.be.servicebe.contract.response;

import java.util.List;

import it.ectn.service.be.servicebe.contract.Customer;

public class CustomerSearchResponse {
	
	private List<Customer> customers;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
