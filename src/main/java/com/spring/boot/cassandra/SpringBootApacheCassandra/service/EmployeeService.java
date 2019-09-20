package com.spring.boot.cassandra.SpringBootApacheCassandra.service;

import com.spring.boot.cassandra.SpringBootApacheCassandra.dao.EmployeeDAO;
import com.spring.boot.cassandra.SpringBootApacheCassandra.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }

    public Employee getEmployee(UUID id) {
        return employeeDAO.getEmployee(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(UUID id) {
        employeeDAO.deleteEmployee(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}
