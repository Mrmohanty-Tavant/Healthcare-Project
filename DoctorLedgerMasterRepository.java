package com.datastack.thehealthcare.ledger.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ledger.entity.DoctorLedgerMaster;
@Repository
public interface DoctorLedgerMasterRepository extends JpaRepository<DoctorLedgerMaster, Long>{
DoctorLedgerMaster findByClinicIdAndDoctorId(Long clinincId, Long doctorid);

@Query("SELECT COALESCE(SUM(h.totalOperationCharges), 0.0) as totalPayment, COALESCE(SUM(h.totalPaymentReceive), 0.0) as paymentReceive FROM DoctorLedgerMaster h " +
        "WHERE h.clinicId = :clinicId")
Tuple findDoctorLedgerSumCreditAndDebit(@Param("clinicId") Long clinicId);
List<DoctorLedgerMaster> findByClinicId(Long id);
}
