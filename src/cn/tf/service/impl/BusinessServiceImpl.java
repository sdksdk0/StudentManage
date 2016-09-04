package cn.tf.service.impl;

import java.util.List;

import cn.tf.dao.StudentsDao;
import cn.tf.dao.UsersDao;
import cn.tf.dao.impl.StudentsDaoImpl;
import cn.tf.dao.impl.UsersDaoImpl;
import cn.tf.entity.Students;
import cn.tf.entity.Users;
import cn.tf.service.BusinessService;

public class BusinessServiceImpl implements BusinessService{

	UsersDao userDao=new UsersDaoImpl();
	StudentsDao studentsDao=new StudentsDaoImpl();
	
	@Override
	public boolean usersLogin(Users user) {
		return userDao.usersLogin(user);
	}

	@Override
	public List<Students> findAllStudent() {
		return studentsDao.findAllStudent();
	}

	@Override
	public Students findById(String sid) {
		
		return studentsDao.findById(sid);
	}

	@Override
	public boolean add(Students s) {
		
		return studentsDao.add(s);
	}

	@Override
	public boolean update(Students s) {
		
		return studentsDao.update(s);
	}

	@Override
	public boolean delete(String sid) {
		
		return studentsDao.delete(sid);
	}
	

}
