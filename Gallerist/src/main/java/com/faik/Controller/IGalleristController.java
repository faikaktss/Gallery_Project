package com.faik.Controller;

import com.faik.Dto.DtoGallerist;
import com.faik.Dto.DtoGalleristIU;

public interface IGalleristController {
	public RootEntitiy<DtoGallerist> savedGallerist(DtoGalleristIU dtoGalleristIU);
}
