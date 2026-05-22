package com.datastack.thehealthcare.ledger.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "doctor_ledger")
public class DoctorLedger extends AuditModel{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "doctor_ledger_master_id")
	private Long doctorLedgerMasterId;
	
	@Column(name = "booking_id")
	private Long bookingId;
	
	@Column(name = "planned_ipd_charge")
	private Double plannedIpdCharge;
	
	@Column(name = "ipd_charge")
	private Double ipdCharge;
	
	@Column(name = "payment_receive")
	private Double paymentReceive;

	@Column(name="comment")
	private String comment;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	
	@Column(name="mode_of_payment")
	private Long modeOfPayment;
	
	@Column(name="finance_year")
	private Long financeYear;
	
	
}
