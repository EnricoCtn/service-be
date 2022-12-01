package it.ectn.service.be.servicebe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ectn.service.be.servicebe.contract.Device;
import it.ectn.service.be.servicebe.exception.ApiException;
import it.ectn.service.be.servicebe.mapper.DeviceMapper;
import it.ectn.service.be.servicebe.model.DeviceView;
import it.ectn.service.be.servicebe.repository.DeviceRepository;
import it.ectn.service.be.servicebe.utils.EnumUtils.ErrorsEnum;
import it.ectn.service.be.servicebe.utils.Utils;

@Service
public class DeviceService extends SuperService {

	@Autowired
	private DeviceRepository deviceRepository;
	
	public List<Device> searchDevices(){
		List<DeviceView> listDeviceView = this.deviceRepository.select(new Device());
		return DeviceMapper.INSTANCE.convertFromView(listDeviceView);
	}
	
	public Device getDevice(String id) throws ApiException {
		DeviceView customerView = this.deviceRepository.selectDevice(id);
		if(customerView==null) {
			throw new ApiException(ErrorsEnum.CUSTOMER_NOT_FOUND);
		}
		return DeviceMapper.INSTANCE.convertFromView(customerView);
	}
	
	public Device insertDevice(Device customer) throws ApiException {
		String newUUID = Utils.getNewUUID();
		customer.setId(newUUID);
		
		int insert = this.deviceRepository.insert(customer);
		this.manageGenericException(insert);
		return this.getDevice(newUUID);
	}
	
	public Device patchDevice(String id,Device customer) throws ApiException {
		this.checkDevice(id);
		customer.setId(id);
		
		int update = this.deviceRepository.update(customer);
		this.manageGenericException(update);
		return this.getDevice(customer.getId());
	}
	
	public void deleteDevice(String id) throws ApiException {	
		this.checkDevice(id);
		int delete = this.deviceRepository.delete(id);
		this.manageGenericException(delete);
	}
	
	private boolean checkDevice(String id) throws ApiException {
		this.getDevice(id);
		return true;
	}
	
}
