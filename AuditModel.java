


package com.datastack.thehealthcare.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class AuditModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name="created_by")
	private Long createdBy ;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	@JsonProperty(value = "created_at")
	private Date createdAt;
	
	@Column(name="modified_by")
	private Long modifiedBy ;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at", nullable = false)
	@LastModifiedDate
	@JsonProperty(value = "modified_at")
	private Date modifiedAt;

	
}
