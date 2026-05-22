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
public class PaymentList {
private Long id;
private String name;
private Double total;
private Double paid;
private Double due;

}
