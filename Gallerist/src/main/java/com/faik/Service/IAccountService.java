package com.faik.Service;

import com.faik.Dto.DtoAccount;
import com.faik.Dto.DtoAccountIU;

public interface IAccountService {
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
