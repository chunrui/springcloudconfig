package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	
	//���� Handler����֮ǰִ��
	//���������֤�������Ȩ
	//���������֤�������֤ͨ����ʾ��ǰ�û�û�е�½����Ҫ�˷������ز�������ִ��
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//��ȡ�����url
		String url = request.getRequestURI();
		//�ж�url�Ƿ��ǹ��� ��ַ��ʵ��ʹ��ʱ������ ��ַ���������ļ��У�
		//���﹫����ַ�ǵ�½�ύ�ĵ�ַ
		if(url.indexOf("login.action")>=0){
			//������е�½�ύ������
			return true;
		}
		
		//�ж�session
		HttpSession session  = request.getSession();
		//��session��ȡ���û������Ϣ
		String eid = (String) session.getAttribute("eid");
		
		if(eid != null){
			//��ݴ��ڣ�����
			return true;
		}
		
		//ִ�������ʾ�û������Ҫ��֤����ת��½ҳ��
		request.getRequestDispatcher("/login.html").forward(request, response);
		
		//return false��ʾ���أ�������ִ��
		//return true��ʾ����
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}