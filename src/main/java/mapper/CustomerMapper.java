package mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.ectn.service.be.servicebe.contract.Customer;
import it.ectn.service.be.servicebe.model.CustomerView;

@Mapper()
public interface CustomerMapper {
	
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	@Mapping(source="id",target = "id")
	@Mapping(source="name",target = "name")
	@Mapping(source="surname",target = "surname")
	@Mapping(source="fiscalCode",target = "fiscalCode")
	@Mapping(source="andress",target = "andress")
	
	List<Customer> conver(List<CustomerView> customerView);
	Customer conver(CustomerView customerView);
}
