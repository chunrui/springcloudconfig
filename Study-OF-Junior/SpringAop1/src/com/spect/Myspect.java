package com.spect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//MethodInterceptor�ӿڣ���һ�ַ����淶
public class Myspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("yu");
		Object obj = mi.proceed(); //�ֶ�����
		System.out.println("tdt");
		return obj;
	}

}
