package com.example.CustomerManagementSystem.service;

import com.example.CustomerManagementSystem.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

   EmployeeDto createEmployee(EmployeeDto employeeDto);

   EmployeeDto findEmployee(Long id);

   List<EmployeeDto> getAllEmployees();

   EmployeeDto updateEmployee(Long id,EmployeeDto updateemployeeDto);

   void deleteEmployee(Long id);
}
