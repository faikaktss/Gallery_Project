package com.faik.Service.Impl;

import java.awt.TrayIcon.MessageType;
import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Lettuce.Cluster.Refresh;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.faik.Dto.AuthRefreshToken;
import com.faik.Dto.AuthRequest;
import com.faik.Dto.AuthResponse;
import com.faik.Dto.DtoUser;
import com.faik.Exception.BaseException;
import com.faik.Exception.ErrorMessage;
import com.faik.Jwt.JwtService;
import com.faik.Model.ResfrehToken;
import com.faik.Model.User;
import com.faik.Repository.RefreshTokenRepository;
import com.faik.Repository.UserRepository;
import com.faik.Service.IAuthenticationService;



@Service
public class AuthenticationServiceIMPL  implements IAuthenticationService{

    private final AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

    AuthenticationServiceIMPL(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
	
	private User createUser(AuthRequest input) {
		User user = new User();
		user.setCreate_Time(new Date(System.currentTimeMillis()));
		user.setUsername(input.getUsername());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		
		return user;
	}

	private ResfrehToken createResfrehToken(User user) {
		ResfrehToken resfrehToken = new ResfrehToken();
		resfrehToken.setCreate_Time(new Date(System.currentTimeMillis()));
		resfrehToken.setExperiedDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
		resfrehToken.setRefreshToken(UUID.randomUUID().toString());
		resfrehToken.setUser(user);
		return resfrehToken;
		
	}
	
	
	@Override
	public DtoUser register(AuthRequest input) {
		DtoUser dtoUser = new DtoUser();
		
		User savedUser =  userRepository.save(createUser(input));
		
		BeanUtils.copyProperties(savedUser, dtoUser);
		
		return dtoUser;
	}

	
	public AuthResponse authenticate(AuthRequest input) {

		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
			
			authenticationProvider.authenticate(authenticationToken);
			
			
			Optional<User> opUser =  userRepository.findByUsername(input.getUsername());
			
			String accessToken = jwtService.generateToken(opUser.get());
			ResfrehToken resfrehToken =  createResfrehToken(opUser.get());
			
			ResfrehToken savedResfrehToken= refreshTokenRepository.save(resfrehToken);
			
			return new AuthResponse(accessToken,savedResfrehToken.getRefreshToken());
			
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(e.getMessage(), com.faik.Exception.MessageType.USERNAME_OR_PASSWORD_İSVALİD));
		}
		
	}
	
	private boolean isValidRefreshToken(Date string) {
		return new Date(System.currentTimeMillis()).before(string);
	}



	@Override
	public AuthResponse refreshToken(AuthRefreshToken input) {
		Optional<ResfrehToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken()); // veritabanından refreshtoken aldık
		
		if(optRefreshToken.isEmpty()) {
			throw new BaseException(new ErrorMessage(input.getRefreshToken(), com.faik.Exception.MessageType.TOKEN_IS_EXPERİED));
		}
		
		if(isValidRefreshToken(optRefreshToken.get().getExperiedDate())) {
			throw new BaseException(new ErrorMessage(input.getRefreshToken(), com.faik.Exception.MessageType.TOKEN_IS_EXPERİED));
		}
		
		User user = optRefreshToken.get().getUser();
		String accessToken = jwtService.generateToken(user);
		ResfrehToken savedResfrehToken = refreshTokenRepository.save(createResfrehToken(user)); // Yeni refreshToken'ı veritabanına kaydettik
		
		return new AuthResponse(accessToken, savedResfrehToken.getRefreshToken());
		
	}
	
}
