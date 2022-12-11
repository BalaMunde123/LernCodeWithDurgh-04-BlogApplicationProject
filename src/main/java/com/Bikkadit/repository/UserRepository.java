package com.Bikkadit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bikkadit.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
}
