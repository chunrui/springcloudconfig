package com.hibernate.Test;

import habernateOne.User;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.Utils.HibernateUtilTest;

public class State_trans {

	/*
	 * ˲ʱת����
	 */
	@Test
	public void state_trans1() {
		Session session = HibernateUtilTest.getopenSession();
		Transaction tx = session.beginTransaction();
		User user = new User(); //˲ʱ̬
		//user.setId(1); //����̬
		user.setPassword("wq1234");
		session.save(user);
		tx.commit();
	}
	
	/*
	 * ˲ʱת�־�
	 */
	@Test
	public void state_trans2() {
		Session session = HibernateUtilTest.getopenSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setUsername("ghhh");
		user.setPassword("wq1234");
		session.save(user);
		tx.commit();
		session.close();
		
	}
	
	/*
	 * �־�ת����
	 */
	@Test
	public void state_trans3() {
		Session session = HibernateUtilTest.getopenSession();
		User user = (User) session.get(User.class, 2);
		session.evict(user);
		
	}
	/*
	 * �־�ת˲ʱ
	 */
	@Test
	public void state_trans4() {
		Session session = HibernateUtilTest.getopenSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, 1);
		user.setId(null);	
		session.evict(user);
		session.update(user);
		tx.commit();
		session.close();
	}
	/*
	 * ����ת˲ʱ
	 */
	@Test
	public void state_trans5() {
		Session session = HibernateUtilTest.getopenSession();
		User user = (User) session.get(User.class, 2);
		session.evict(user);
		user.setId(null);
		user.setPassword("kkk");
		session.update(user);
		
	}
	/*
	 * ����ת�־�
	 */
	@Test
	public void state_trans6() {
		Session session = HibernateUtilTest.getopenSession();
		User user = new User();
		user.setId(3);
		session.update(user);	
	}	

}
