package it.ectn.service.be.servicebe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ectn.service.be.servicebe.contract.Customer;
import it.ectn.service.be.servicebe.exception.ApiException;
import it.ectn.service.be.servicebe.mapper.CustomerMapper;
import it.ectn.service.be.servicebe.model.CustomerView;
import it.ectn.service.be.servicebe.repository.CustomerRepository;
import it.ectn.service.be.servicebe.utils.Utils;
import it.ectn.service.be.servicebe.utils.EnumUtils.ErrorsEnum;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> searchCustomers(){
		List<CustomerView> listCustomerView = this.customerRepository.select();
		return CustomerMapper.INSTANCE.convertFromView(listCustomerView);
	}
	
	public Customer getCustomer(String id) throws ApiException {
		CustomerView customerView = this.customerRepository.selectCustomer(id);
		if(customerView==null) {
			throw new ApiException(ErrorsEnum.CUSTOMER_NOT_FOUND);
		}
		return CustomerMapper.INSTANCE.convertFromView(customerView);
	}
	
	public Customer insertCustomer(Customer customer) throws ApiException {
		String newUUID = Utils.getNewUUID();
		customer.setId(newUUID);
		
		int insert = this.customerRepository.insert(customer);
		if(insert!=1) {
			throw new ApiException(ErrorsEnum.CUSTOMER_GENRICO_ERROR);
		}
		return this.getCustomer(newUUID);
	}
	
	public Customer patchCustomer(String id,Customer customer) throws ApiException {
		this.getCustomer(id);
		customer.setId(id);
		
		int update = this.customerRepository.update(customer);
		if(update!=1) {
			throw new ApiException(ErrorsEnum.CUSTOMER_GENRICO_ERROR);
		}
		return this.getCustomer(customer.getId());
	}
	
	public void deleteCustomer(String id) {	
		this.customerRepository.delete(id);
	}
	
}
