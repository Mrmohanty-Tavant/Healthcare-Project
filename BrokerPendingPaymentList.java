package com.datastack.thehealthcare.ledger.model;

import java.util.Date;

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
public class BrokerPendingPaymentList {
private Long bookingId;
private Long	referaId;
private String	referredBy;
private String	patientName;
private String	operationName;
private Date admissionDate;
private Long  ledgerId;
}
