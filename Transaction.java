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
public class Transaction {
private String ledgerName;
private Double totalCredit;
private Double totalDebit;
private Double closeAmount;
}
