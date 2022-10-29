package com.security.CO;

import com.security.entity.Driver;

import lombok.Data;

@Data
public class VehicleCO {
	
	private String vehicleType ;
	private String vehicleName ;
	private String vehicleCapacity;
	private String vehicleCompany;
	private DriverCO driverCO ;


}
