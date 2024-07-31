package com.godigi.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.godigi.api.dto.EmployeeDto;
import com.godigi.api.entity.Employee;
import com.godigi.api.exception.ResourceNotFoundException;
import com.godigi.api.mapper.EmployeeMapper;
import com.godigi.api.repository.EmployeeRepository;
import com.godigi.api.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
		.orElseThrow(() ->
		new ResourceNotFoundException("Employee doesn't Exist with ID: " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
			() -> new ResourceNotFoundException("Employee Doesn't Exists with ID : " + employeeId)	
		);
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
		
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee Doesn't Exists with ID : " + employeeId)	
			);
		employeeRepository.deleteById(employeeId);
		
	}

}
