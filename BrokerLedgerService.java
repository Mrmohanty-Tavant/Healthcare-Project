package com.datastack.thehealthcare.ledger.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datastack.thehealthcare.ledger.model.BrokerPayment;
import com.datastack.thehealthcare.ledger.model.BrokerPendingPaymentList;

@Service
public interface BrokerLedgerService {
List<BrokerPendingPaymentList> getBrokerPendingPayment();

Boolean brokerPayment(BrokerPayment brokerPayment);
}
