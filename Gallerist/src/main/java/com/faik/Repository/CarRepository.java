package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Model.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Long>{ 

}
