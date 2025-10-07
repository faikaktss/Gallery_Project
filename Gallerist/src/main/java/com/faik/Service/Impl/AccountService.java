package com.faik.Service.Impl;

import java.sql.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faik.Dto.DtoAccount;
import com.faik.Dto.DtoAccountIU;
import com.faik.Model.Account;
import com.faik.Repository.AccountRepository;
import com.faik.Service.IAccountService;

@Service
public class AccountService implements IAccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	private Account createAccount(DtoAccountIU dtoAccountIU) {
		Account account = new Account();
		account.setCreate_Time(new Date(System.currentTimeMillis()));
		
		BeanUtils.copyProperties(dtoAccountIU, account);
		return account;
	}
	
	@Override
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
		DtoAccount dtoAccount = new DtoAccount();
		Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
		
		BeanUtils.copyProperties(savedAccount, dtoAccount);
		return dtoAccount;
	}

}
