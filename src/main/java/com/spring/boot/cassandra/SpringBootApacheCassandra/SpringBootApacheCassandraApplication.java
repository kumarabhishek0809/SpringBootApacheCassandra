package com.spring.boot.cassandra.SpringBootApacheCassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.spring.boot.cassandra.SpringBootApacheCassandra")
public class SpringBootApacheCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApacheCassandraApplication.class, args);
	}

}
