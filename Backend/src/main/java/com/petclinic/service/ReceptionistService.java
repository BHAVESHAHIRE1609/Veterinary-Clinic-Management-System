package com.petclinic.service;

import com.petclinic.dto.ApiResponse;
import com.petclinic.dto.AppointReqDto;

public interface ReceptionistService {

	public ApiResponse addAppoint(AppointReqDto appointReqDto);

	public ApiResponse approveAppoint(Long aptId, Long recptId);
	
	
}
