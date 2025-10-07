package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.ICustomerController;
import com.faik.Controller.RestBaseController;
import com.faik.Controller.RootEntitiy;
import com.faik.Dto.DtoCustomer;
import com.faik.Dto.DtoCustomerIU;
import com.faik.Service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerController extends RestBaseController implements ICustomerController{

	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/save")
	@Override
	public RootEntitiy<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
		return ok(customerService.savedCustomer(dtoCustomerIU));
	}

}
