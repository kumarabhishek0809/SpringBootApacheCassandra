package com.spring.boot.cassandra.SpringBootApacheCassandra;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CassandraConfig.class)
public class EmployeeRepositoryIntegrationTest {

    @BeforeClass
    public static void startCassandraEmbedded() {
    }

}
