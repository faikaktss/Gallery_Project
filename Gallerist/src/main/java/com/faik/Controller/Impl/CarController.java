package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.ICarController;
import com.faik.Controller.RestBaseController;
import com.faik.Controller.RootEntitiy;
import com.faik.Dto.DtoCar;
import com.faik.Dto.DtoCarIU;
import com.faik.Service.Impl.CarService;

@RestController
@RequestMapping("/rest/api/car")
public class CarController extends RestBaseController implements ICarController{

	@Autowired
	private CarService carService;
	
	@PostMapping("/save")
	@Override
	public RootEntitiy<DtoCar> savedCar(DtoCarIU dtoCarIU) {
		return ok(carService.savedCar(dtoCarIU));
	}

}
