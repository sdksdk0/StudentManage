package cn.tf.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.tf.entity.Students;
import cn.tf.entity.Users;
import cn.tf.service.BusinessService;
import cn.tf.service.impl.BusinessServiceImpl;

import com.opensymphony.xwork2.ModelDriven;

public class StudentsAction extends SuperAction  {

	private BusinessService  businessService=new BusinessServiceImpl();
	private Students students=new Students();
	
	//查询学生信息
	public String query(){
		List<Students> list = businessService.findAllStudent();
		
		if(list!=null && list.size()>0){
			session.setAttribute("students_list", list);	
		}
		return "QUERY_SUCCESS";
	}
	
	//删除
	public String delete(){
		String sid=request.getParameter("sid");
		businessService.delete(sid);
		return "delete_sucess";
		
	}
	
	
	
	public String add() throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String sname=request.getParameter("sname");
		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String address=request.getParameter("address");
		
		System.out.println(sname+" "+gender+" "+birthday+" "+address);
		
		students.setSname(sname);
		students.setGender(gender);
		students.setBirthday(formatter.parse(birthday));
		students.setAddress(address);
		
		businessService.add(students);
		return "ADD_SUCESS";
		
	}




	
	

}
