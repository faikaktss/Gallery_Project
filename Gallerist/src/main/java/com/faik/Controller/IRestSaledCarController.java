package com.faik.Controller;

import com.faik.Dto.DtoSaledCar;
import com.faik.Dto.DtoSaledCarIU;

public interface IRestSaledCarController {
	public RootEntitiy<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
