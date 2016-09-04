package cn.tf.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.tf.dao.StudentsDao;
import cn.tf.entity.Students;
import cn.tf.utils.HibernateSessionFactory;

public class StudentsDaoImpl implements StudentsDao{

	@Override
	public List<Students> findAllStudent() {
		Transaction tx=null;
		List<Students> list=null;
		String hql="";
		
		try {
			Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Students";
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.commit();
			return list;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
		
		
		
	}

	@Override
	public Students findById(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Students s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Students s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Students sid) {
		// TODO Auto-generated method stub
		return false;
	}

}
