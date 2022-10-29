package com.security.repositoryes;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Serializable> {

}
