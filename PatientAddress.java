package com.datastack.thehealthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.datastack.thehealthcare.entity.patient.PatientDetails;

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
@Table(name = "patient_address")
public class PatientAddress extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "country_master_key")
	private String countryKey;
	
	@Column(name = "state_master_key")
	private String stateKey;
	
	@Column(name = "district_master_key")
	private String districtKey;
	
	@Column(name = "block_master_key")
	private String blockKey;
	
	@Column(name = "village_name")
	private String villageName;
	
	@Column(name = "agent_profile_id")
	private Long agentProfileId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_profile_id")
	private UserProfile userProfile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_profile_id")
	private PatientDetails patientDetails;
}
