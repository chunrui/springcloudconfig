
package en.edu.lingnan.servlet;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.UserDao;
import en.edu.lingnan.Dto.UserDto;


public class loginservlet extends HttpServlet {
	public void init() throws ServletException{
		
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1����ҳ���ȡ������Ҫ������
		Vector<UserDto> v1 = new Vector<UserDto> ();
		String user = null;
		String password = null;
		user = req.getParameter("Auser");
		password = req.getParameter("Apassword");
		//2�����Ժ�̨ҵ���߼�ȥ�ж�����û��������Ƿ�����Ҷ���Ӧ
		UserDao a = new UserDao();
		String supervalue = a.LoginUserInfo(user,password);
		HttpSession s = req.getSession();
		v1 = a.finduserinfor(user,password);
		s.setAttribute("userinfo",v1 );
		s.setAttribute("supervalue", supervalue);
	    System.out.print(supervalue);
	    
		//3�����ݽ��ȥ��Ӧҳ��
		if(supervalue == null)
		{
			JOptionPane.showMessageDialog(null, "�������˺Ż������������������룡", "��ʾ", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/index.html");
		}
		else if(supervalue != null)
		{
			s.setAttribute("user", user);
			
			s.setAttribute("password", password);
		    if(supervalue.equals("1")||supervalue.equals("2")){
			if(supervalue.equals("1"))
			{
			resp.sendRedirect(req.getContextPath()+"/admin/admin_page.html");
			}
			else {
				UserDto td = new UserDto();
				Vector<UserDto> v = new Vector<UserDto> ();
				td.setAuser(user);
				td.setApassword(password);
			    //td.setAsuperuser(password);
				a.UpdateUserInfo(td);    //�����޸ĺ���
				//v=a.findalluserInfo();
				v= a.finduserinfor(user, password);
				HttpSession t = req.getSession();
				t.setAttribute("pwd", v);
				//resp.sendRedirect("updateUserpwd.jsp");
			resp.sendRedirect(req.getContextPath()+"/person_mian.html");
			}
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
		}
		
		
	}
		
}