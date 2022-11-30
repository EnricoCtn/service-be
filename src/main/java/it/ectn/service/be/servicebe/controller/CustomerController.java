package it.ectn.service.be.servicebe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ectn.service.be.servicebe.contract.Customer;
import it.ectn.service.be.servicebe.contract.request.CustomerInsertRequest;
import it.ectn.service.be.servicebe.contract.request.CustomerPatchRequest;
import it.ectn.service.be.servicebe.contract.response.CustomerSearchResponse;
import it.ectn.service.be.servicebe.exception.ApiException;
import it.ectn.service.be.servicebe.service.CustomerService;
import it.ectn.service.be.servicebe.utils.Constants;

@RestController
@RequestMapping(Constants.BASE_PATH+"/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("")
	public ResponseEntity<CustomerSearchResponse> searchCustomer(){
		List<Customer> customerList = this.customerService.searchCustomers();
		CustomerSearchResponse response = new CustomerSearchResponse();
		response.setCustomers(customerList);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") String id) throws ApiException{
		Customer customer = this.customerService.getCustomer(id);
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}

	@PostMapping(value="",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Customer> insertCustomer(@RequestBody CustomerInsertRequest customerInsertRequest) throws ApiException{
		Customer customer = this.customerService.insertCustomer(customerInsertRequest);
		
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}
	
	@PatchMapping(value="/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Customer> patchCustomer(@PathVariable("id") String id,@RequestBody CustomerPatchRequest customerPatchRequest) throws ApiException{
		Customer customer = this.customerService.patchCustomer(id,customerPatchRequest);
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteCustomer(String id) throws ApiException{
		this.customerService.deleteCustomer(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
