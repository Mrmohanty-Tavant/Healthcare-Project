package com.datastack.thehealthcare.ipd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ipd.entity.IpdPaymentHistory;
@Repository
public interface IpdPaymentHistoryRepository extends JpaRepository<IpdPaymentHistory, Long> {
    @Query("SELECT SUM(e.paymentAmount) FROM IpdPaymentHistory e WHERE e.ipdBookingId = :ipdBookingId")
    Double sumValuePaymentAmountByIpdBookingId(@Param("ipdBookingId") Long ipdBookingId);
}
