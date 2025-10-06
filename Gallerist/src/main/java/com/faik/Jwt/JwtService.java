package com.faik.Jwt;

import java.security.Key;
import java.sql.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {


	public static final String SECRET_KEY = "XFqdghC9XtzWjENIacGc+cBtdhF0hNA54T1KTCWp7Qw=";

	
	public String generateToken(UserDetails userDetails) {
		 return Jwts.builder()
		.setSubject(userDetails.getUsername())
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60 *2))
		.signWith(getKey(), SignatureAlgorithm.HS256).
		compact();	
	}
	
	public <T> T exportToken(String token , Function<Claims, T> claimsFunc) {
		Claims claims =  getClaims(token);
		return claimsFunc.apply(claims);
	}
	
	//Token çözmek için kullanılır
	public Claims getClaims(String token) {
		Claims claims = Jwts.parserBuilder()
		.setSigningKey(getKey())
		.build()
		.parseClaimsJws(token).getBody();
		
		return claims;
	}
	
	public String getUserNameByToken(String token) {
		return exportToken(token, Claims::getSubject);
	}
	
	public boolean isTokenValid(String token) {
		Date experiedDate = (Date) exportToken(token, Claims::getExpiration);
		return new Date(System.currentTimeMillis()).before(experiedDate); // Token'ın geçerlilik süresini kontrol eder
	}
	
	public Key getKey() {
		byte[] bytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(bytes);
	}
}
