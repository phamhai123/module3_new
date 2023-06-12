package com.example.case_study_module3.repository.employee;

import com.example.case_study_module3.model.Employee;
import com.example.case_study_module3.model.infomation.employee.Division;
import com.example.case_study_module3.model.infomation.employee.Education;
import com.example.case_study_module3.model.infomation.employee.Position;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findALL();
    List<Position> positionAll();
    List<Education> educationAll();
    List<Division> divisionAll();
    void save(Employee employee);
    Employee findById(int id);
    void update(int id,Employee employee);
    void delete(int id);
}
