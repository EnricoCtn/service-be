package it.ectn.service.be.servicebe.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import it.ectn.service.be.servicebe.contract.Device;
import it.ectn.service.be.servicebe.model.DeviceView;
import it.ectn.service.be.servicebe.utils.RepositoryUtils;

@Mapper
public interface DeviceRepository {

	@SelectProvider(type = SelectDeviceBuilder.class, method = "select")
	@Results({
		@Result(column = "ID",property = "id"),
		@Result(column = "ID_USER",property = "idUser"),
		@Result(column = "STATUS",property = "status")
	})
	List<DeviceView> select(Device device);
	
	@Insert("INSERT INTO DEVICE(ID,ID_USER,STATUS) "
			+ "VALUES(#{id},#{idUser},#{status}")
	int insert(Device device);
	
	@Update("UPDATE DEVICE SET STATUS=#{stauts} WHERE ID=#{id}")
	int update(Device device);
	
	@Delete("DELETE FROM DEVICE WHERE ID=#{id}")
	int delete(String id);
	
	class SelectDeviceBuilder {
		
		static final String SELECT_FROM = "SELECT * FROM DEVICE";
		
		public static String select(Device device){
			
			String whereCondition = StringUtils.EMPTY;
			if(StringUtils.isNotBlank(device.getId())) {
				whereCondition = StringUtils.join(whereCondition," AND ID=#{id}");
			}
			if(StringUtils.isNotBlank(device.getStatus())) {
				whereCondition = StringUtils.join(whereCondition," AND ID_USER=#{idUser}");
			}
			if(StringUtils.isNotBlank(device.getIdUser())) {
				whereCondition = StringUtils.join(whereCondition," AND STATUS=#{status}");
			}
			
			if(StringUtils.isNotBlank(whereCondition)) {
				RepositoryUtils.cleanWhereStatement(whereCondition);
				whereCondition = StringUtils.join(" WHERE ",whereCondition);
			}
			
			return StringUtils.join(SELECT_FROM,whereCondition);
		}
		
		
	}
	
}
