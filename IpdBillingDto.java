package com.datastack.thehealthcare.ipd.dto;

import java.util.List;

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
public class IpdBillingDto {
	private Long bookingId;
	private Double billingAmount;
	private Double paidAmount;
	private Double dueAmount;
	private Double discountAmount;
	private List<DetailsData> paymentCategory;
	private String bookingType;
}
