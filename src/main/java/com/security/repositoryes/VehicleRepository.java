package com.security.repositoryes;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Serializable> {

}
