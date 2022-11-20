package it.ectn.service.be.servicebe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ectn.service.be.servicebe.contract.Customer;
import it.ectn.service.be.servicebe.service.CustomerService;

@RestController
@RequestMapping("/enrctn/service/be/resources/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("")
	public List<Customer> searchCustomer(){
		return this.customerService.getCustomers();
	}
	
	
}
