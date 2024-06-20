package com.example.employee.Entity;

public class Employee {
    String EmpName;
    int age;

    public Employee(String name, int age) {
        this.EmpName = name;
        this.age = age;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setage(int age) {
        this.age = age;
    }

    public int getage() {
        return age;
    }

    public void setEmpName(String name) {
        this.EmpName = name;
    }
}
