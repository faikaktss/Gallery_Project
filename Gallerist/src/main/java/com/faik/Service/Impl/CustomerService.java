package com.faik.Service.Impl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.faik.Config.AppConfig;
import com.faik.Dto.DtoAccount;
import com.faik.Dto.DtoAddress;
import com.faik.Dto.DtoCustomer;
import com.faik.Dto.DtoCustomerIU;
import com.faik.Exception.BaseException;
import com.faik.Exception.ErrorMessage;
import com.faik.Exception.MessageType;
import com.faik.Model.Account;
import com.faik.Model.Address;
import com.faik.Model.Customer;
import com.faik.Repository.AccountRepository;
import com.faik.Repository.AddressRepository;
import com.faik.Repository.CustomerRepository;
import com.faik.Service.ICustomerService;

@Service
public class CustomerService implements ICustomerService{



	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;


	
	private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
		 Optional<Address> optAddress  =  addressRepository.findById(dtoCustomerIU.getAddress_id());
		if(optAddress.isEmpty()) {
			throw new BaseException(new ErrorMessage(null, MessageType.GENERAL_EXCEPTION));
		}
		Optional<Account>  optAccount= accountRepository.findById(dtoCustomerIU.getAccount_id());
		if(optAccount.isEmpty()) {
			throw new BaseException(new ErrorMessage(null,MessageType.GENERAL_EXCEPTION));
		}
		 
		Customer customer = new Customer();
		customer.setCreate_Time(new Date(System.currentTimeMillis()));
		
		BeanUtils.copyProperties(dtoCustomerIU, customer);
		customer.setAccount(optAccount.get());
		customer.setAddress(optAddress.get());

		return customer;
	}
	
	@Override
	public DtoCustomer savedCustomer(DtoCustomerIU dtoCustomerIU) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		DtoAccount dtoAccount = new DtoAccount();
		
		Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));
		
		BeanUtils.copyProperties(savedCustomer, dtoCustomer);
		BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
		BeanUtils.copyProperties(savedCustomer.getAccount(), dtoCustomer);
		
		dtoCustomer.setAddress(dtoAddress);
		dtoCustomer.setAccount(dtoAccount);
		
		
		return dtoCustomer;
		
	}

}
