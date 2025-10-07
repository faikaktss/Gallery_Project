package com.faik.Service;

import com.faik.Dto.DtoGalleristCar;
import com.faik.Dto.DtoGalleristCarIU;
import com.faik.Dto.DtoGalleristIU;

public interface IGalleristCarService {
	public DtoGalleristCar savedGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
