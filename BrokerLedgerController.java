package com.datastack.thehealthcare.ledger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.ledger.model.BrokerPayment;
import com.datastack.thehealthcare.ledger.model.BrokerPendingPaymentList;
import com.datastack.thehealthcare.ledger.service.BrokerLedgerService;

@RestController
@RequestMapping("/brokerledger")
public class BrokerLedgerController {
	@Autowired
	BrokerLedgerService brokerLedgerService;
	
	@GetMapping("/brokerPaymentList")
	public ResponseEntity<List<BrokerPendingPaymentList>> brokerPaymentList(){
		return new ResponseEntity<>(brokerLedgerService.getBrokerPendingPayment(), HttpStatus.OK);
	}
	
	@PostMapping("/brokerPayment")
	public ResponseEntity<Boolean> brokerPayment(@RequestBody BrokerPayment brokerPayment){
		return new ResponseEntity<>(brokerLedgerService.brokerPayment(brokerPayment), HttpStatus.OK);
	}
}
