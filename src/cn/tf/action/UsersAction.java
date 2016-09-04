package cn.tf.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.tf.entity.Users;
import cn.tf.service.BusinessService;
import cn.tf.service.impl.BusinessServiceImpl;

import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction  implements ModelDriven<Users>{

	private BusinessService  businessService=new BusinessServiceImpl();
	private Users user=new Users();
	
	
	
	
	@Override
	public void validate(){
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空");
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "密码长度不能少于6位");
		}
	}
	
	
	//用户登陆
	
	public String login(){
		if(businessService.usersLogin(user)){
			
			//在session中保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			
			return "LOGIN_SUCCESS";
		}else{
			return "LOGIN_ERROR";
		}
	}
	
	
	//用户注销
	@SkipValidation
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		return "LOGOUT_SUCCESS";
	}
	

	
	
	@Override
	public Users getModel() {
		
		return this.user;
	}

}
