package com.spring.boot.cassandra.SpringBootApacheCassandra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Autowired
    private Environment env;

    @Override
    public String getKeyspaceName() {
        return env.getProperty("spring.data.cassandra.keyspace-name");
    }


    @Bean
    public CassandraMappingContext mappingContext() throws ClassNotFoundException {
        CassandraMappingContext mappingContext = new CassandraMappingContext();
        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(), getKeyspaceName()));
        return mappingContext;
    }


    @Bean
    public CassandraAdminTemplate cassandraTemplate() throws Exception {

        CassandraAdminTemplate template =
                new CassandraAdminTemplate(session().getObject(), converter());
        return template;
    }


    @Bean
    public CassandraSessionFactoryBean session() {
        CassandraSessionFactoryBean sess = new CassandraSessionFactoryBean();
        sess.setKeyspaceName(getKeyspaceName());
        sess.setCluster(cluster().getObject());
        try {
            sess.setConverter(converter());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sess.setSchemaAction(SchemaAction.NONE);
        return sess;

    }


    @Bean
    public CassandraConverter converter() throws ClassNotFoundException {
        return new MappingCassandraConverter(mappingContext());
    }


    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster =
                new CassandraClusterFactoryBean();
        String property = env.getProperty("spring.data.cassandra.port");
        cluster.setPort(new Integer(property));
        cluster.setContactPoints(env.getProperty("spring.data.cassandra.contact-points"));
        cluster.setJmxReportingEnabled(false);
        return cluster;

    }

}