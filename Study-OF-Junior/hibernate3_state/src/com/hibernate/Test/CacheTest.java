package com.hibernate.Test;

import habernateOne.User;

import org.hibernate.Session;
import org.junit.Test;

import com.hibernate.Utils.HibernateUtilTest;

public class CacheTest {
	/*
	 * ֤��һ������Ĵ���
	 * �������ֻ̨�д�ӡһ��select��䣬
	 * �򻺴����
	 */
	@Test
	public void cache(){
		Session session = HibernateUtilTest.getopenSession();
		User u1 = (User) session.get(User.class, 1);
		User u2 = (User) session.get(User.class, 1);
		User u3 = (User) session.get(User.class, 1);
		session.close();
		
	}
	
	@Test
	public void cache2(){
		Session session = HibernateUtilTest.getopenSession();
		User u1 = (User) session.get(User.class, 1);
		session.update(u1);
		session.beginTransaction().commit();
		session.close();	
	}
	
	@Test
	public void cache3(){
		Session session = HibernateUtilTest.getopenSession();
		User u1 = new User();
		u1.setPassword("gggg");
		u1.setUsername("lala");
		session.save(u1);
		session.beginTransaction().commit();
		session.close();	
	}
	

}
