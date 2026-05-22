package com.datastack.thehealthcare.ledger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.ledger.model.Transaction;
import com.datastack.thehealthcare.ledger.service.HospitalLedgerService;

@RestController
@RequestMapping("/hospitalLedger")
public class HospitalLedgerController {
	@Autowired
	HospitalLedgerService hospitalLedgerService;
	@GetMapping("/todayTransaction/{clinicId}")
	public ResponseEntity<List<Transaction>> todayTransaction(@PathVariable Long clinicId){
		return new ResponseEntity<>(hospitalLedgerService.todayTransaction(clinicId), HttpStatus.OK);
	}
}
