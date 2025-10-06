package com.faik.Service;

import com.faik.Dto.AuthRequest;
import com.faik.Dto.AuthResponse;
import com.faik.Dto.DtoUser;

public interface IAuthenticationService {
	
	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
}
