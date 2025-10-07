package com.faik.Controller;

import com.faik.Dto.DtoCar;
import com.faik.Dto.DtoCarIU;

public interface ICarController {
	public RootEntitiy<DtoCar> savedCar(DtoCarIU dtoCarIU);
}
