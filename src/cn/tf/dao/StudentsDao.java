package cn.tf.dao;

import java.util.List;

import cn.tf.entity.Students;

//学生表的接口
public interface StudentsDao {
	
	//查询所有学生资料
	public List<Students> findAllStudent();
	
	//通过id查询学生资料
	public Students findById(String sid);
	
	//添加学生资料
	public boolean add(Students s);
	
	//修改
	public boolean update(Students s);
	
	//删除
	public boolean delete(String sid);
	

}
