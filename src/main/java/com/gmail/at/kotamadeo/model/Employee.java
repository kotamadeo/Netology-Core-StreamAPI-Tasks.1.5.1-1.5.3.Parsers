package com.gmail.at.kotamadeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private long id;
    private String name;
    private String surname;
    private String country;
    private String sex;
    private byte age;
    private int salary;
}
