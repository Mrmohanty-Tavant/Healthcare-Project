package com.datastack.thehealthcare.ipd.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "ipd_booking")
public class IpdBooking extends AuditModel{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "clinic_id")
	private Long clinicId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "admission_date")
	private Date admissionDate;
	
	@Column(name = "patient_id")
	private Long patinetId;
	
	@Column(name = "operation_category_id")
	private Long operationCategoryId;
	
	@Column(name = "referal_category_id")
	private String referalCategoryId;
	
	@Column(name = "referal_id")
	private Long referalId;
	
	@Column(name = "department_id")
	private String departMentId;
	
	@Column(name = "operation_id")
	private String operationId;
	
	@Column(name = "discharge_date")
	private Date dischargeDate;
	
	@Column(name="discharge_status")
	private Boolean dishchargeStatus;
	
	
	@Column(name="accomodation_satus")
	private Boolean accomodationSatus;
	
	@Column(name="doctor_assign_satus")
	private Boolean doctorAssignStatus;
	
	@Column(name="doctor_payment_status")
	private Long doctorPaymentStatus;
	
	
	@Column(name="payment_status")
	private Boolean paymentStatus;
	
	@Column(name="operation_status")
	private Long operationStatus;
	
	@OneToMany(mappedBy = "ipd", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("ipd")
	private List<IpdAccommodation> accomodation;
	
	@OneToOne(mappedBy = "ipdBooking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("ipdBooking")
	private IpdDoctorDetails ipdDoctor;
	
	@OneToOne(mappedBy = "ipdBooking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("ipdBooking")
	private IpdPaymentDetails ipdPayment;


}
