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
public class IpdPaymentDetailsDto {
private Double bskyPackagePrice;
private Double bedCharges;
private Double operationCharges;
private Long bookingId ;
private Long operationCategoryId;
private String accoType;
private Double advanceAmount ;
private String comment;
private Long modeOfPayment;
private List<DetailsData> paymentCategory;
}
