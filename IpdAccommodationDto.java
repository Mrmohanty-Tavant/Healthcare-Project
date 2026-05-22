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
public class IpdAccommodationDto {
	private Long id;
	private Long ipdBookingId;
	private Long accommodationCategoryId;
	private Long accommodationDetailsId;

}
