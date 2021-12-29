/*
 * package com.cardmanagementsystemm.cardmanagementsystemm;
 * 
 * import java.util.Properties;
 * 
 * import javax.activation.DataSource;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.jdbc.datasource.DriverManagerDataSource; import
 * org.springframework.orm.hibernate5.HibernateTransactionManager; import
 * org.springframework.orm.hibernate5.LocalSessionFactoryBean; import
 * org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * @Configuration
 * 
 * @EnableTransactionManagement public class HibernateConf {
 * 
 * @Bean public LocalSessionFactoryBean sessionFactory() {
 * LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
 * sessionFactory.setDataSource((javax.sql.DataSource) dataSource());
 * sessionFactory.setPackagesToScan( "com.baeldung.hibernate.bootstrap.model");
 * sessionFactory.setHibernateProperties(hibernateProperties());
 * 
 * return sessionFactory; }
 * 
 * @Bean public DataSource dataSource() { DriverManagerDataSource dataSource =
 * new DriverManagerDataSource();
 * dataSource.setDriverClassName("ocom.mysql.jdbc.Driver");
 * dataSource.setUrl("root@localhost:3306/agora");
 * dataSource.setUsername("root"); dataSource.setPassword("1234postgres");
 * 
 * return (DataSource) dataSource; }
 * 
 * @Bean public PlatformTransactionManager hibernateTransactionManager() {
 * HibernateTransactionManager transactionManager = new
 * HibernateTransactionManager();
 * transactionManager.setSessionFactory(sessionFactory().getObject()); return
 * transactionManager; }
 * 
 * private final Properties hibernateProperties() { Properties
 * hibernateProperties = new Properties(); hibernateProperties.setProperty(
 * "hibernate.hbm2ddl.auto", "create-drop"); hibernateProperties.setProperty(
 * "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
 * 
 * return hibernateProperties; } }
 */