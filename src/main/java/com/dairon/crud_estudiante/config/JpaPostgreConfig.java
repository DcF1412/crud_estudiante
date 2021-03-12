package com.dairon.crud_estudiante.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.dairon.crud_estudiante.repository" }, entityManagerFactoryRef = "jpaEntityManagerFactory", transactionManagerRef = "jpaTransactionManager")
public class JpaPostgreConfig {

    private final Environment env;

    public JpaPostgreConfig(Environment env) {
        this.env = env;
    }


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean jpaEntityManagerFactoryBean(EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource()).packages("com.dairon.crud_estudiante.domain").properties(additionalProperties()).build();
    }

    private Map<String, String> additionalProperties() {
        final Map<String, String> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
        props.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.database-platform"));
        props.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));

        return props;
    }

    @Bean
    @Primary
    public PlatformTransactionManager jpaTransactionManager(final EntityManagerFactory factory){
        return new JpaTransactionManager(factory);
    }

}
