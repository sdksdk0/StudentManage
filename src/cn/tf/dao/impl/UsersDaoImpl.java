package cn.tf.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import cn.tf.dao.UsersDao;
import cn.tf.entity.Users;
import cn.tf.utils.HibernateSessionFactory;

public class UsersDaoImpl implements UsersDao {

	@Override
	public boolean usersLogin(Users user) {
		
		Transaction tx=null;
		String hql="";
		
		
		try{
			Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			
			hql="from Users  where username=? and password=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			
			List list=query.list();
			tx.commit();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
			
		}
				
	}
	
}
