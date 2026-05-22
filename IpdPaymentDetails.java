package com.datastack.thehealthcare.ipd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "ipd_payment_details")
public class IpdPaymentDetails extends AuditModel {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "bed_charges_per_day")
	private Double bedChargesPerDay;
	
	@Column(name = "operation_charges")
	private Double operationCharges;

	@Column(name = "operation_category_id")
	private Long operationCategoryId;
	
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@Column(name = "total_bill_amount")
	private Double totalBillAmount;
	
	@Column(name = "discount_amount")
	private Double discountAmount;
	
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "ipd_booking_id")
	 @JsonIgnoreProperties("ipdPayment")
	 private IpdBooking ipdBooking;
	
}
