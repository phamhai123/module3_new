package com.example.case_study_module3.model;

public class Employee extends Person{
    private double salary;
    private int position;
    private int education;
    private int division;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String idCard, double salary, String phone, String email, String address, int position, int education, int division) {
        super(id, name, birthday, idCard, phone, email, address);
        this.salary = salary;
        this.position = position;
        this.education = education;
        this.division = division;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }
}
