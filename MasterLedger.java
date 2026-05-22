package com.datastack.thehealthcare.ledger.entity;

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
@Table(name = "m_master_ledger")
public class MasterLedger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="clinic_id")
	private Long clinicId;
	
	@Column(name = "ledger_name")
	private String ledgerName;
	
	@Column(name = "opening_balance")
	private Double openingBalance;
	
	@Column(name = "last_opening_balance")
	private Double lastOpeningBalance;
	
	@Column(name = "ledger_description")
	private String ledgerDescription;
	
}
