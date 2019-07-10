package com.OneToManyTest;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.Model.Customer;
import com.Model.Order;
import com.hibernate.Utils.HibernateUtilTest;

public class OnetToMany {
	@Test
	public void onetToMany(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = new Customer();
	    c.setName("kkkk");
	    Order o1 = new Order();
	    Order o2 = new Order();
	    //  ����������䶼��ά����ϵ
	    o1.setName("Ӳ��");
	    o2.setName("�ʼǱ�");
	   /* o1.setCustomer(c);
	    o2.setCustomer(c);*/
	    c.getOrder().add(o1);
	    c.getOrder().add(o2); 
	    session.save(c);
	   /* session.save(o1);
	    session.save(o2);*/
	     
	    session.beginTransaction().commit();
	    session.close(); 
	}
	
	/*
	 *  1����Customer��inverse����Ϊfalseʱ��Customerά����ϵ����ɾ���û���Ϣʱ���Զ����ö�����
	 *  cidֵΪ�ա�
	 *  2����Customer��inverse����Ϊtrueʱ��Customer����ά����ϵ����ɾ���û���Ϣʱ���ᱨ��
	 */
	@Test
	public void onetToMany1(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = (Customer) session.get(Customer.class, 4);
		session.delete(c);
		session.beginTransaction().commit();
		session.close(); 
	}
	
	/*
	 * �ֶ�ɾ��
	 * ��ɾ���û���Ϣʱ���Ȳ��Ҷ�����Ϣ������и��û�����Ϣ��Ӧ��ɾ��������Ϣ����ɾ���û���Ϣ
	 */
	@Test
	public void onetToMany2(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = (Customer) session.get(Customer.class, 4);
		Set<Order> order = c.getOrder();
		for(Order order2:order)
			order2.setCustomer(null);
		session.delete(c);
		session.beginTransaction().commit();
		session.close(); 
	}
	
	/*
	 * ����ɾ��
	 * 1.Customer��inverse����Ϊtrue��cascade����Ϊdelete
	 * ��ɾ���û���Ϣʱ������ɾ����������Ӧ��Ϣ
	 */
	@Test
	public void onetToMany3(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = (Customer) session.get(Customer.class, 4);
		session.delete(c);
		session.beginTransaction().commit();
		session.close(); 
	}
	
	/*
	 *  ��������
	 */
	@Test
	public void onetToMany4(){
		Session session = HibernateUtilTest.getopenSession();
		Customer c = (Customer) session.get(Customer.class, 5);
		Set<Order> order = c.getOrder();
		for(Order order2:order)
			order2.setName("uuu");
		session.beginTransaction().commit();
		session.close(); 
	}
	
}
