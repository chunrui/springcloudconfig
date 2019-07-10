package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;



public class SpringAopTest {
   @Test
   public void test(){
	 //����xml
	 String path = "com/test/bean.xml";
	//�õ�����
	 ApplicationContext context = new ClassPathXmlApplicationContext(path);
	//��ô�����
	UserService userService = (UserService) context.getBean("UserServiceId");
	userService.print();

   }
}
