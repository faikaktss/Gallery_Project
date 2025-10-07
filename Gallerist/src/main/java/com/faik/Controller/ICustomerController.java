package com.faik.Controller;

import com.faik.Dto.DtoCustomer;
import com.faik.Dto.DtoCustomerIU;

public interface ICustomerController {
	public RootEntitiy<DtoCustomer> saveCustomer (DtoCustomerIU dtoCustomerIU);
}
