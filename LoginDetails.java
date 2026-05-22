package com.datastack.thehealthcare.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "login_details")
public class LoginDetails extends AuditModel{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="registered_user_id")
	private Long registerdUserId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="login_user_id")
	private String loginUserId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="login_type")
	private String loginType;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="otp")
	private String otp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "otp_expaire_time_min")
	@JsonProperty(value = "otp_expaire_time_min")
	private Date otpExpaireTimeInMin;
	
}
