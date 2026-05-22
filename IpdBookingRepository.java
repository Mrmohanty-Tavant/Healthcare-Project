package com.datastack.thehealthcare.ipd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ipd.entity.IpdBooking;

@Repository
public interface IpdBookingRepository extends JpaRepository<IpdBooking, Long> {
	int countByDishchargeStatus(boolean status);
	int countByOperationStatusAndDishchargeStatus(Long id, Boolean status);
	int countByDoctorAssignStatus(boolean status);
	List<IpdBooking> findByDishchargeStatus(Boolean status);
	List<IpdBooking> findByDoctorAssignStatus(Boolean status);
	List<IpdBooking> findByOperationStatusAndDishchargeStatus(Long id, Boolean status);
	
	int countByDoctorPaymentStatus(Long id);
	List<IpdBooking> findByDoctorPaymentStatus(Long id);
	
	
}
