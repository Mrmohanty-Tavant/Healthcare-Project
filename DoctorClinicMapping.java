package com.datastack.thehealthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "doctor_clinic_mapping")
public class DoctorClinicMapping extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "doctor_profile_id")
	private Long doctorProfileId;

	@Column(name = "clinic_id")
	private Long clinicId;
	
	@Column(name = "country_master_key")
	private String countryKey;
	
	@Column(name = "state_master_key")
	private String stateKey;
	
	@Column(name = "district_master_key")
	private String districtKey;
	
	@Column(name = "block_master_key")
	private String blockKey;
	
	@Column(name = "department_master_key")
	private String departmentId;
	
}
