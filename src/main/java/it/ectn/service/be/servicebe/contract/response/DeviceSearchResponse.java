package it.ectn.service.be.servicebe.contract.response;

import java.util.List;

import it.ectn.service.be.servicebe.contract.Device;

public class DeviceSearchResponse {

	private List<Device> devices;

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	
}
