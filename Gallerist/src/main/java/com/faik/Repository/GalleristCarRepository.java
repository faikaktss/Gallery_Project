package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Model.GalleristCar;


@Repository
public interface GalleristCarRepository extends JpaRepository<GalleristCar, Long>{

}
