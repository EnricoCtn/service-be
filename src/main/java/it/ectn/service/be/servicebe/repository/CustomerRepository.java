package it.ectn.service.be.servicebe.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import it.ectn.service.be.servicebe.model.CustomerView;

@Mapper
public interface CustomerRepository {

	@Select("SELECT * FROM CUSTOMER")
	@Result(column = "ID",property = "id")
	@Result(column = "NAME",property = "name")
	@Result(column = "SURNAME",property = "surname")
	@Result(column = "FISCAL_CODE",property = "fiscalCode")
	@Result(column = "ANDRESS",property = "andress")
	List<CustomerView> select();
	
	
	
}
