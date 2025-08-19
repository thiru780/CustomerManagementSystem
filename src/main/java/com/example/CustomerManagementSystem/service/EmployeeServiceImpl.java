package com.example.CustomerManagementSystem.service;

import com.example.CustomerManagementSystem.dto.EmployeeDto;
import com.example.CustomerManagementSystem.entity.Employee;
import com.example.CustomerManagementSystem.exception.ResourceNotFoundException;
import com.example.CustomerManagementSystem.mapper.EmployeeMapper;
import com.example.CustomerManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto findEmployee(Long id) {

        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not exits with given id :"+id));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

       List<Employee>  employees =employeeRepository.findAll();

        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updateemployeeDto) {
        Employee employee =employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not exits with given id :"+id));

        employee=EmployeeMapper.mapToEmployee(updateemployeeDto);
        Employee updateEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee =employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not exits with given id :"+id));

        employeeRepository.delete(employee);
    }
}
