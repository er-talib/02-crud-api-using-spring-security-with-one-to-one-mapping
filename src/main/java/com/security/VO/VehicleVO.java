package com.security.VO;

import com.security.CO.DriverCO;

import lombok.Data;

@Data
public class VehicleVO {
	
	private String vehicleType ;
	private String vehicleName ;
	private String vehicleCapacity;
	private String vehicleCompany;
	private String vehicleRegisterDate ;
	private DriverVO driverVO ;

}
