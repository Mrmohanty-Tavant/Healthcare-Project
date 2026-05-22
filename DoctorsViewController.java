package com.datastack.thehealthcare.controller.frontView;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.model.frontview.DoctorsListDTO;
import com.datastack.thehealthcare.model.frontview.DoctorsviewRequest;
import com.datastack.thehealthcare.serviceImpl.frontview.DoctorsListService;

@RestController
@RequestMapping("/frontView")
public class DoctorsViewController {
@Autowired
DoctorsListService doctorsListService;
@GetMapping("/doctorsview")
	public ResponseEntity<Set<DoctorsListDTO>> getfilterredDoctor(@RequestBody DoctorsviewRequest doctorView){
		
		return new ResponseEntity<>(doctorsListService.getfilteredDoctorList(doctorView), HttpStatus.OK);
	}
}
