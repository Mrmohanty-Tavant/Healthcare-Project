package com.datastack.thehealthcare.ipd.dto;

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
public class IpdBillPaymentDto {
	private Long bookingId;
	private Double paidAmount;
	private Double discountAmount;
	private Double totalbillAmount;
	private Long modeOfPayment;
	private String comment;
	private String transactionType;
}
