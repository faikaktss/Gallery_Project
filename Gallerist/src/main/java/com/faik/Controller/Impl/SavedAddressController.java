package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.ISavedAddressController;
import com.faik.Controller.RestBaseController;
import com.faik.Controller.RootEntitiy;
import com.faik.Dto.DtoAddress;
import com.faik.Dto.DtoAdressIU;
import com.faik.Service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/address")
public class SavedAddressController extends RestBaseController implements ISavedAddressController{

	@Autowired
	private IAddressService addressService;
	
	@PostMapping("/save")
	@Override
	public RootEntitiy<DtoAddress> savedAddress(@Valid @RequestBody DtoAdressIU dtoAdressIU) {

		return ok(addressService.saveAddress(dtoAdressIU));
	}

}
