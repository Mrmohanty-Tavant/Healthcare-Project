package com.datastack.thehealthcare.entity.master;

import java.io.Serializable;

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
@Table(name = "m_operation")
public class OperationMaster implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="department_master_key")
	private String department;
	@Column(name="operation_name")
	private String operationName;
	@Column(name = "language_id")
	private Long languageId;
	@Column(name = "master_key")
	private String masterKey;
	
	@Column(name = "bsky_package")
	private Double bskyPrice;
	
	@Column(name="cash_package")
	private Double cashPackage;
	
	@Column(name="ot_doctor_price")
	private Double otDoctorPrice;
	
	@Column(name="an_doctor_price")
	private Double anDoctorPrice;
	
	
}
