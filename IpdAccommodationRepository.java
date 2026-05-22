package com.datastack.thehealthcare.ipd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ipd.entity.IpdAccommodation;

@Repository
public interface IpdAccommodationRepository extends JpaRepository<IpdAccommodation, Long> {

	IpdAccommodation findByIpd(Long id);
	
}
