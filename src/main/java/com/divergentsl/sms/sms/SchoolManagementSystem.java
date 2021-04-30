package com.divergentsl.sms.sms;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.divergentsl.sms.config.AppConfig;

public class SchoolManagementSystem
{
	public static SessionFactory factory;
	
    public static void main( String[] args )
    {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    	factory = new Configuration().configure().buildSessionFactory();

    	CRUDMain crudMain = context.getBean(CRUDMain.class);
    	
    	crudMain.mainPanel();
    
    	context.close();
    }
    
    
}
