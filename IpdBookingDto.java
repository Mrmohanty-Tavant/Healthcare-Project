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
public class IpdBookingDto {
	private Long id;
	private Long clinicId;
	private Long patinetId;
	private Long operationCategoryId;
	private String referalCategoryId;
	private Long referalId;
	private String departMentId;
	private String operationId;
	
}
