package com.qienProgramma.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String naam;
    private int aantalMedewerkers;

    @OneToMany
    @JoinColumn(name="employee_id")
    private List<Employee> employees = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAantalMedewerkers() {
        return aantalMedewerkers;
    }

    public void setAantalMedewerkers(int aantalMedewerkers) {
        this.aantalMedewerkers = aantalMedewerkers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployeeToArray(Employee emp){
        employees.add(emp);
    }

}
