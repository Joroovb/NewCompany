package com.qienProgramma.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long phoneNumber;

    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL, orphanRemoval = true)
    private Employee employee;

    public long getId() {
        return id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
