package com.feb.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.demo.entity.Employee;
import com.feb.demo.exceptions.ResourceNotFoundException;
import com.feb.demo.repository.EmployeeRepository;
import com.feb.demo.service.implemantation.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getById(Integer id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			throw new ResourceNotFoundException("Employee", "ID", emp);
		}

		// return employeeRepository.findById(id).orElseThrow(()->new
		// ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {

		Employee existEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employe", "id", id));

		existEmployee.setFname(employee.getFname());
		existEmployee.setLname(employee.getLname());
		existEmployee.setEmail(employee.getEmail());
		return employeeRepository.save(existEmployee);
	}

	@Override
	public void delEmloyee(Integer id) {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

	@Override
	public void delAllEmployee() {
		employeeRepository.deleteAll();
	}

	@Override
	public List<Employee> saveListEmployees(List<Employee> employees) {		
		return employeeRepository.saveAll(employees);
	}

}
