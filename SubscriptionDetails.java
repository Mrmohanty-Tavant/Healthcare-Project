package com.datastack.thehealthcare.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "subscription_details")
public class SubscriptionDetails extends AuditModel{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="message_subscription")
	private boolean messageSubscription;
	
	@Column(name="total_message")
	private Long totalMessage ;
	
	@Column(name="message_subscription_from")
	private Date messageSubscriptionFrom ;
	
	@Column(name="message_subscription_to")
	private Date messageSubscriptionTo ;
	
	@Column(name="whatsaap_subscription")
	private boolean whatsaapSubscription;
	
	@Column(name="whatsaap_subscription_from")
	private Date whatsaapSubscriptionFrom ;
	
	@Column(name="whatsaap_subscription_to")
	private Date whatsaapSubscriptionTo ;
	
	@Column(name="no_of_admin")
	private Long noOfAdmin ;
	
	@Column(name="no_of_users")
	private Long noOfUsers ;
	
}
