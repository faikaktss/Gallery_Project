package com.faik.Exception;

public class BaseException  extends RuntimeException{
	public BaseException(ErrorMessage errorMessage) {
		super(errorMessage.prepareErrorMessage());
	}
}
