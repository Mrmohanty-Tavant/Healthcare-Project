package com.datastack.thehealthcare.controller.userview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datastack.thehealthcare.entity.ClinicDetails;
import com.datastack.thehealthcare.model.userView.ClinicDetailsDTO;
import com.datastack.thehealthcare.serviceImpl.userview.ClinicDetailsService;

@Controller
@RequestMapping("/clinic")
public class ClinicDetailsController {
@Autowired
ClinicDetailsService clinicDetailsService;
@PostMapping("/registerClinic")
public ResponseEntity<ClinicDetails> registerClinic(@RequestBody ClinicDetailsDTO clinicDetailsDTO){
	return new ResponseEntity<>(clinicDetailsService.registerClinic(clinicDetailsDTO), HttpStatus.OK);
}
}