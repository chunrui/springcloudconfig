package com.itheima.web.action;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport {
	
	public String loginAction(){
		System.out.println("ִ����action");
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", "jjj");
		return "success";
		
	}

}
