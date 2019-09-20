package com.spring.boot.cassandra.SpringBootApacheCassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Table("employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @PrimaryKeyColumn(name = "id", type = PARTITIONED)
    private UUID id;

    @Column("name")
    private String name;

    @Column
    private int age;

    @Column(value = "salary")
    private float salary;

}
