package com.datastack.thehealthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.ipd.dto.DetailsData;
import com.datastack.thehealthcare.model.OtpaymentInfoDto;
import com.datastack.thehealthcare.serviceImpl.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
@Autowired
private DoctorService doctorService;
	@GetMapping("/getDoctorList/{departmentId}/{clinicId}")
	public ResponseEntity<List<DetailsData>> getDoctorDetails(@PathVariable String departmentId, @PathVariable Long clinicId){
		return new ResponseEntity<>(doctorService.getDoctorList(departmentId, clinicId), HttpStatus.OK);
	}
	
	@GetMapping("/getDoctorPayment/{bookingId}")
	public ResponseEntity<OtpaymentInfoDto> getDoctorPayment(@PathVariable Long bookingId){
		return new ResponseEntity<>(doctorService.getPendingDoctorPayment(bookingId), HttpStatus.OK);
	}
	
	
}
