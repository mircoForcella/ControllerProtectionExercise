package com.example.LoginController.controller;

import com.example.LoginController.entity.Salary;
import com.example.LoginController.entity.UserEntity;
import com.example.LoginController.repository.SalaryRepository;
import com.example.LoginController.repository.UserRepository;
import com.example.LoginController.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    SalaryRepository salaryRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String helloController() {
        return "hello";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/helloadmin")
    public String helloAdmin() {
        return "hello admin";
    }

    @GetMapping("/adminfinduser/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserEntity findUser(@PathVariable Long id) {
        return userRepository.findUserByID(id);
    }

    @GetMapping("/allsalary")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Salary> findAllSalarys() {
        return salaryRepository.findAll();
    }

    @GetMapping("/createsalary/{salary}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Salary putSalary(@PathVariable Double salary) {
        Salary createSalary = new Salary(salary);
        return salaryRepository.save(createSalary);
    }
}
