package com.globallogic.mosquitto.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
@EnableAsync
@EnableCassandraRepositories(basePackages = {"com.globallogic.mosquitto.cassandra.repository"})
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(environment
				.getProperty("cassandra.contactpoints"));
		cluster.setPort(Integer.parseInt(environment
				.getProperty("cassandra.port")));
		return cluster;
	}

	@Override
	protected String getKeyspaceName() {
		// TODO Auto-generated method stub
		return environment.getProperty("cassandra.keyspace");
	}

	@Bean
	public CassandraMappingContext cassandraMapping()
			throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}
}
