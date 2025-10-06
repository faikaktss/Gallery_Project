package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Model.ResfrehToken;

@Repository
public interface RefreshTokenRepository  extends JpaRepository<ResfrehToken, Long>{

}
