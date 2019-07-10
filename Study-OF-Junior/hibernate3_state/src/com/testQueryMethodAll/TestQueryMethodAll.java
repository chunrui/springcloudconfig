package com.testQueryMethodAll;

import java.util.List;

import habernateOne.User;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;



public class TestQueryMethodAll {
	@Test
	public void testQueryMethodAll(){
		//����ȫ�ֵ�src
	Configuration con = new Configuration().configure();
	//����һ��session����
	SessionFactory sessionFactory = con.buildSessionFactory();
	//�ɹ����������Ӷ���session
	 Session session = sessionFactory.openSession();
	 /*����1*/
	 //��ѯ��������������ֶ�
	 /*Query query = session.createQuery("from User"); //������ֵ
	 List<User> list = query.list();
	 for(User user2: list)
		 System.out.println(user2);*/
	 //---------------------
	 /*����2*/
	/* Criteria criteria =session.createCriteria(User.class);
	 List<User> list = criteria.list();
	 for(User user2: list)
		 System.out.println(user2);*/
	 //---------------------
	 /*����3*/
	/* SQLQuery SQLQuery = session.createSQLQuery("select * from t_user");
	 SQLQuery.addEntity(User.class);
	 List<User> list = SQLQuery.list();
	 for(User user2: list)
		 System.out.println(user2);*/
	 //----------------------------------------
	 /*�����������ַ���*/
	/* Transaction transaction = session.beginTransaction();
	 Transaction transaction2 = session.getTransaction();
	 transaction.commit();*/
	 
	 
	}
}
