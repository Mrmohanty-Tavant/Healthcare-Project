package com.datastack.thehealthcare.ledger.entity;
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
@Table(name = "doctor_ledger_master")
public class DoctorLedgerMaster  extends AuditModel{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "clinic_id")
	private Long clinicId;
	
	@Column(name = "doctor_id")
	private Long doctorId;
	
	@Column(name = "total_operation_charges")
	private Double totalOperationCharges;
	
	@Column(name = "total_payment_receive")
	private Double totalPaymentReceive;
	
	@Column(name = "total_payment_due")
	private Double totalPeymentDue ;


	
	
}
