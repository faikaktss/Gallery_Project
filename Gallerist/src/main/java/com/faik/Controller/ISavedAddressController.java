package com.faik.Controller;

import com.faik.Dto.DtoAddress;
import com.faik.Dto.DtoAdressIU;

public interface ISavedAddressController {
	public RootEntitiy<DtoAddress> savedAddress(DtoAdressIU dtoAdressIU);
}
