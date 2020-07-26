package com.qienProgramma.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qienProgramma.controller.EmployeeService;
import com.qienProgramma.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeEndpoint {
	 @Autowired
	    EmployeeService es;


	    @PostMapping("/new")
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return es.addEmployee(employee);
	    }

	    @GetMapping("/all")
	    public Iterable<Employee> getEmployees(){
	        return es.getAllEmployees();
	    }

	    @GetMapping("/id/{id}")
	    public Employee getEmployeeByID(@PathVariable(value = "id") long id){
	        return es.getById(id);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteEmployeeById(@PathVariable(value = "id") long id) {
	        es.deleteEmployeeById(id);
	    }

	    @PutMapping("/changesalary/{id}")
		public void changeSalaryById(@PathVariable(value = "id") long id, @RequestBody Employee employee) {
	    	es.changeSalary(es.getById(id), employee);
		}

		@PutMapping("/addphone/{id}/{phoneid}")
		public void addPhonetoEmployee(@PathVariable(value = "id") long id, @PathVariable(value = "phoneid") long phoneid) {
	    	es.addPhoneToEmployee(id, phoneid);
		}
}
