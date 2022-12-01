package it.ectn.service.be.servicebe.utils;

import org.apache.commons.lang3.StringUtils;

public class RepositoryUtils {

	private RepositoryUtils() throws IllegalAccessException {
		throw new IllegalAccessException("Utility Class");
	}
	
	public static void cleanWhereStatement(String whereStatement) {
		if(StringUtils.isNotBlank(whereStatement)) {
			whereStatement.replaceFirst("AND", StringUtils.EMPTY);
		}
	}
	
}
