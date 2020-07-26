package com.qienProgramma.rest;

import com.qienProgramma.controller.PhoneService;
import com.qienProgramma.model.Employee;
import com.qienProgramma.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phone")
public class PhoneEndpoint {

    @Autowired
    PhoneService ps;

    @PostMapping("/new")
    public Phone addPhone(@RequestBody Phone phone) {
        return ps.addPhone(phone);
    }

    @GetMapping("/all")
    public Iterable<Phone> getPhones(){
        return ps.getAllPhones();
    }

}
