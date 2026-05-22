package com.datastack.thehealthcare.ledger.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datastack.thehealthcare.ledger.model.DoctorPayment;
import com.datastack.thehealthcare.ledger.model.Payment;
import com.datastack.thehealthcare.ledger.model.PaymentList;
import com.datastack.thehealthcare.ledger.model.Transaction;
import com.datastack.thehealthcare.model.OtpaymentInfoDto;

@Service
public interface DoctorLedgerService {
	 Boolean saveDoctorPayment(OtpaymentInfoDto paymentinfo);
	List<Transaction> doctorTransaction(Long id);
	List<PaymentList> doctorPendingPaymentList(Long clincId);
	Payment getDoctorPaymnet(Long clinicId);
	
	 Boolean doctorPayment(DoctorPayment doctorPayment);
	
}
