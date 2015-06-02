package org.lyndon.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by yli on 6/2/2015.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"org.lyndon.repository2"}, entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager")
public class MysqlJpaConfig extends BaseJpaConfig {

    private static final String DATABASE_DRIVER = "db.driver";
    private static final String DATABASE_URL = "db.url2";
    private static final String DATABASE_USER = "db.user";
    private static final String DATABASE_PASSWORD = "db.password";
    private static final String PACKAGES_TO_SCAN = "packages.to.scan2";

    @Bean
    @ConfigurationProperties(prefix = "datasource.secondary")
    public DataSource dataSource2() {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER));
        source.setUrl(env.getRequiredProperty(DATABASE_URL));
        source.setUsername(env.getRequiredProperty(DATABASE_USER));
        source.setPassword(env.getRequiredProperty(DATABASE_PASSWORD));
        return source;
    }

    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource2());
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setPackagesToScan(env.getRequiredProperty(PACKAGES_TO_SCAN).split(","));
        factory.setJpaProperties(hibernateProperties());
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(mysqlEntityManagerFactory().getObject());
        return manager;
    }

}
