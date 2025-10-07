package com.faik.Service.Impl;


import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faik.Dto.DtoAddress;
import com.faik.Dto.DtoCar;
import com.faik.Dto.DtoGallerist;
import com.faik.Dto.DtoGalleristCar;
import com.faik.Dto.DtoGalleristCarIU;
import com.faik.Exception.BaseException;
import com.faik.Exception.ErrorMessage;
import com.faik.Exception.MessageType;
import com.faik.Model.Car;
import com.faik.Model.Gallerist;
import com.faik.Model.GalleristCar;
import com.faik.Repository.CarRepository;
import com.faik.Repository.GalleristCarRepository;
import com.faik.Repository.GalleristRepository;
import com.faik.Service.IGalleristCarService;

@Service
public class GalleristCarService implements IGalleristCarService{


	@Autowired
	private GalleristCarRepository galleristCarRepository;
	
	@Autowired
	private GalleristRepository galleristRepository;
	
	@Autowired
	private CarRepository carRepository;

 
	private  GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		Optional<Gallerist> optGallerist =  galleristRepository.findById(dtoGalleristCarIU.getGallerist_id());
		if(optGallerist.isEmpty()) {
			throw new BaseException(new ErrorMessage(dtoGalleristCarIU.getGallerist_id().toString(),MessageType.GENERAL_EXCEPTION));
		}
		Optional<Car> optCar =  carRepository.findById(dtoGalleristCarIU.getCar_id());
		if(optCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(dtoGalleristCarIU.getCar_id().toString(),MessageType.GENERAL_EXCEPTION));
		}
		
		GalleristCar galleristCar  = new GalleristCar();
		galleristCar.setCreate_Time(new Date(System.currentTimeMillis()));
		galleristCar.setCar(optCar.get());
		galleristCar.setGallerist(optGallerist.get());
		
		return galleristCar;
	}
	
	@Override
	public DtoGalleristCar savedGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoCar dtoCar = new DtoCar();
		
		DtoAddress dtoAddress = new DtoAddress();
		
	     GalleristCar savedGalleristCar = 	galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));
	     BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
	     BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
	     BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
	     BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);
		
		BeanUtils.copyProperties(dtoCar, dtoAddress);
		
		dtoGallerist.setAddress(dtoAddress);
		dtoGalleristCar.setGallerist(dtoGallerist);
		dtoGalleristCar.setCar(dtoCar);


		return dtoGalleristCar;
	}

}
