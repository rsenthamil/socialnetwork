package com.SocialNetworkBackEnd.Config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.SocialNetworkBackEnd.Dao.BlogDao;
//import com.SocialNetworkBackEnd.Dao.BlogDaoImpl;
import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.Dao.UserDaoImpl;
//import com.SocialNetworkBackEnd.Model.Blog;
import com.SocialNetworkBackEnd.Model.UserDetails;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.SocialNetworkBackEnd.*")
@EnableWebMvc
public class AppConfig 
{
	   //1.Creating a DataSource Object which is used for LocalSessionFactory
	    @Autowired
	    @Bean(name="Datasource")
		public DataSource getOracleDataSource()
		{
			DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			driverManagerDataSource.setUsername("System");
			driverManagerDataSource.setPassword("ArunaiSent20");
		    System.out.println("session bean created");
			return driverManagerDataSource;
		}
		
		//2.Creating Hibernate Properties which is used by LocalSessionFactory
	    @Autowired
	    @Bean(name="Properties")
		public Properties getHibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "create");
			properties.put("hibernate.dialect","org.hibernate.dialect.Oracle11gDialect");
			return properties;
		}
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory()
		{
			LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
			localSessionFactoryBuilder.addAnnotatedClass(UserDetails.class);
			System.out.println("SessionFactory Bean Created");
			return localSessionFactoryBuilder.buildSessionFactory();
		}
		@Autowired
		@Bean(name="TransactionManager")
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			return new HibernateTransactionManager(sessionFactory);
		}
		
		@Autowired
		@Bean(name="userdao")
		public UserDao getUserDao(SessionFactory sessionFactory)
		{
			System.out.println("User DAO Created");
			return new UserDaoImpl(sessionFactory);
		}
}