package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.IRestAuthenticationController;
import com.faik.Controller.RestBaseController;
import com.faik.Controller.RootEntitiy;
import com.faik.Dto.AuthRefreshToken;
import com.faik.Dto.AuthRequest;
import com.faik.Dto.AuthResponse;
import com.faik.Dto.DtoUser;
import com.faik.Service.IAuthenticationService;

import jakarta.validation.Valid;

@RestController
public class RestAuthenticationController extends RestBaseController implements IRestAuthenticationController{

	@Autowired
	private IAuthenticationService authenticationService;
    
	@PostMapping("/register")
	@Override
	public RootEntitiy<DtoUser> register(@Valid @RequestBody AuthRequest input) {
		return ok(authenticationService.register(input));
		
	}


	
	@PostMapping("/authenticate")
	@Override
	public RootEntitiy<AuthResponse> authenticate(@Valid @RequestBody AuthRequest input) {

		return ok(authenticationService.authenticate(input));
	}


	@PostMapping("/refreshToken")
	@Override
	public RootEntitiy<AuthResponse> refreshToken(@Valid @RequestBody AuthRefreshToken input) { // @Valid-> Anatasyonların çalışmasını sağlar
		return ok(authenticationService.refreshToken(input));
	}
}
