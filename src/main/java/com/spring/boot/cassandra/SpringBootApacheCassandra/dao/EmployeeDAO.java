package com.spring.boot.cassandra.SpringBootApacheCassandra.dao;

import com.spring.boot.cassandra.SpringBootApacheCassandra.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeDAO {

    @Autowired
    private CassandraAdminTemplate cassandraAdminTemplate;

    public Employee createEmployee(Employee employee) {
        return cassandraAdminTemplate.insert(employee);
    }

    public Employee getEmployee(UUID id) {
        return cassandraAdminTemplate.selectOneById(id, Employee.class);
    }

    public Employee updateEmployee(Employee employee) {
        return cassandraAdminTemplate.update(employee);
    }

    public void deleteEmployee(UUID id) {
        cassandraAdminTemplate.deleteById(id, Employee.class);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(); //cassandraAdminTemplate.select(Employee.class);
    }
}
