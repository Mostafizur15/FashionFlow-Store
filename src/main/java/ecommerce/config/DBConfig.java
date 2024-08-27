package ecommerce.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ecommerce.model.CartItem;
import ecommerce.model.Category;
import ecommerce.model.OrderDetail;
import ecommerce.model.Product;
import ecommerce.model.Supplier;
import ecommerce.model.UserDetails;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "ecommerce")
public class DBConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/SPRINGMVCECOMMERCE");
        dataSource.setUsername("root");
        dataSource.setPassword("forhad");
        System.out.println("Data Source Successfully Created.............");
        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getSessionFactory() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");

        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(getDataSource());
        factory.setHibernateProperties(hibernateProperties);
        factory.setAnnotatedClasses(Category.class, Product.class,Supplier.class,UserDetails.class,CartItem.class,OrderDetail.class);
        System.out.println("Session Factory Successfully Created.............");
        return factory;
    }

    @Bean(name = "hibernateTemplate")
    public HibernateTemplate hibernateTemplate() {
        System.out.println("HibernateTemplate Successfully Created.............");
        return new HibernateTemplate(getSessionFactory().getObject());
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        System.out.println("HibernateTransactionManager Successfully Created.............");
        return transactionManager;
    }
}
