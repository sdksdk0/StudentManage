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
		
		Transaction tx=null;
		Students s=null;
		
		try {
			Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
		
			s=(Students) session.get(Students.class, sid);
			
			tx.commit();
			return s;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.commit();
			return s;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}	
	}

	@Override
	public boolean add(Students s) {
		s.setSid(getNewSid());
		Transaction tx=null;
		
		try {
			Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(s);

			tx.commit();
			return true;
		} catch (HibernateException e) {
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	private String getNewSid(){

		Transaction tx=null;
		String hql="";
		String sid=null;
		try {
			Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			
			hql="select max(sid) from Students";
			Query query=session.createQuery(hql);
			sid=(String) query.uniqueResult();
			if(sid==null || "".equals(sid)){
				sid="s1600001";
			}else{
				String temp=sid.substring(1);
				int i=Integer.parseInt(temp);
				i++;
				temp=String.valueOf(i);
				int len=temp.length();
				for(int j=0;j<7-len;j++){
					temp="0"+temp;
				}
				sid="S"+temp;
			}
			tx.commit();
			return sid;
			
		}catch (HibernateException e) {
			tx.commit();
			return null;
		}finally{
				if(tx!=null){
					tx=null;
				}
		}
		
	}
	
	
	@Override
	public boolean update(Students s) {
		Transaction tx=null;
		
		try {
			Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			
			session.update(s);

			tx.commit();
			return true;
		} catch (HibernateException e) {
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean delete(String sid) {
		Transaction tx=null;
		
		try {
			Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			
			Students s=(Students) session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;
		}catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}finally{
				if(tx!=null){
					tx=null;
				}
		}
		
	}

}
