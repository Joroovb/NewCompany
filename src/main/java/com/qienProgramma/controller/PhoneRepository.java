package com.qienProgramma.controller;

import com.qienProgramma.model.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
