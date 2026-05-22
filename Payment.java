package com.datastack.thehealthcare.ledger.model;

import java.util.List;

import com.datastack.thehealthcare.ipd.dto.DetailsData;

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
public class Payment {
	private List<DetailsData> doctors;
	private List<DetailsData> paymentCategory;
}
