package com.ManyToManyTest;

import org.hibernate.Session;
import org.junit.Test;

import com.Model.Course;
import com.Model.Student;
import com.hibernate.Utils.HibernateUtilTest;

public class ManyToMany {
	@Test
	public void ManyToMany(){
		Session session = HibernateUtilTest.getopenSession();
		Course c = new Course();
		Student s = new Student();
		c.setName("���ݽṹ");
		session.save(c);
		s.setName("С��");
		session.save(s);
		/*
		 * ������������ά��cid��sid������������add��ʱ�򣬻����Υ������Լ��
		 */
		
		//s.getCourses().add(c);
		c.getStudents().add(s);
	    session.beginTransaction().commit();
	    session.close(); 
	}
	
	@Test
	public void ManyToMany2(){
		
	}
	
}
