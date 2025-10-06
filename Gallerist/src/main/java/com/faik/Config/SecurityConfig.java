package com.faik.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.faik.Jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	public static final String REGISTER = "/register";
	public static final String AUTHENTİCATE = "/authenticate";
	public static final String REFRESH_TOKEN = "/refreshToken";
	
	@Bean
	public SecurityFilterChain  filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().
		authorizeHttpRequests(request ->
		request.requestMatchers(REGISTER, AUTHENTİCATE , REFRESH_TOKEN).permitAll().
		anyRequest().
		authenticated()).
		exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and().
		sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
		authenticationProvider(authenticationProvider).
		addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}
