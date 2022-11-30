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

import it.ectn.service.be.servicebe.contract.Device;
import it.ectn.service.be.servicebe.contract.request.DeviceInsertRequest;
import it.ectn.service.be.servicebe.contract.request.DevicePatchRequest;
import it.ectn.service.be.servicebe.contract.response.DeviceSearchResponse;
import it.ectn.service.be.servicebe.exception.ApiException;
import it.ectn.service.be.servicebe.service.DeviceService;
import it.ectn.service.be.servicebe.utils.Constants;

@RestController
@RequestMapping(Constants.BASE_PATH+"/devices")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	
	@GetMapping("")
	public ResponseEntity<DeviceSearchResponse> searchDevice(){
		List<Device> deviceList = this.deviceService.searchDevices();
		DeviceSearchResponse response = new DeviceSearchResponse();
		response.setDevices(deviceList);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Device> getDevice(@PathVariable("id") String id) throws ApiException{
		Device device = this.deviceService.getDevice(id);
		
		return new ResponseEntity<>(device,HttpStatus.OK);
	}

	@PostMapping(value="",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Device> insertDevice(@RequestBody DeviceInsertRequest deviceInsertRequest) throws ApiException{
		Device device = this.deviceService.insertDevice(deviceInsertRequest);
		
		return new ResponseEntity<>(device,HttpStatus.CREATED);
	}
	
	@PatchMapping(value="/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Device> patchDevice(@PathVariable("id") String id,@RequestBody DevicePatchRequest devicePatchRequest) throws ApiException{
		Device device = this.deviceService.patchDevice(id,devicePatchRequest);
		
		return new ResponseEntity<>(device,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteDevice(String id) throws ApiException{
		this.deviceService.deleteDevice(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
