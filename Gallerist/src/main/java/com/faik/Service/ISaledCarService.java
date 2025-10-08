package com.faik.Service;

import com.faik.Dto.DtoSaledCar;
import com.faik.Dto.DtoSaledCarIU;

public interface ISaledCarService {

	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);
}
