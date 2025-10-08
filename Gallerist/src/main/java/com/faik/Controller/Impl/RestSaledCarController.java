package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.IRestSaledCarController;
import com.faik.Controller.RestBaseController;
import com.faik.Controller.RootEntitiy;
import com.faik.Dto.DtoSaledCar;
import com.faik.Dto.DtoSaledCarIU;
import com.faik.Service.ISaledCarService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/rest/api/saled-car")
public class RestSaledCarController extends RestBaseController implements IRestSaledCarController{

	@Autowired
	private ISaledCarService saledCarService;
	
	
	@PostMapping("/save")
	@Override
	public RootEntitiy<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {

		return ok(saledCarService.buyCar(dtoSaledCarIU));
	}

}
