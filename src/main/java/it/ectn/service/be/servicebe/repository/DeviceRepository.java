package it.ectn.service.be.servicebe.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.ectn.service.be.servicebe.contract.Device;
import it.ectn.service.be.servicebe.model.DeviceView;

@Mapper
public interface DeviceRepository {

	@Select("SELECT * FROM DEVICE")
	@Result(column = "ID",property = "id")
	@Result(column = "ID_USER",property = "idUser")
	@Result(column = "STATUS",property = "stauts")
	List<DeviceView> select();
	
	@Select("SELECT * FROM CUSTOMER WHERE ID=#{id}")
	@Result(column = "ID",property = "id")
	@Result(column = "ID_USER",property = "idUser")
	@Result(column = "STATUS",property = "stauts")
	DeviceView selectDevice(String id);
	
	@Insert("INSERT INTO DEVICE(ID,ID_USER,STATUS) "
			+ "VALUES(#{id},#{idUser},#{status}")
	int insert(Device device);
	
	@Update("UPDATE DEVICE SET STATUS=#{stauts} WHERE ID=#{id}")
	int update(Device device);
	
	@Delete("DELETE FROM DEVICE WHERE ID=#{id}")
	int delete(String id);
	
}
