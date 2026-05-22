package com.datastack.thehealthcare.entity.patient;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.datastack.thehealthcare.entity.PatientAddress;
import com.datastack.thehealthcare.entity.AuditModel;

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
@Table(name = "patient_details")
public class PatientDetails extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "patient_name")
	private String patientName;
	
	@Column(name = "mobile_number", unique = true)
	private Long mobileNumber;
	
	@Column(name = "gender_master_key")
	private String gender;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "age")
	private Long age;
	
	@Column(name = "father_husband_name")
	private String fatherName;
 
	@Column(name = "clinic_id")
	private Long clincId;
	
	@OneToMany(mappedBy = "patientDetails")
	private List<PatientAddress> address;
}
