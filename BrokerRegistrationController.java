package com.datastack.thehealthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.model.Registration;
import com.datastack.thehealthcare.serviceImpl.RegistrationService;
import com.datastack.thehealthcare.util.JwtUtil;

@RestController
@RequestMapping("/registration")
public class BrokerRegistrationController {

	@Autowired
	RegistrationService registrationService;

	@Autowired
	JwtUtil jwtUtil;

	@PostMapping("/userRegistration")
public ResponseEntity<String> createUser(@RequestBody Registration registration, @RequestHeader("Authorization") String authorizationHeader){
            String token = authorizationHeader.substring(7); // Remove "Bearer " prefix
		return new ResponseEntity<>(registrationService.doRegistration(registration, jwtUtil.extractUserId(token)), HttpStatus.OK);
}

	@PostMapping("/userRegistration/{mobileNumber}")
	public ResponseEntity<String> createUser(@PathVariable Long mobileNumber) {
		return new ResponseEntity<>(registrationService.doRegistration(mobileNumber), HttpStatus.OK);
	}
//
//	@PostMapping("/forgetPassword")
//	public ResponseEntity<String> forgetPassword(@RequestBody Registration registration) {
//		return new ResponseEntity<>(registrationService.doRegistration(registration), HttpStatus.OK);
//	}

	@PostMapping("/userRegistration/{mobileNumber}/{otp}")
	public ResponseEntity<String> otpVerification(@PathVariable Long mobileNumber, @PathVariable Long otp) {
		return new ResponseEntity<>(registrationService.doRegistration(mobileNumber), HttpStatus.OK);
	}
	
	@GetMapping("/validateMobileNumber/{mobileNumber}")
	public ResponseEntity<Boolean> validateMobileNumber(@PathVariable Long mobileNumber){
		return new ResponseEntity<>(registrationService.validateMobileNumber(mobileNumber), HttpStatus.OK);
	}
	
	
	
}
