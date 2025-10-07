package com.faik.Controller;

import com.faik.Dto.DtoAccount;
import com.faik.Dto.DtoAccountIU;

public interface ISavedAccountController {
	public RootEntitiy<DtoAccount> savedAccount(DtoAccountIU dtoAccountIU);
}
