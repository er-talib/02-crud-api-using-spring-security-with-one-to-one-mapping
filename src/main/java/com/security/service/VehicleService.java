package com.security.service;


import java.util.List;
import java.util.Optional;

import com.security.CO.VehicleCO;
import com.security.VO.VehicleVO;
import com.security.entity.Vehicle;
import com.security.response.VehicleResponse;

public interface VehicleService {
	
	public String addVehicleDetails(VehicleCO vehicleCO);
	public Vehicle updateVehicleDetails(VehicleCO  vehicleCO,int vehicleNo);
	public VehicleVO getVehicleDetailsByNo(int vehicleNo);
	public List<VehicleVO> getAllVehicleDetails();
	public VehicleResponse deleteVehicleDetails(int vehicleNo);

}
