package it.ectn.service.be.servicebe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ectn.service.be.servicebe.contract.Customer;
import it.ectn.service.be.servicebe.model.CustomerView;
import it.ectn.service.be.servicebe.repository.CustomerRepository;
import mapper.CustomerMapper;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomers(){
		List<CustomerView> listCustomerView = this.customerRepository.select();
		return CustomerMapper.INSTANCE.conver(listCustomerView);
	}
	
	
	
}
