package com.faik.Service;

import com.faik.Dto.DtoAddress;
import com.faik.Dto.DtoAdressIU;

public interface IAddressService {

	public DtoAddress saveAddress(DtoAdressIU dtoAdressIU);
}
