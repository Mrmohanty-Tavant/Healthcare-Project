package com.datastack.thehealthcare.ledger.repository;

import java.util.Date;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ledger.entity.HospitalLedger;

@Repository
public interface HospitalLedgerRepository  extends JpaRepository<HospitalLedger, Long>{
	@Query("SELECT COALESCE(SUM(h.credit), 0.0) as creditSum, COALESCE(SUM(h.debit), 0.0) as debitSum FROM HospitalLedger h " +
	           "WHERE h.masterLedgerId = :masterLedgerId AND h.paymentSource=:paymentSource AND h.createdAt >= :startDate AND h.createdAt < :endDate")
	Tuple findSumCreditAndDebit(@Param("masterLedgerId") Long masterLedgerId,
	    		                       @Param("paymentSource") String paymentSource,
	                                   @Param("startDate") Date startDate,
	                                   @Param("endDate") Date endDate);
	
	@Query("SELECT COALESCE(SUM(h.credit), 0.0) as creditSum, COALESCE(SUM(h.debit), 0.0) as debitSum FROM HospitalLedger h " +
	           "WHERE h.masterLedgerId = :masterLedgerId AND h.createdAt >= :startDate AND h.createdAt < :endDate")
	Tuple findAllSumCreditAndDebit(@Param("masterLedgerId") Long masterLedgerId,
	                                   @Param("startDate") Date startDate,
	                                   @Param("endDate") Date endDate);
}
