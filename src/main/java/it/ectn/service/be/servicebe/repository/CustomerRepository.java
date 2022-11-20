package it.ectn.service.be.servicebe.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.ectn.service.be.servicebe.contract.Customer;
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
	
	@Insert("INSERT INTO CUSTOMER(ID,NAME,SURNAME,FISCAL_CODE,ANDRESS) "
			+ "VALUES(#{id},#{name},#{surname},#{fiscalCode},#{andress})")
	int insert(Customer customer);
	
	@Update("UPDATE CUSTOMER SET ANDRESS=#{andress} where id=#{id}")
	int update(Customer customer);
	
	@Delete("DELETE FROM customer where id=#{id}")
	int delete(String id);
	
}
