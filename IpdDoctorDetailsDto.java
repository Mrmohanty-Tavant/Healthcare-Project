package com.datastack.thehealthcare.ipd.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@ToString
public class IpdDoctorDetailsDto {
	
	private Long ipdBookingId;
	
	private Long doctorId;
	
	private Long anesthesiaId;
	
	private String otChamber;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date otScheduleTime;
	
}
