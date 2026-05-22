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
@Table(name = "hospital_ledger")
public class HospitalLedger extends AuditModel {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="master_ledger_id")
	private Long masterLedgerId;
	
	@Column(name = "credit")
	private Double credit;
	
	@Column(name = "debit")
	private Double debit;
	
	
	@Column(name = "description")
	private String description;

	@Column(name = "payment_source")
	private String paymentSource;
	
	@Column(name = "transaction_to")
	private String transactionTo;
	
	@Column(name="finance_year")
	private Long financeYear;
}
