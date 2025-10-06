package com.faik.Controller;

import java.awt.TrayIcon.MessageType;

import org.springframework.beans.factory.annotation.Autowired;

import com.faik.Exception.ErrorMessage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RootEntitiy <T> {
	
	
	@Autowired
	private MessageType messageType;
	
	private Integer status;
	
	private T payload;
	
	private String errorMessage;
	
	public static <T> RootEntitiy<T> Ok(T payload){
		RootEntitiy<T> rootEntitiy = new RootEntitiy<>();
		rootEntitiy.setStatus(200);
		rootEntitiy.setErrorMessage(null);
		rootEntitiy.setPayload(payload);
		return rootEntitiy;
	}
	
	public static <T> RootEntitiy<T> error(String errorMessage){
		RootEntitiy<T> rootEntitiy = new RootEntitiy<>();
		rootEntitiy.setStatus(500);
		rootEntitiy.setPayload(null);
		rootEntitiy.setErrorMessage(errorMessage);
		
		return rootEntitiy;
	}
}
