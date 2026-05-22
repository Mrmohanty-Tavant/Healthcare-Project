package com.datastack.thehealthcare.ipd.dto;

import java.util.List;
import java.util.Map;

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
public class ResponseDto {
private List<DetailsData> operationList;
private List<DetailsData> occupation;
private List<DetailsData> department;
private List<DetailsData> category;
private Map<Long, List<DetailsData>> details;
}
