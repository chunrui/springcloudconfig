package com.hibernate.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtilTest {
	private static SessionFactory f;
	/*static ��̬�飺ִֻ��һ��
	ִ�е�ʱ�䣺
	1�������
	2����̬��������ʱ*/
	static{
		//���������ļ���ú������ö���
		Configuration con = new Configuration().configure();
		//��ù��� SessionFactory���൱�����ӳ�
		f = con.buildSessionFactory();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){
			public void run(){
				System.out.println("jvm��������عر�");
				f.close();
			}
		}));	
	}
	/*��ȡȫ������*/
	public static Session getopenSession(){
		//��ûỰsession���൱������Connection
		Session session = f.openSession();
		return session;
	}
	
   /*��ȡ��ǰ����*/
	public static Session getCurrentSession(){
		Session session = f.getCurrentSession();
		return session;
	}
	public static void main(String[] args) {
		System.out.println(HibernateUtilTest.getCurrentSession());
	}
}
