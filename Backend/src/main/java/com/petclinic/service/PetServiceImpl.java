package com.petclinic.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petclinic.customeexception.UserNotFoundException;
import com.petclinic.dto.ApiResponse;
import com.petclinic.dto.PetReqDto;
import com.petclinic.pojos.Pet;
import com.petclinic.pojos.PetOwner;
import com.petclinic.repository.PetOwnerRepository;
import com.petclinic.repository.PetRepository;

@Service
@Transactional
public class PetServiceImpl implements PetService {
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	PetOwnerRepository petOwnerRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public ApiResponse addPet(PetReqDto petReqDto) {
		PetOwner po=petOwnerRepository.findById(petReqDto.getOwnerId()).orElseThrow(()->new UserNotFoundException("Invalid User Id"));
		Pet p=mapper.map(petReqDto, Pet.class);
		po.addPet(p);
		
		return new ApiResponse("Pet Added Successfully!!");
	}

}
