package com.site.billing.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="BILLING_DETAILS")
public class BillingEntity {
	
	@Id
	@SequenceGenerator(name="mysequence", initialValue=1000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mysequence")
	@Column(name="TRANSACTION_ID")
	public Integer id;
	
	@Column(name="TRANSACTION_DATE_TIME")
	public String date;
	
	@Column(name="TRANSACTION_TYPE")
	public String type;
	
	@Column(name="PRODUCT")
	public String product;
	
	@Column(name="PRICE")
	public double price;
	
	@Column(name="VEHICLE_NUMBER")
	public String vehicleNo;
	
	@Column(name="QUANTITY")
	public double quantity;
	
	@Column(name="AMOUNT")
	public String amount;



}
