package com.qienProgramma.controller;

import com.qienProgramma.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PhoneService {

    @Autowired
    PhoneRepository pr;

    public Phone addPhone(Phone phone) {
        return pr.save(phone);
    }

    public Iterable<Phone> getAllPhones() {
        return pr.findAll();
    }
}
