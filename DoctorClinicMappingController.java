package com.datastack.thehealthcare.controller.userview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.entity.DoctorClinicMapping;
import com.datastack.thehealthcare.model.userView.DoctorClinicMappingDTO;
import com.datastack.thehealthcare.model.userView.DoctorScheduleDTO;
import com.datastack.thehealthcare.serviceImpl.userview.DoctorClinicMappingService;
import com.datastack.thehealthcare.serviceImpl.userview.DoctorScheduleService;

@RestController
@RequestMapping("/mapping")
public class DoctorClinicMappingController {
	@Autowired
	DoctorClinicMappingService doctorClinicMappingService;
	
	@Autowired
	DoctorScheduleService doctorScheduleService;

	@PostMapping("/createMapping")
	public ResponseEntity<DoctorClinicMapping> createMapping(@RequestBody DoctorClinicMappingDTO doctorClinicMappingDTO) {
		return new ResponseEntity<>(doctorClinicMappingService.createMapping(doctorClinicMappingDTO), HttpStatus.OK);
	}
	@PostMapping("/scheduletDateAndTime")
	public ResponseEntity<Boolean> createDoctorSchedule(@RequestBody List<DoctorScheduleDTO> doctorSchedules){
		 return new ResponseEntity<>(doctorScheduleService.createSchedule(doctorSchedules), HttpStatus.OK);
	}
}
