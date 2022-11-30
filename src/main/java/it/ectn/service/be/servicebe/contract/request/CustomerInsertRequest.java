package it.ectn.service.be.servicebe.contract.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.ectn.service.be.servicebe.contract.Customer;

@JsonIgnoreProperties({"id"})
public class CustomerInsertRequest extends Customer {

}
