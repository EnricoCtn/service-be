package it.ectn.service.be.servicebe.contract;

public class Customer {

	private String id;
	private String name;
	private String surname;
	private String fiscalCode;
	private String andress;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFiscalCode() {
		return fiscalCode;
	}
	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public String getAndress() {
		return andress;
	}
	public void setAndress(String andress) {
		this.andress = andress;
	}
	
}
