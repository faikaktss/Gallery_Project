package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Model.SaledCar;

@Repository
public interface SaledCarRepository  extends JpaRepository<SaledCar, Long>{

}
