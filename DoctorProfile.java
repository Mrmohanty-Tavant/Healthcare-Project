package com.datastack.thehealthcare.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "doctor_profile")
public class DoctorProfile extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "doctor_name")
	private String doctorName;
	
	@Column(name = "image_link")
	private String imageLink;
	
	@JoinColumn(name = "department_id")
	private String departmentId;

	@Column(name = "qualification")
	private String qualification;

	@Column(name = "designation")
	private String designation;
	@Column(name = "registration_number")
	private String registrationNumber;
	@Column(name = "experience")
	private String experience;

	@Column(name = "language_knows")
	private String languageKnows;
	
	@Column(name = "currently_working_in")
	private String currentlyWorkingIn;

	@Column(name = "mobile_number")
	private Long mobileNumber;


	@Column(name = "address")
	private String address;


	@Column(name = "membership")
	private String membership;

	@Column(name = "insta_link")
	private String instaLink;
	
	@Column(name = "facebook_link")
	private String faceBookLink;
	
	@Column(name = "linkedin_link")
	private String linkedInkLink;
	
	@OneToMany(mappedBy = "doctorProfile", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<AboutDoctor> aboutDoctor;
	
	@OneToMany(mappedBy = "doctorProfile", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<DoctorVideos> doctorVideos;

}
