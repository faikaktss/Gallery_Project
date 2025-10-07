package com.faik.Service.Impl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faik.Dto.DtoAddress;
import com.faik.Dto.DtoGallerist;
import com.faik.Dto.DtoGalleristIU;
import com.faik.Exception.BaseException;
import com.faik.Exception.ErrorMessage;
import com.faik.Exception.MessageType;
import com.faik.Model.Address;
import com.faik.Model.Gallerist;
import com.faik.Repository.AddressRepository;
import com.faik.Repository.GalleristRepository;
import com.faik.Service.IGalleristService;
@Service
public class GalleristService implements IGalleristService{

	@Autowired
	private GalleristRepository galleristRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {
		Optional<Address> optAddressOptional =  addressRepository.findById(dtoGalleristIU.getAddress_id());
		if(optAddressOptional.isEmpty()) {
			throw new BaseException(new ErrorMessage(dtoGalleristIU.getAddress_id().toString(), MessageType.NO_RECORD_EXIST));
		}
		
		Gallerist gallerist = new Gallerist();
		gallerist.setCreate_Time(new Date(System.currentTimeMillis()));
		
		BeanUtils.copyProperties(dtoGalleristIU, gallerist);
		gallerist.setAddress(optAddressOptional.get());
		return gallerist;
		
	}
	
	@Override
	public DtoGallerist savedGallerist(DtoGalleristIU dtoGalleristIU) {
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoAddress dtoAddress = new DtoAddress();
		
		 Gallerist savedGallerist =  galleristRepository.save(createGallerist(dtoGalleristIU));
		BeanUtils.copyProperties(savedGallerist, dtoGallerist);
		BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);
		
		dtoGallerist.setAddress(dtoAddress);
		 
		 return dtoGallerist;
	}

}
