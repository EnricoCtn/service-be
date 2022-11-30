package it.ectn.service.be.servicebe.exception;

import org.springframework.http.HttpStatus;

import it.ectn.service.be.servicebe.contract.ErrorItem;
import it.ectn.service.be.servicebe.utils.EnumUtils.ErrorsEnum;

public class ApiException extends Exception {

	private static final long serialVersionUID = 1L;

	private ErrorItem error;
	private HttpStatus httpStatus;

	public ApiException(ErrorsEnum errorEnum) {
		this.error = new ErrorItem(errorEnum.getCodice(), errorEnum.getDescrizione());
		this.httpStatus = errorEnum.getHttpStauts();
	}

	public ErrorItem getError() {
		return error;
	}

	public void setError(ErrorItem error) {
		this.error = error;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
