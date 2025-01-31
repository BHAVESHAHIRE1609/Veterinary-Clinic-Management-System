package com.petclinic.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petclinic.dto.ApiResponse;
import com.petclinic.dto.AppointUserReqDto;
import com.petclinic.pojos.AppointmentUser;
import com.petclinic.pojos.Status;
import com.petclinic.repository.AppointmentUserRepository;

@Service
@Transactional
public class PetOwnerServiceImpl implements PetOwnerService{
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	AppointmentUserRepository appointUserRepo;

	@Override
	public ApiResponse addAppointment(AppointUserReqDto appointUserReqDto) {
		AppointmentUser appointUser= mapper.map(appointUserReqDto,AppointmentUser.class);
		appointUser.setStatus(Status.PENDING);
		AppointmentUser perAppointUser=appointUserRepo.save(appointUser);
		return new ApiResponse(" Appointment Added Successfully!");
	}
	
}
