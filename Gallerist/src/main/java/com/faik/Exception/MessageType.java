package com.faik.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public enum MessageType {
	
	NO_RECORD_EXIST("1004","Kayıt bulunamadı"),
	TOKEN_IS_EXPERİED("1005","Token'ın süresi bitmiştir"),
	USERNAME_OR_PASSWORD_İSVALİD("1007","Kullanıcı adı veya şifre hatalıdır"),
	REFRESH_TEOKN_İSVALİD("1008","Refresh Token bulunamadı"),
	USERNAME_NOT_FOUND("1006","Kullanıcı bulunamadı"),
	GENERAL_EXCEPTION("9999","Genel bir hata oluştu");

	private String code;
	
	private String message;
	
	private MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
