package com.feb.demo.service.implemantation;

import java.util.List;
import java.util.Optional;

import com.feb.demo.entity.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getById(Integer id);
	public Employee updateEmployee(Employee employee,Integer id);
	void delEmloyee(Integer id);
	public void delAllEmployee();
	public List<Employee> saveListEmployees(List<Employee> employees);
	
	
}
