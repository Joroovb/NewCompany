package com.qienProgramma.controller;

import com.qienProgramma.model.Messages;
import com.qienProgramma.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import com.qienProgramma.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	 @Autowired
	    EmployeeRepository er;

	 @Autowired
	 PhoneRepository pr;

	    public Employee getById(long id) {
	        return er.findById(id).get();
	    }

	    public void inDeService() {
	        er.save(new Employee());
	        System.out.println("We zijn in de service ");
	    }

	    public Employee addEmployee(Employee employee){
	        System.out.println("In employee Service");
	        return er.save(employee);
	    }

	    public Iterable<Employee> getAllEmployees(){
	        System.out.println("getAllDepartments aangeroepen");
	        return er.findAll();
	    }

	    public void deleteEmployeeById(long id) {
	        System.out.println("DELETE IN SERVICE");
	        er.deleteById(id);
	    }

	    public Employee addMessageToEmployee(Employee employee, Messages message) {
	    	employee.addMessage(message);
	    	return er.save(employee);
		}

		public Employee changeSalary(Employee employee, Employee employeeUpdate) {
	    	employee.setSalary(employeeUpdate.getSalary());
	    	return er.save(employee);
		}

	public Employee addPhoneToEmployee(long empid, long phoneid) {
	    	Employee emp = er.findById(empid).get();
	    	Phone phone = pr.findById(phoneid).get();
	    	Iterable<Employee> empList = er.findAll();
	    	for (Employee emps : empList) {
	    		if (emps.getPhone() != null) {
					if (emps.getPhone().getId() == phoneid) {
						emps.addPhone(null);
					}
				}
			}
			emp.addPhone(phone);
	    	return er.save(emp);
	}
}
