package com.itheima.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import model.User;
import userDao.userImpl.UserImpl;

/**
 * Struts2�����Ű���
 * @author zhy
 *
 */
public class HelloAction extends ActionSupport implements ModelDriven<User>{//������
	
	/**
	 * �ڶ������е�ָ���Ķ�������
	 * ������������дҪ��
	 * 		1������public��
	 * 		2������ֵ������һ��String
	 * 		3������û�в���
	 * @return
	 */
	
	private User user = new User();
	public String sayHello(){
	    UserImpl us = new UserImpl();
	    us.add(user);
	    return "success";
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	  /*public void validate() {
	    if(StringUtils.isEmpty(user.getUsername())){
	    	addFieldError("username", "�������û���");
	   	
	    }
	   
	  }
	*/
	
	 // @SkipValidation
	  public String findAll(){
		  return"success";
	  }
     	
}
