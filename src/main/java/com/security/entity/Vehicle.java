package com.security.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicalNo ;
	private String vehicleType ;
	private String vehicleName ;
	private String vehicleCapacity;
	private Date  vehicleRegisterDate ;
	private String vehicleCompany;
	@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
	@JsonBackReference
	@JoinColumn(name = "fk_driver")
	private Driver driver ;
	

}
