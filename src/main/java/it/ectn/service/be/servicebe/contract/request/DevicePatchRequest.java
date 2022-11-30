package it.ectn.service.be.servicebe.contract.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.ectn.service.be.servicebe.contract.Device;

@JsonIgnoreProperties({"id","idUser"})
public class DevicePatchRequest extends Device {

}
