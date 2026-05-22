package com.datastack.thehealthcare.ledger.controller;

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

import com.datastack.thehealthcare.ledger.model.DoctorPayment;
import com.datastack.thehealthcare.ledger.model.Payment;
import com.datastack.thehealthcare.ledger.model.PaymentList;
import com.datastack.thehealthcare.ledger.model.Transaction;
import com.datastack.thehealthcare.ledger.service.DoctorLedgerService;
import com.datastack.thehealthcare.model.OtpaymentInfoDto;

@RestController
@RequestMapping("/doctorledger")
public class DoctorLedgerController {
@Autowired
DoctorLedgerService doctorLedgerService;
	@PostMapping("/ledgerEntry")
	public ResponseEntity<Boolean> ledgerEntry(@RequestBody OtpaymentInfoDto otpaymentInfoDto){
		return new ResponseEntity<>(doctorLedgerService.saveDoctorPayment(otpaymentInfoDto), HttpStatus.OK);
	}
	
	@GetMapping("/pendingPayment/{clinicId}")
	public ResponseEntity<List<Transaction>> todayTransaction(@PathVariable Long clinicId){
		return new ResponseEntity<>(doctorLedgerService.doctorTransaction(clinicId), HttpStatus.OK);
	}
	@GetMapping("/pendingPaymentList/{clinicId}")
	public ResponseEntity<List<PaymentList>> doctorPendingPaymentList(@PathVariable Long clinicId){
		return new ResponseEntity<>(doctorLedgerService.doctorPendingPaymentList(clinicId), HttpStatus.OK);
	}
	@GetMapping("/doctorsList/{clinicId}")
	public ResponseEntity<Payment> getDoctors(@PathVariable Long clinicId){
		return new ResponseEntity<>(doctorLedgerService.getDoctorPaymnet(clinicId), HttpStatus.OK);
	}
	
	@PostMapping("/doctorPayment")
	public ResponseEntity<Boolean> doctorPayment(@RequestBody DoctorPayment doctorPayment){
		return new ResponseEntity<>(doctorLedgerService.doctorPayment(doctorPayment), HttpStatus.OK);
	}
}
