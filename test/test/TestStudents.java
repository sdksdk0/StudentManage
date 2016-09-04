package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Assert;
import org.junit.Test;

import cn.tf.entity.Students;
import cn.tf.entity.Users;
import cn.tf.service.BusinessService;
import cn.tf.service.impl.BusinessServiceImpl;

public class TestStudents {
	
/*	@Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration  config=new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory  sessionFactory=config.buildSessionFactory(serviceRegistry);

		Session session=sessionFactory.getCurrentSession();
		SchemaExport export=new SchemaExport(config);
		export.create(true,true);
		}
		*/
	
	//@Test
	public void testUserLogin(){
		BusinessService  bussBusinessService=new BusinessServiceImpl();
		
		Users u=new Users(1,"张三","123456");
		//bussBusinessService.usersLogin(u);
		Assert.assertEquals(true, bussBusinessService.usersLogin(u));
		
	}
	
	//@Test
	public void testSaveStudent(){
		//创建配置对象
		Configuration  config=new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory  sessionFactory=config.buildSessionFactory(serviceRegistry);

		Session session=sessionFactory.getCurrentSession();
		
		//创建事务对象
		Transaction tx=session.beginTransaction();
		
		Students s1=new Students("s1601001","王武","女",new Date(),"湖南衡阳");
		Students s2=new Students("s160102","王大锤","男",new Date(),"湖南长沙");
		Students s3=new Students("s160103","王尼玛","男",new Date(),"湖南衡阳");
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		tx.commit();
		sessionFactory.close();
		
	}
	
	
	


}