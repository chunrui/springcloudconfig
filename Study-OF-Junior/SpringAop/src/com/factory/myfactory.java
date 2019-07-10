package com.factory;

import com.service.UserService;
import com.serviceimpl.UserImpl;
import com.spect.MyAspect;

public class myfactory {
	//����Ŀ����
	final UserService userService = new UserImpl();
	final MyAspect myAspect = new MyAspect();
	UserService proxService = (UserService)Proxy.newProxyInstance(
			MyBeanFactory.class.getClassLoader(), 
			userService.getClass().getInterfaces(), 
			new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					
					//ǰִ��
					myAspect.before();
					//ִ��Ŀ����ķ���
					Object obj = method.invoke(userService, args);
					//��ִ��
					myAspect.after();
					return obj;
				}
				}
			);
	return proxService;   
}

}
