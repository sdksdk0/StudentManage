package cn.tf.action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.tf.entity.Students;
import cn.tf.entity.Users;
import cn.tf.service.BusinessService;
import cn.tf.service.impl.BusinessServiceImpl;

import com.opensymphony.xwork2.ModelDriven;

public class StudentsAction extends SuperAction  {

	private BusinessService  businessService=new BusinessServiceImpl();
	
	public String query(){
		List<Students> list = businessService.findAllStudent();
		
		if(list!=null && list.size()>0){
			session.setAttribute("students_list", list);	
		}
		return "QUERY_SUCCESS";
	}
	
	
	
	

}
