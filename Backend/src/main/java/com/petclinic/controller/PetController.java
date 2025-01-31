package com.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.dto.PetReqDto;
import com.petclinic.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	PetService petService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPet(PetReqDto petReqDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(petService.addPet(petReqDto));
	}
	
}
