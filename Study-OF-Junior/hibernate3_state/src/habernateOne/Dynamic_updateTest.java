package habernateOne;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.hibernate.Utils.HibernateUtilTest;

public class Dynamic_updateTest {
	@Test
	public void dynamic_updateTest() {
		
		 Session session = HibernateUtilTest.getopenSession();
	//-----------------------  insert into t_user values(1,'fsda','fdsa')
		 /*
		  * �־ò㣬ָ�����µ��û����
		  */
		 User user =  (User) session.get(User.class,3);
		 //user.setId(3);
		/* ˲ʱ̬*/
		/* User user1 = new User();
		 user1.setId(2);*/
		 user.setPassword("1232222");
		//user.setUsername("�����");
		session.update(user);
	   session.beginTransaction().commit();
}
}