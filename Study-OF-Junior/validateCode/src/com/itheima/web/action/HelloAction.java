package com.itheima.web.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import cn.dsna.util.images.ValidateCode;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * Struts2�����Ű���
 * @author zhy
 *
 */
public class HelloAction extends StrutsResultSupport{//������

	/**
	 * �ڶ������е�ָ���Ķ�������
	 * ������������дҪ��
	 * 		1������public��
	 * 		2������ֵ������һ��String
	 * 		3������û�в���
	 * @return
	 */
	private int height;
	private int width;
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	
	public String sayHello(){
		System.out.println("HelloAction��sayHello����ִ����");
		return "success";//�������ļ���result��nameȡֵ���Ӧ
	}
    /*
     * (non-Javadoc)
     * @see org.apache.struts2.dispatcher.StrutsResultSupport#doExecute(java.lang.String, com.opensymphony.xwork2.ActionInvocation)
     * ��дdoExecute�ķ���
     */
	@Override
	protected void doExecute(String arg0, ActionInvocation arg1)
			throws Exception {
		
		ValidateCode code= new ValidateCode(width,height,4,10);
		HttpServletResponse  Response  = ServletActionContext.getResponse();
		code.write(Response.getOutputStream());
	}
	
}
