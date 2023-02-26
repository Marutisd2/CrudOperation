package com.feb.demo.controller;

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

import com.feb.demo.entity.Employee;
import com.feb.demo.service.implemantation.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/feb")
	public String name() {
		return "SUCESS";
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAllEmp() {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.ACCEPTED);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Employee>(employeeService.getById(id), HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> delEmployee(@PathVariable("id") Integer id) {
		employeeService.delEmloyee(id);
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
	}

	@DeleteMapping("/del")
	public ResponseEntity<String> delAllEmployee() {
		employeeService.delAllEmployee();
		return new ResponseEntity<String>("All Employee Deleted", HttpStatus.OK);
	}

	@PutMapping("/saveall")
	public ResponseEntity<List<Employee>> saveListEmployees(@RequestBody List<Employee> employees) {
		return new ResponseEntity<List<Employee>>(employeeService.saveListEmployees(employees), HttpStatus.CREATED);
	}
	
	
}
