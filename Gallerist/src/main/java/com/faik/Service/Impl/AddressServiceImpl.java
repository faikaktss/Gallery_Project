package com.faik.Service.Impl;

import java.sql.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faik.Dto.DtoAddress;
import com.faik.Dto.DtoAdressIU;
import com.faik.Model.Address;
import com.faik.Repository.AddressRepository;
import com.faik.Service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	private Address createAddress(DtoAdressIU dtoAdressIU) { // Address oluşturma
		Address address = new Address();
		address.setCreate_Time(new Date(System.currentTimeMillis()));

		BeanUtils.copyProperties(dtoAdressIU, address);
		return address;
	}
	
	@Override
	public DtoAddress saveAddress(DtoAdressIU dtoAdressIU) {
		DtoAddress dtoAddress = new DtoAddress();
		
		Address savedAddress = addressRepository.save(createAddress(dtoAdressIU));
		BeanUtils.copyProperties(savedAddress, dtoAddress);
		return dtoAddress;
	}

}
