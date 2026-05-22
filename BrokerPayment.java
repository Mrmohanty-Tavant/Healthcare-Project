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
public class BrokerPayment {
private Long bookingId;
private Long ledgerId;
private Double paymentAmount;
private String comment;
private Long modeOfPayment;
}
