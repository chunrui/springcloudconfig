package myInterceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Interceptor1 extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
	    System.out.println("ִ��������֮ǰ");
		String value = arg0.invoke();
		System.out.println("ִ��������֮��");
		return value;
	}

}
