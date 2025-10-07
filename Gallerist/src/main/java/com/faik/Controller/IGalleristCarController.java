package com.faik.Controller;

import com.faik.Dto.DtoGalleristCar;
import com.faik.Dto.DtoGalleristCarIU;

public interface IGalleristCarController {
	public RootEntitiy<DtoGalleristCar> savedGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
