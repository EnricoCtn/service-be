package it.ectn.service.be.servicebe.model;

public class CustomerView {
	
	String id;
	String name;
	String surname;
	String fiscalCode;
	String andress;
	
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
