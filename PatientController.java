package com.datastack.thehealthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.entity.patient.PatientDetails;
import com.datastack.thehealthcare.model.PatientDto;
import com.datastack.thehealthcare.model.PatientInfoDto;
import com.datastack.thehealthcare.serviceImpl.PatientService;
import com.datastack.thehealthcare.util.JwtUtil;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	JwtUtil jwtUtil;
	
@Autowired
PatientService patientService;
@PostMapping("/booking")
public ResponseEntity<Long> patientRegistration(@RequestBody PatientDto patientDto) {
    try {
        Long patientId = patientService.registerPatient(patientDto);
        return new ResponseEntity<>(patientId, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

@GetMapping("/getAllPatientbyId/{id}")
public ResponseEntity<List<PatientDetails>> getAllPatientById(@PathVariable Long id){
	return new ResponseEntity<>(patientService.getPatientByUserId(id), HttpStatus.OK);
}

@PostMapping("/updateBooking")
public ResponseEntity<Long> updatePatientById(@RequestBody PatientDto patientDto){
	return new ResponseEntity<>(patientService.updatePatient(patientDto), HttpStatus.OK);
}

@GetMapping("/getPatientByMobileNumber/{mobileNumber}/{clinicId}")
public ResponseEntity<PatientDto> findPatientByMobileNumber(@PathVariable Long mobileNumber,@PathVariable Long clinicId){
	return new ResponseEntity<>(patientService.findPatientByMobileNumber(mobileNumber, clinicId), HttpStatus.OK);
}

@GetMapping("/getAllAdmittedPatient/{requestType}")
public ResponseEntity<List<PatientInfoDto>> getAllPatient(@PathVariable String requestType){
	return new ResponseEntity<>(patientService.getAllAdmittedPattient(requestType), HttpStatus.OK);
}

@GetMapping("/checkMobileNumber/{mobileNumber}")
public ResponseEntity<Boolean> validateMobileNumber(@PathVariable Long mobileNumber){
	return new ResponseEntity<>(patientService.validateMobileNumber(mobileNumber), HttpStatus.OK);
}
}
