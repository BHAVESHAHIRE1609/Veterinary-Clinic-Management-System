package com.petclinic.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petclinic.customeexception.ResourceNotFoundException;
import com.petclinic.customeexception.UserNotFoundException;
import com.petclinic.dto.ApiResponse;
import com.petclinic.dto.AppointReqDto;
import com.petclinic.pojos.Appointment;
import com.petclinic.pojos.AppointmentUser;
import com.petclinic.pojos.Doctor;
import com.petclinic.pojos.Pet;
import com.petclinic.pojos.PetOwner;
import com.petclinic.pojos.Receptionist;
import com.petclinic.pojos.Status;
import com.petclinic.repository.AppointmentRepository;
import com.petclinic.repository.AppointmentUserRepository;
import com.petclinic.repository.DoctorRepository;
import com.petclinic.repository.PetOwnerRepository;
import com.petclinic.repository.PetRepository;
import com.petclinic.repository.ReceptionistRepository;

@Service
@Transactional
public class ReceptionistServiceImpl implements ReceptionistService {
	
	@Autowired
	AppointmentRepository appointRepo;
	
	@Autowired
	DoctorRepository docRepo;
	
	@Autowired
	ModelMapper mapper;

	@Autowired
	ReceptionistRepository respRepo;
	
	@Autowired
	PetOwnerRepository petOwnerRepo;
	
	@Autowired
	PetRepository petRepo;
	
	@Autowired
	AppointmentUserRepository appointUserRepo;
	
	@Override
	public ApiResponse addAppoint(AppointReqDto appointReqDto) {
		Doctor doc=docRepo.findById(appointReqDto.getDoctorId()).orElseThrow(()->new UserNotFoundException("Invalid Id"));
		
		Receptionist resp=respRepo.findById(appointReqDto.getRecepId()).orElseThrow(()->new UserNotFoundException("Invalid Id"));
		
		PetOwner po=petOwnerRepo.findById(appointReqDto.getPetOwnerId()).orElseThrow(()->new UserNotFoundException("Invalid Id"));
		
		Pet p =petRepo.findById(appointReqDto.getPetId()).orElseThrow(()->new UserNotFoundException("Invalid Id"));
		
		Appointment appoint=mapper.map(appointReqDto,Appointment.class);
		
		resp.addAppoint(appoint);
		
		doc.addAppoint(appoint);
		
		appoint.setOwner(po);
		
		appoint.setPet(p);
		
		return new ApiResponse("Appointment Added Successfully!!");
		
	}

	@Override
	public ApiResponse approveAppoint(Long aptId, Long recptId) {
		AppointmentUser aps =appointUserRepo.findById(aptId).orElseThrow(()->new ResourceNotFoundException("Invalid Id"));
		Appointment apt=mapper.map(aps, Appointment.class);
		Receptionist r=respRepo.findById(aptId).orElseThrow(()->new ResourceNotFoundException("Invalid Id"));
		apt.setReceptionist(r);
		apt.setStatus(Status.ACCEPTED);
		Appointment perApt=appointRepo.save(apt);
		return new ApiResponse("Appointment is Accepted");
	}
	
	

}
