package com.datastack.thehealthcare.ledger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ledger.entity.DoctorLedger;
@Repository
public interface DoctorLedgerRepository extends JpaRepository<DoctorLedger,Long>{

}
