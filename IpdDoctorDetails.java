package com.datastack.thehealthcare.ipd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.datastack.thehealthcare.entity.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "ipd_doctor_details")
public class IpdDoctorDetails extends AuditModel {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "doctor_id")
	private Long dotorId;
	
	@Column(name = "anesthesia_id")
	private Long anesthesiaId;
	
	@Column(name="ot_schedule_by")
	private Long otScheduleBy ;
	
	@Column(name = "ot_chamber")
	private String otChamber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operation_schedule_time")
	private Date operationScheduleTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operation_start_time")
	private Date operationStartTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operation_end_time")
	private Date operationEndTime;
	
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "ipd_booking_id")
	 @JsonIgnoreProperties("ipdDoctor")
	 private IpdBooking ipdBooking;
	
	
}
