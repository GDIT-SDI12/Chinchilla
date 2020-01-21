package nz.students.forsdi.chinchilla.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan("nz.students.forsdi.chinchilla")
@PropertySource({"classpath:persistence-postgre.properties"})
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private Environment env;

    @Bean
    public DataSource appDataSource() {
        Properties props = new Properties();

        props.setProperty("dataSourceClassName", env.getProperty("jdbc.dataSourceClassName"));
        props.setProperty("dataSource.user", env.getProperty("jdbc.user"));
        props.setProperty("dataSource.password", env.getProperty("jdbc.password"));
        props.setProperty("dataSource.databaseName", env.getProperty("jdbc.databaseName"));

        HikariConfig config = new HikariConfig(props);
        HikariDataSource ds = new HikariDataSource(config);

        return ds;
    }

    private Properties getHibernateProperties() {
        // set hibernate properties
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        // create session factory
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        // set the properties
        sessionFactory.setDataSource(appDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packageToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        // setup transaction manager based on session factory
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
