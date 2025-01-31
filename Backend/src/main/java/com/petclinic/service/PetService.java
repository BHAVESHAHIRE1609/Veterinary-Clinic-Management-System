package com.petclinic.service;

import com.petclinic.dto.ApiResponse;
import com.petclinic.dto.PetReqDto;

public interface PetService {

	public ApiResponse addPet(PetReqDto petReqDto) ;
		
}

