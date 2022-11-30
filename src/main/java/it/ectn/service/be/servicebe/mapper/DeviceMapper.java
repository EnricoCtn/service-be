package it.ectn.service.be.servicebe.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.ectn.service.be.servicebe.contract.Device;
import it.ectn.service.be.servicebe.model.DeviceView;

@Mapper()
public interface DeviceMapper {

	DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);
	
	@Mapping(source="id",target = "id")
	@Mapping(source="idUser",target = "idUser")
	@Mapping(source="status",target = "status")
	
	List<Device> convertFromView(List<DeviceView> deviceView);
	Device convertFromView(DeviceView deviceView);
	
	List<DeviceView> convert(List<Device> deviceView);
	DeviceView convert(Device deviceView);
	
}
