package com.datastack.thehealthcare.entity;

import java.sql.Date;

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
@Table(name = "doctor_schedule")
public class DoctorSchedule extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "appointment_date")
	private Date appointmentDate;
	
	@Column(name = "appointment_time")
	private Long appointmentTime;
	
	@Column(name = "time_referance")
	private String timeReferance;
	
	@Column(name = "doctor_clinic_mapping_id")
	private Long doctorClinicMapping;
}
