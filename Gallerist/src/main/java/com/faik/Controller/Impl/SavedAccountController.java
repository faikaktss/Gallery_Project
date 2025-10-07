package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.ISavedAccountController;
import com.faik.Controller.RestBaseController;
import com.faik.Controller.RootEntitiy;
import com.faik.Dto.DtoAccount;
import com.faik.Dto.DtoAccountIU;
import com.faik.Service.IAccountService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/rest/api/account")
public class SavedAccountController extends RestBaseController  implements ISavedAccountController{

	@Autowired
	private IAccountService accountService;
	
	@PostMapping("save")
	@Override
	public RootEntitiy<DtoAccount> savedAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {

		return ok(accountService.saveAccount(dtoAccountIU));
	}

}
