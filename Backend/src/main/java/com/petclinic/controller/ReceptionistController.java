package com.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.dto.AppointReqDto;
import com.petclinic.service.ReceptionistService;

@RestController
@RequestMapping("/Receptionist")
public class ReceptionistController {

	@Autowired
	ReceptionistService appointService;
	
	@PostMapping("/add/appointment")
	public ResponseEntity<?> addAppointment(AppointReqDto appointReqDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(appointService.addAppoint(appointReqDto));
	}
	
	@PostMapping("/approve/addappointment/{aptId}/{recptId}")
	public ResponseEntity<?> approveAppointment(@PathVariable Long aptId,@PathVariable Long recptId ){
		return ResponseEntity.ok(appointService.approveAppoint(aptId,recptId));
	}
}
