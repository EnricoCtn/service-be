package it.ectn.service.be.servicebe.contract.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.ectn.service.be.servicebe.contract.Device;

@JsonIgnoreProperties({"id"})
public class DeviceInsertRequest extends Device{

}
