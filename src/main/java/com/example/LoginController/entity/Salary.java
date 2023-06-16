package com.example.LoginController.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double salary;

    @OneToOne(mappedBy = "salary")
    @JsonIgnore
    private UserEntity user;


    public Salary(Double salary) {
        this.salary=salary;
    }

    public Salary(Long id, double salary, UserEntity user) {
        this.id = id;
        this.salary = salary;
        this.user = user;
    }
    public Salary(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
