/*
 * Class: MSSQLDataSourceConfiguration
 *
 * Created on Nov 13, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.minhtran.vom.vbm.infra.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import vn.minhtran.vom.vbm.infra.repository.InvoiceRepository;

@EnableJpaRepositories(basePackageClasses = { InvoiceRepository.class })
@Configuration
public class MSSQLDataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.jpa")
    JpaProperties jpaProperties() {
        return new JpaProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.jpa.hibernate")
    HibernateProperties msssqlHibernateProperties() {
        return new HibernateProperties();
    }
}
