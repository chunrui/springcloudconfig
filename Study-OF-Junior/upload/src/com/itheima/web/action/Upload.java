package com.itheima.web.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;



import com.opensymphony.xwork2.ActionSupport;

public class Upload extends ActionSupport {

	//�����ṩ���ֶ�
	private String username;
	private File photo;
	//struts2���ļ��ϴ�ʱ�ṩ������
	private String photoFileName;//�ϴ����ļ������ϴ��ֶ�����+FileName  ע���Сд
	private String photoContentType;//�ϴ��ļ���MIME���͡��ϴ��ֶ�����+ContentType ע���Сд
	
	
	public String upload(){
		//1.�õ�ServletContext
		ServletContext application = ServletActionContext.getServletContext();
		//2.����realPath��������ȡ����һ������Ŀ¼�õ�����ʵĿ¼
		String filePath = application.getRealPath("/WEB-INF/files");
		//3.��������ʵ��Ŀ¼�����ڣ���Ҫ����
		/*�˴ε�file�İ���io��*/
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		//4.��photo���ȥ
		//������    ��ע�⣺��ʱ�ļ�����
		//FileUtils.copyFile(photo, new File(file,photoFileName));
		
		//���У�����ʱ�ļ�����ָ����λ�ã����Ҹ����������� ע�⣺��ʱ�ļ�û����
		photo.renameTo(new File(file,photoFileName));
		
		return "success";
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}


	public String getPhotoFileName() {
		return photoFileName;
	}


	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	public String getPhotoContentType() {
		return photoContentType;
	}


	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	
}