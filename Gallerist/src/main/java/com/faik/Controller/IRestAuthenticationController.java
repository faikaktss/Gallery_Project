package com.faik.Controller;

import com.faik.Dto.AuthRefreshToken;
import com.faik.Dto.AuthRequest;
import com.faik.Dto.AuthResponse;
import com.faik.Dto.DtoUser;

public interface IRestAuthenticationController {
	
	public RootEntitiy<DtoUser> register(AuthRequest input);
	
	public RootEntitiy<AuthResponse> authenticate(AuthRequest input);
	
	public RootEntitiy<AuthResponse> refreshToken(AuthRefreshToken input);
}
