package com.itheima.web.action;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Download extends ActionSupport {
	private InputStream inputStream;
	
	public String download() throws Exception{
		//1.�ҵ�һ��·��
		String filePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files/mei.png");
		//2.����һ��Stream��
		inputStream = new FileInputStream(filePath);
		//�ڷ���֮ǰ����filename��ֵ
				//filename="��Ƭ.jpg";		
		//3.����һ���ɹ�
		return SUCCESS;
		//4.��һ������stream�Ľ������Ϊ���ǰ�ʣ�µ��������ꡣ		
	}
	
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
