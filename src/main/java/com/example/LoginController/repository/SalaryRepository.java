package com.example.LoginController.repository;

import com.example.LoginController.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

    List<Salary> findAll();

    Salary getSalaryByUser_Id(Long id);
}
