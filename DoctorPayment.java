package com.datastack.thehealthcare.ledger.model;

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
public class DoctorPayment {
private Long doctorId;
private Long clinincId;
private Double paymentAmount;
private Long paymnetCategoryId;
}
