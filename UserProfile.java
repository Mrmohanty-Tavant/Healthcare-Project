package com.datastack.thehealthcare.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "user_profile")
public class UserProfile extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "mobile_number", unique = true)
	private Long mobileNumber;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "member_id")
	private String memberId;
	@Column(name = "occupation_master_key")
	private String profession;
	@Column(name = "relationship_master_key")
	private String relationshipKey;
	@Column(name = "parent_id")
	private Long parentId;
	@Column(name = "clinic_id")
	private Long clincId;
	@OneToMany(mappedBy = "userProfile")
	private List<UserAddress> address;

	

}
