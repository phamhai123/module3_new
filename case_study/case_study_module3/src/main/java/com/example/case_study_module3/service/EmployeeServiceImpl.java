package com.example.case_study_module3.service;

import com.example.case_study_module3.model.Employee;
import com.example.case_study_module3.model.infomation.employee.Division;
import com.example.case_study_module3.model.infomation.employee.Education;
import com.example.case_study_module3.model.infomation.employee.Position;
import com.example.case_study_module3.repository.employee.EmployeeRepository;
import com.example.case_study_module3.repository.employee.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository repository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findALL() {
        return repository.findALL();
    }

    @Override
    public List<Position> positionAll() {
        return repository.positionAll();
    }

    @Override
    public List<Education> educationAll() {
        return repository.educationAll();
    }

    @Override
    public List<Division> divisionAll() {
        return repository.divisionAll();
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(int id, Employee employee) {
        repository.update(id,employee);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
