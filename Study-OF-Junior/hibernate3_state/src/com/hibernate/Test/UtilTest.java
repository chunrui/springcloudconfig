package com.hibernate.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.Utils.HibernateUtilTest;

public class UtilTest{
	public void d(){
		//��ȡȫ�µ�session������
		Session session = HibernateUtilTest.getopenSession();
		Transaction tx = session.beginTransaction();
		//session.save(user);
		tx.commit();
		session.close();
	}

}
