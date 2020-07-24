package com.qienProgramma.rest;

import com.qienProgramma.controller.DepartmentService;
import com.qienProgramma.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentEndpoint {

    @Autowired
    DepartmentService ds;

    @PostMapping("/new")
    public Department addDepartment(@RequestBody Department department) {
    	System.out.println("Department added");
        return ds.addDepartment(department);
    }

    @GetMapping("/all")
    public Iterable<Department> getDepartments(){
        return ds.getAllDepartments();
    }

    @GetMapping("/id/{id}")
    public Department getDepartmentByID(@PathVariable(value = "id") long id){
        return ds.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartmentById(@PathVariable(value = "id") long id) {
        ds.deleteDepartmentById(id);
    }

    @PutMapping("/update/{id}")
    public  Department updateDepartment(@PathVariable(value = "id") long id, @RequestBody Department department) {
        return ds.updateDepartment(id, department);
    }

    @PostMapping("/dopost")
    public String doPost(@RequestBody Department dp) {
        System.out.println(dp.getNaam() + dp.getAantalMedewerkers());
        return "Post is gelukt";
    }

    @GetMapping("/checkdeservice")
    public String checkDeService() {
        System.out.println("Het werkt");
        ds.inDeService();
        return "Reply: Check de Service";
    }

    @GetMapping("/abc")
    public Department jojojo(){
        return new Department();
    }

    @PutMapping("/addemployee/{departmentid}/{employeeid}")
    public Department addEmployeeToDepartment(@PathVariable(value = "departmentid") long departmentid, @PathVariable(value = "employeeid") long employeeid) {
        return ds.addEmployee(departmentid, employeeid);
    }

}
