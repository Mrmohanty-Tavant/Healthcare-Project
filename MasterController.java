package com.datastack.thehealthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.entity.master.CountryMaster;
import com.datastack.thehealthcare.ipd.dto.DetailsData;
import com.datastack.thehealthcare.model.HomeScreenMasterData;
import com.datastack.thehealthcare.model.HomeScreenPaymentData;
import com.datastack.thehealthcare.model.Master;
import com.datastack.thehealthcare.model.master.MasterDto;
import com.datastack.thehealthcare.serviceImpl.MasterDataService;
import com.datastack.thehealthcare.util.Common;

@RestController
@RequestMapping("/master")
public class MasterController {
@Autowired
private MasterDataService masterDataService;

@Autowired
private Common common;
	@GetMapping("/getMasterData/{lang}")
	public ResponseEntity<Master> getMasterData(@PathVariable String lang){
		return new ResponseEntity<>(masterDataService.prepareMasterData(lang), HttpStatus.OK);
	}
	
@GetMapping("/getOperation/{lang}/{departmentKey}")
public ResponseEntity<List<DetailsData>> getAllOperationList(@PathVariable Long lang, @PathVariable String departmentKey){
	return new ResponseEntity<>(masterDataService.getOperationList(lang, departmentKey), HttpStatus.OK);
}

@GetMapping("/getAllChild/{lang}/{parentKey}")
public ResponseEntity<List<CountryMaster>> getAllChild(@PathVariable Long lang,@PathVariable String parentKey){
	return new ResponseEntity<>(masterDataService.getAllChild(lang, parentKey), HttpStatus.OK);
}


@GetMapping("/getOccupation/{lang}")
public ResponseEntity<List<MasterDto>> getOccupation(@PathVariable Long lang){
	return new ResponseEntity<>(masterDataService.getAllOccupation(lang), HttpStatus.OK);
}

@GetMapping("/getDepartment/{lang}")
public ResponseEntity<List<MasterDto>> getDepartment(@PathVariable Long lang){
	return new ResponseEntity<>(masterDataService.getAllDepartment(lang), HttpStatus.OK);
}

@GetMapping("/getRefferedUser/{name}")
public ResponseEntity<List<DetailsData>> getDepartment(@PathVariable String name){
	return new ResponseEntity<>(masterDataService.getAllUserName(name), HttpStatus.OK);
}


@GetMapping("/getHomeScreenMasterData")
public ResponseEntity<HomeScreenMasterData> getMasterData(){
	return new ResponseEntity<>(masterDataService.getMasterData(), HttpStatus.OK);
}

@GetMapping("/getHomeScreenPaymentData")
public ResponseEntity<HomeScreenPaymentData> getPaymentData(){
	return new ResponseEntity<>(masterDataService.getPaymnetPendingData(), HttpStatus.OK);
}

@GetMapping("/getPaymentMode/{clinicId}")
public ResponseEntity<List<DetailsData>> getPaymentMode(@PathVariable Long clinicId){
	return new ResponseEntity<>(common.getPaymentCategory(clinicId), HttpStatus.OK);
}
}
