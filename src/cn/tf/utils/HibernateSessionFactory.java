package cn.tf.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateSessionFactory {
	
	private static SessionFactory  sessionFactory;

	
	private HibernateSessionFactory() {
		
		
	}
	
	//公有的静态方法
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			Configuration  config=new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			sessionFactory=config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		}else{
			return sessionFactory;
		}
		
	}
	

}
