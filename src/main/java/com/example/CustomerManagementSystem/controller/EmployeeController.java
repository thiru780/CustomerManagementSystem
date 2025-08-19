package com.example.CustomerManagementSystem.controller;


import com.example.CustomerManagementSystem.dto.EmployeeDto;
import com.example.CustomerManagementSystem.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/employees/")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeServiceImpl employeeServiceImpl;


    //Build add Employee Rest API
    @PostMapping("addEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody  EmployeeDto employeeDto){

        EmployeeDto employee =employeeServiceImpl.createEmployee(employeeDto);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);

    }

    //Build Get EmployeeById Rest API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable Long id){
        EmployeeDto employeeDto =employeeServiceImpl.findEmployee(id);

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);

    }

    //Build GetAllEmployees Rest API
    @GetMapping("getAllEmployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){

        List<EmployeeDto> employees =employeeServiceImpl.getAllEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);

    }

    //Build Update Employees Rest API
    @PutMapping("updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto employeeDto){

        EmployeeDto employee =employeeServiceImpl.updateEmployee(employeeId,employeeDto);

        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    //Build Delete Employees Rest API
    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){

        employeeServiceImpl.deleteEmployee(employeeId);

        return ResponseEntity.ok("employee deleted successfully!");

    }

}
