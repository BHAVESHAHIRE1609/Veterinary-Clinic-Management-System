package com.petclinic.service;

import com.petclinic.dto.ApiResponse;
import com.petclinic.dto.AppointUserReqDto;

public interface PetOwnerService {

	public ApiResponse addAppointment(AppointUserReqDto appointUserReqDto);

}
