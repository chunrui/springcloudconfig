package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.Student;
import userDao.userImpl.StudentImpl;
/*
 * StudentAction�̳�ActionSupport�࣬ʵ��ModelDriven
 */
public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private Student st = new Student();
	/*
	 * ���yyHello()������ʵ�����ѧ���Ĺ���
	 * 
	 */
	public String yyHello(){
		StudentImpl sp = new StudentImpl();
	    sp.add(st);
	    return "success";
	}
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 * ����getModel�ķ���������ѧ������
	 */
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return st;
	}

}
