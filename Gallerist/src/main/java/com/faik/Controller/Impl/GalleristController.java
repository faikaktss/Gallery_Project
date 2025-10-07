package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faik.Controller.IGalleristController;
import com.faik.Controller.RestBaseController;
import com.faik.Controller.RootEntitiy;
import com.faik.Dto.DtoGallerist;
import com.faik.Dto.DtoGalleristIU;
import com.faik.Service.Impl.GalleristService;

@RequestMapping("/rest/api/gallerist")
public class GalleristController extends RestBaseController implements IGalleristController{

	@Autowired
	private GalleristService galleristService;
	
	@PostMapping("/save")
	@Override
	public RootEntitiy<DtoGallerist> savedGallerist(DtoGalleristIU dtoGalleristIU) {
		return ok(galleristService.savedGallerist(dtoGalleristIU));
	}

}
