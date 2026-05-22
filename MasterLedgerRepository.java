package com.datastack.thehealthcare.ledger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ledger.entity.MasterLedger;
@Repository
public interface MasterLedgerRepository extends JpaRepository<MasterLedger, Long>{
	
	
	
List<MasterLedger> findByClinicId(Long id);
}
