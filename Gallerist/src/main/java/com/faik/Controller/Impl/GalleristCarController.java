package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.IGalleristCarController;
import com.faik.Controller.RestBaseController;
import com.faik.Controller.RootEntitiy;
import com.faik.Dto.DtoGalleristCar;
import com.faik.Dto.DtoGalleristCarIU;
import com.faik.Service.Impl.GalleristCarService;

@RestController
@RequestMapping("/rest/api/GalleristCar")
public class GalleristCarController extends RestBaseController implements IGalleristCarController{

	@Autowired
	private GalleristCarService galleristCarService;
	
	@PostMapping("/save")
	@Override
	public RootEntitiy<DtoGalleristCar> savedGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		return ok(galleristCarService.savedGalleristCar(dtoGalleristCarIU));
	}

}
