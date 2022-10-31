package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.CO.VehicleCO;
import com.security.VO.VehicleVO;
import com.security.entity.Vehicle;
import com.security.response.VehicleResponse;
import com.security.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService ;
	
	@PostMapping("/detailsAdd")
	public ResponseEntity<?> addVehicleDetails(@RequestBody VehicleCO vehicleCO){
		String message = this.vehicleService.addVehicleDetails(vehicleCO);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	@PutMapping("/detailsUpdate/{vehicleNo}")
	public ResponseEntity<?> updateVehicleDetails(@RequestBody VehicleCO vehicleCO ,@PathVariable int vehicleNo){
		Vehicle vehicleDetails = this.vehicleService.updateVehicleDetails(vehicleCO, vehicleNo);
		return ResponseEntity.ok(vehicleDetails);
	}
	@GetMapping("/detailsGet/{vehicleNo}")
	public ResponseEntity<?> getVehicleDetails(@PathVariable int vehicleNo){
		VehicleVO vehicleDetailsByNo = this.vehicleService.getVehicleDetailsByNo(vehicleNo);
		return ResponseEntity.ok(vehicleDetailsByNo);
	}
	@GetMapping("/allDetailsGet")
    public ResponseEntity<?> getAllVehicleDetails(){
    	List<VehicleVO> allVehicleDetails = this.vehicleService.getAllVehicleDetails();
    	return ResponseEntity.ok(allVehicleDetails);
    }
	@DeleteMapping("/detailsDelete/{vehicleNo}")
	public ResponseEntity<?> deleteVehicleDetailByNumber(@PathVariable int vehicleNo){
		VehicleResponse deletedVehicleDetails = this.vehicleService.deleteVehicleDetails(vehicleNo);
		return ResponseEntity.ok(deletedVehicleDetails);
	}
}
