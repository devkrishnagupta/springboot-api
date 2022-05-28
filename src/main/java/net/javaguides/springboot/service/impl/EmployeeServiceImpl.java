package net.javaguides.springboot.service.impl;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRespository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRespository) {
		super();
		this.employeeRespository = employeeRespository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRespository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRespository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = employeeRespository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "id", id);
//		}
		
		return employeeRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		
		//we need to check whether employee id exists in database or  not.
		Employee existingEmployee = employeeRespository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "id", id)
		);
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRespository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRespository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "id", id)
		);
		employeeRespository.deleteById(id);
	}
	
}
