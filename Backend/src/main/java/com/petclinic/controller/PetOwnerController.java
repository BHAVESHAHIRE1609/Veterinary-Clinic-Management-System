package com.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.dto.AppointUserReqDto;
import com.petclinic.service.PetOwnerService;

@RestController
@RequestMapping("/petowner")
public class PetOwnerController {

	@Autowired
	PetOwnerService petOwnerService;
	
	@PostMapping("/addAppointment")
	public ResponseEntity<?> addAppoint(AppointUserReqDto appointUserReqDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(petOwnerService.addAppointment(appointUserReqDto));
	}
}
