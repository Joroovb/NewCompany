package com.qienProgramma.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qienProgramma.model.Employee;

@RestController
public class RinseEndpoint {
    
	@GetMapping("/test")
	public String go() {
		System.out.println("hij doet het");
		return "Dit komt van de backend";
	}
	
	@GetMapping("/test2")
	public Employee go2() {
		System.out.println("hij doet het 2");
		Employee p = new Employee();
		p.setName("Henkie2");
		return p;
	}
	
	@PostMapping("/test3")
	public void go3(@RequestBody Employee employee) {
		System.out.println("hij doet het in de post" + employee.getName());
	}
}

