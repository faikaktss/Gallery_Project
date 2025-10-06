package com.faik.Handler;

import java.awt.List;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.faik.Exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = {BaseException.class})
	public ResponseEntity<ApiError<?>> handleException(BaseException ex,WebRequest request) {
		return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request));
	}
	

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<ApiError<?>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex , 
			WebRequest request) {
		Map<String, List<String>> map = new HashMap<>();
		for (ObjectError objectError: ex.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError)objectError).getField();

			if(map.containsKey(fieldName)) {
				map.put(fieldName,addValue(map.get(fieldName),objectError.getDefaultMessage()));
			}else {
				map.put(fieldName,addValue(new ArrayList<String>(),objectError.getDefaultMessage());
			}
		}
		
		return  ResponseEntity.badRequest().body(createApiError(map, request));
	}
	
	private List<String> addValue(List<String> list, String newValue){
		list.add(newValue);
		return list;
	}

	private String hostName() {
		try {
			return Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return " "; 
	}
	
	public <E> ApiError<E> createApiError(E message, WebRequest request){
		ApiError<E> apiError = new ApiError<>();
		apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		Exception<E> exception = new Exception<>();
		exception.setCreateTime(new Date(System.currentTimeMillis()));
		exception.setPath(request.getDescription(false).substring(4));
		exception.setMessage(message);
		exception.setHostName(hostName());
		
		apiError.setException(exception);
		
		
		return apiError;
	}
}
