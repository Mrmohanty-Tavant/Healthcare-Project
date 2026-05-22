package com.datastack.thehealthcare.controller.userview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datastack.thehealthcare.entity.DoctorProfile;
import com.datastack.thehealthcare.model.userView.DoctorProfileDTO;
import com.datastack.thehealthcare.serviceImpl.userview.DoctorProfileService;

@Controller
@RequestMapping("/doctor")
public class DoctorProfileController {
	@Autowired
	DoctorProfileService doctorProfileService;
@PostMapping("/register")
	public ResponseEntity<DoctorProfile> createDoctorProfile(@RequestBody DoctorProfileDTO doctorProfileDTO){
		return new ResponseEntity<>(doctorProfileService.createDoctorProfile(doctorProfileDTO), HttpStatus.OK);
	}
}
