package com.faik.Service.Impl;

import java.sql.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faik.Dto.DtoCar;
import com.faik.Dto.DtoCarIU;
import com.faik.Model.Car;
import com.faik.Repository.CarRepository;
import com.faik.Service.ICarService;

@Service
public class CarService implements ICarService{

	@Autowired
	private CarRepository carRepository;
	
	private  Car createCar(DtoCarIU dtoCarIU) {
		Car car = new Car();
		
		car.setCreate_Time(new Date(System.currentTimeMillis()));
		BeanUtils.copyProperties(dtoCarIU, car);
		return car;
	}
	
	@Override
	public DtoCar savedCar(DtoCarIU dtoCarIU) {
		DtoCar dtoCar  = new DtoCar();
		Car savedCar =   carRepository.save(createCar(dtoCarIU));
		
		BeanUtils.copyProperties(savedCar, dtoCar);
		
		return dtoCar;
	}

}
