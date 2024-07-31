package com.godigi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godigi.api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	 
}
