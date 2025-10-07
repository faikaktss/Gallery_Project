package com.faik.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Dto.AuthRefreshToken;
import com.faik.Model.ResfrehToken;

@Repository
public interface RefreshTokenRepository  extends JpaRepository<ResfrehToken, Long>{
	
	Optional<ResfrehToken> findByRefreshToken(String refreshToken);
}
