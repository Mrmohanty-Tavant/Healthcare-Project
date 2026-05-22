package com.datastack.thehealthcare.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "clinic_details")
public class ClinicDetails extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "clinic_name")
	private String clinicName;

	@Column(name = "country_master_key")
	private String countryKey;
	
	@Column(name = "state_master_key")
	private String stateKey;
	
	@Column(name = "district_master_key")
	private String districtKey;
	
	@Column(name = "block_master_key")
	private String blockKey;

	@Column(name = "contact_number_primary")
	private Long contactNumberPrimary;

	@Column(name = "contact_number_secondary")
	private Long contactNumberSecondary;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "address")
	private String address;
	
	@Column(name = "category")
	private String catagory;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscription_details_id", referencedColumnName = "id")
	private SubscriptionDetails subscriptionDetails;
}
