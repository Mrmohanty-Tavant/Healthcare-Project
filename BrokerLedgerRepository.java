package com.datastack.thehealthcare.ledger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ledger.entity.BrokerLedger;

@Repository
public interface BrokerLedgerRepository extends JpaRepository<BrokerLedger, Long>{
	int countByPaymentStatus(Boolean status);
	List<BrokerLedger> findByPaymentStatus(Boolean status);
}
