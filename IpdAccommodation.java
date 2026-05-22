package com.datastack.thehealthcare.ipd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.datastack.thehealthcare.entity.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Entity
@ToString
@Table(name = "ipd_accomodation")
public class IpdAccommodation extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "accommodation_category_id")
	private Long accommodationCategoryId;
	
	@Column(name = "accommodation_details_id")
	private Long accommodationDetailsId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ipd_booking_id")
	@JsonIgnoreProperties("accomodation")
	private IpdBooking ipd;
	
}
