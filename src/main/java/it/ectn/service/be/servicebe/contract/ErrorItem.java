package it.ectn.service.be.servicebe.contract;

public class ErrorItem {
	
	private String code;
	private String description;
	
	public ErrorItem(String code,String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
