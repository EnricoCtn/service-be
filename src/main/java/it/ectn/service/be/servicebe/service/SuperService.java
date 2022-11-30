package it.ectn.service.be.servicebe.service;

import it.ectn.service.be.servicebe.exception.ApiException;
import it.ectn.service.be.servicebe.utils.Constants;
import it.ectn.service.be.servicebe.utils.EnumUtils.ErrorsEnum;

public abstract class SuperService {

	protected void manageGenericException(int status) throws ApiException {
		if(status == Constants.ESITO_DB_OK) {
			throw new ApiException(ErrorsEnum.CUSTOMER_GENRICO_ERROR);
		}
	}
	
}
