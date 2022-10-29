package com.security.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.CO.DriverCO;
import com.security.CO.VehicleCO;
import com.security.VO.DriverVO;
import com.security.VO.VehicleVO;
import com.security.entity.Driver;
import com.security.entity.Vehicle;
import com.security.repositoryes.VehicleRepository;
import com.security.response.VehicleResponse;
import com.security.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public String addVehicleDetails(VehicleCO vehicleCO) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleCapacity(vehicleCO.getVehicleCapacity());
		vehicle.setVehicleCompany(vehicleCO.getVehicleCompany());
		vehicle.setVehicleName(vehicleCO.getVehicleName());
		vehicle.setVehicleType(vehicleCO.getVehicleType());
		vehicle.setVehicleRegisterDate(new Date());
		Driver driver = new Driver();
		driver.setDriverAddress(vehicleCO.getDriverCO().getDriverAddress());
		driver.setDriverName(vehicleCO.getDriverCO().getDriverName());
		driver.setEmail(vehicleCO.getDriverCO().getEmail());
		driver.setJoinedDate(new Date());
		driver.setSalary(vehicleCO.getDriverCO().getSalary());
		driver.setVehicle(vehicle);
		vehicle.setDriver(driver);

		this.vehicleRepository.save(vehicle);
		return "Vehicle details has been saved successfully";
	}

	@Override
	public Vehicle updateVehicleDetails(VehicleCO vehicleCO, int vehicleNo) {

		Optional<Vehicle> vehicleDetails = this.vehicleRepository.findById(vehicleNo);
		Vehicle vehicle2 = vehicleDetails.get();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicalNo(vehicleNo);
		vehicle.setVehicleCapacity(vehicleCO.getVehicleCapacity());
		vehicle.setVehicleCompany(vehicleCO.getVehicleCompany());
		vehicle.setVehicleName(vehicleCO.getVehicleName());
		vehicle.setVehicleType(vehicleCO.getVehicleType());
		vehicle.setVehicleRegisterDate(new Date());
		Driver driver = new Driver();
		driver.setDriverId(vehicle2.getDriver().getDriverId());
		driver.setDriverAddress(vehicleCO.getDriverCO().getDriverAddress());
		driver.setDriverName(vehicleCO.getDriverCO().getDriverName());
		driver.setEmail(vehicleCO.getDriverCO().getEmail());
		driver.setJoinedDate(new Date());
		driver.setSalary(vehicleCO.getDriverCO().getSalary());
		driver.setVehicle(vehicle);
		vehicle.setDriver(driver);

		Vehicle vehicleResponse = this.vehicleRepository.save(vehicle);
		return vehicleResponse;
	}

	@Override
	public VehicleVO getVehicleDetailsByNo(int vehicleNo) {

		Optional<Vehicle> vehicleDetails = this.vehicleRepository.findById(vehicleNo);
		Vehicle vehicle = vehicleDetails.get();

		VehicleVO vehicleVO = new VehicleVO();
		vehicleVO.setVehicleCapacity(vehicle.getVehicleCapacity());
		vehicleVO.setVehicleCompany(vehicle.getVehicleCompany());
		vehicleVO.setVehicleName(vehicle.getVehicleName());
		vehicleVO.setVehicleRegisterDate(vehicle.getVehicleRegisterDate().toString());
		vehicleVO.setVehicleType(vehicle.getVehicleType());

		DriverVO driverVO = new DriverVO();
		driverVO.setDriverAddress(vehicle.getDriver().getDriverAddress());
		driverVO.setDriverName(vehicle.getDriver().getDriverName());
		driverVO.setEmail(vehicle.getDriver().getEmail());
		driverVO.setSalary(vehicle.getDriver().getSalary());
		driverVO.setJoinedDate(vehicle.getDriver().getJoinedDate().toString());

		vehicleVO.setDriverVO(driverVO);

		return vehicleVO;
	}

	@Override
	public List<VehicleVO> getAllVehicleDetails() {

		List<Vehicle> findAllVehicle = this.vehicleRepository.findAll();

		List<VehicleVO> vehicleDetails = findAllVehicle.stream().map(vehicle -> {
			VehicleVO vehicleVO = new VehicleVO();
			vehicleVO.setVehicleCapacity(vehicle.getVehicleCapacity());
			vehicleVO.setVehicleCompany(vehicle.getVehicleCompany());
			vehicleVO.setVehicleName(vehicle.getVehicleName());
			vehicleVO.setVehicleRegisterDate(vehicle.getVehicleRegisterDate().toString());
			vehicleVO.setVehicleType(vehicle.getVehicleType());

			DriverVO driverVO = new DriverVO();
			driverVO.setDriverAddress(vehicle.getDriver().getDriverAddress());
			driverVO.setDriverName(vehicle.getDriver().getDriverName());
			driverVO.setEmail(vehicle.getDriver().getEmail());
			driverVO.setSalary(vehicle.getDriver().getSalary());
			driverVO.setJoinedDate(vehicle.getDriver().getJoinedDate().toString());
			vehicleVO.setDriverVO(driverVO);
			return vehicleVO;
		}).collect(Collectors.toList());

		return vehicleDetails;
	}

	@Override
	public VehicleResponse deleteVehicleDetails(int vehicleNo) {

		this.vehicleRepository.deleteById(vehicleNo);
		VehicleResponse vehicleResponse = new VehicleResponse();
		vehicleResponse.setMessage("Vehicle details has been deleted successfully..!!");
		vehicleResponse.setStatus("Success");
		vehicleResponse.setDate(new Date().toString());

		return vehicleResponse;
	}

}
