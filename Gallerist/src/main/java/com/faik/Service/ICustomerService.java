package com.faik.Service;

import com.faik.Dto.DtoCustomer;
import com.faik.Dto.DtoCustomerIU;

public interface ICustomerService {
	public DtoCustomer savedCustomer(DtoCustomerIU dtoCustomerIU);
}	
