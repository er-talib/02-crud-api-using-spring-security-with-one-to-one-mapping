package com.security.repositoryes;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

	public User findByUsername(String username);
}
