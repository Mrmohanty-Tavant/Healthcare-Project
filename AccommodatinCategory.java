package com.datastack.thehealthcare.ipd.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "accommodation_category")
public class AccommodatinCategory implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="type_of_accommodation")
	private String typeOfAccommodation;
	
	@Column(name = "clinic_id")
	private Long clinicId;
	
	@Column(name="master_key")
	private String masterKey;
	
	@OneToMany(mappedBy = "accommodationCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("accommodationCategory") // Ignore this property during serialization
	private List<AccommodatinDetails> accommodatinDetails;
}
