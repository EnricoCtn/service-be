package it.ectn.service.be.servicebe.utils;

import org.springframework.http.HttpStatus;

public class EnumUtils {

	public static enum ErrorsEnum{
		
		CUSTOMER_GENRICO_ERROR(HttpStatus.NOT_FOUND,"C000","Customer Error"),
		CUSTOMER_NOT_FOUND(HttpStatus.NOT_FOUND,"C001","Customer non trovato");
		
		private final HttpStatus httpStauts;
		private final String codice;
		private final String descrizione;
		
		ErrorsEnum(HttpStatus httpStatus,String codice,String descrizione){
			this.httpStauts = httpStatus;
			this.codice = codice;
			this.descrizione = descrizione;
		}

		public HttpStatus getHttpStauts() {
			return httpStauts;
		}

		public String getCodice() {
			return codice;
		}

		public String getDescrizione() {
			return descrizione;
		}
	}
	
	public static enum DeviceStatusEnum {

		ACTIVE("ACTIVE"), LOST("LOST"), INACTIVE("INACTIVE");

		private final String codice;

		DeviceStatusEnum(String codice) {
			this.codice = codice;
		}

		public String getCodice() {
			return codice;
		}
	}
	
}
