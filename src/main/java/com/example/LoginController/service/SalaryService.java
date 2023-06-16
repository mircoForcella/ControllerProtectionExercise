package com.example.LoginController.service;

import com.example.LoginController.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    public String getAllSalary() {
        String allsalary = salaryRepository.findAll().toString();
        return allsalary;
    }

}
