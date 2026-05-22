package com.datastack.thehealthcare.ipd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datastack.thehealthcare.ipd.entity.IpdDoctorDetails;

@Repository
public interface IpdDoctorDetailsRepository  extends JpaRepository<IpdDoctorDetails, Long>{

}
