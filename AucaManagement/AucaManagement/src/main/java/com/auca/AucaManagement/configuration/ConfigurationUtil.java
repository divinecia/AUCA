package com.auca.AucaManagement.configuration;

import java.lang.module.Configuration;
import java.util.Properties;

import com.auca.AucaManagement.domain.Student;


public class ConfigurationUtil {
    
	private static SessionFactory sessionFactory;
	
	public static Configuration getConfiguration() {
		Configuration configuration = new Configuration();
		
		Properties properties = new Properties();
		
		properties.put(Environment.DRIVER, "org.postgresql.Driver");
		properties.put(Environment.URL, "jdbc:postgresql://localhost:5433/studentManagement");
		properties.put(Environment.USER, "postgres");
		properties.put(Environment.PASS, "pazofils");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, "true");
		
		configuration.setProperties(properties);
	
		
		return configuration;
	}
	
	public static SessionFactory getConnectionForStudent() {
		
		try {
			if(sessionFactory == null) {
			
			Configuration configuration = getConfiguration();
			
			configuration.addAnnotatedClass(Student.class);
			
			
			sessionFactory = configuration.buildSessionFactory();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return sessionFactory;
	}
}
