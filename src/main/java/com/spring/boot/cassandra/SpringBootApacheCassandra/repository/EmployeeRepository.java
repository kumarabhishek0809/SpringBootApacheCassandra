package com.spring.boot.cassandra.SpringBootApacheCassandra.repository;

import com.spring.boot.cassandra.SpringBootApacheCassandra.entity.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, UUID> {
}
