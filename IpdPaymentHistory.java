package com.datastack.thehealthcare.ipd.entity;

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
@Table(name = "ipd_payment_history")
public class IpdPaymentHistory  extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "payment_amount")
	private Double paymentAmount;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name="mode_of_payment")
	private Long modeOfPayment;
	
	@Column(name="expenditure_category_id")
	private Long incomeCategory;
	
	@Column(name = "ipd_booking_id")
	private Long ipdBookingId;
}
