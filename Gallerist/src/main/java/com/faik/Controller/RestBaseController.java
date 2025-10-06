package com.faik.Controller;



public class RestBaseController {

	public <T> RootEntitiy<T> ok(T payload){
		 return  RootEntitiy.Ok(payload);
	}
	
	public <T> RootEntitiy<T> Error(String errorMessage){
		return RootEntitiy.error(errorMessage);
	}
}
