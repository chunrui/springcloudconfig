package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Scope.User;

public class ScopeTest {
   @Test
   public void test(){
	 //����xml
	 String path = "com/Scope/application.xml";
	//�õ�����
	 ApplicationContext context = new ClassPathXmlApplicationContext(path);
     User user = context.getBean("user",User.class);
     /*User user1 = context.getBean("user",User.class);
     System.out.println(user==user1);*/
     user.print();
   }
}
