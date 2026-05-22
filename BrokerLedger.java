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
@Table(name = "broker_ledger")
public class BrokerLedger extends AuditModel{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "brokker_id")
	private Long brokkerId;
	
	@Column(name = "booking_id")
	private Long bookingId;
	
	@Column(name = "referal_amount")
	private Double referralAmount;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name="payment_status")
	private Boolean paymentStatus;
	
	
	@Column(name="mode_of_payment")
	private Long modeOfPayment;
	
	@Column(name="finance_year")
	private Long financeYear;
	
	@Column(name="comment")
	private String comment;
	
}
