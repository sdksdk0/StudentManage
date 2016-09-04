package cn.tf.service;

import java.util.List;

import cn.tf.entity.Students;
import cn.tf.entity.Users;

public interface BusinessService {
	
	//用户登录
	public boolean usersLogin(Users user);
	
	
	//查询所有学生资料
	public List<Students> findAllStudent();
	
	//通过id查询学生资料
	public Students findById(String sid);
	
	//添加学生资料
	public boolean add(Students s);
	
	//修改
	public boolean update(Students s);
	
	//删除
	public boolean delete(Students sid);
	

}
