package com.datastack.thehealthcare.ledger.model;

import java.util.Date;

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
public class DoctorLedgerDto {
private Long id;
	private Long clinicId;
	private Long doctorId;
	private Long bookingId;
	private Long plannedIpdCharge;
	private Long ipdCharge;
	private Long paymentReceive;
	private String comment;
	private Date paymentDate;
	private String modeOfPayment;
}
