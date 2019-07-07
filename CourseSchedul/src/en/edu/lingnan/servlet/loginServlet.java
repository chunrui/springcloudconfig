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


public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1����ҳ���ȡ������Ҫ������
		String userid = req.getParameter("UserID");
		String password = req.getParameter("UserPsw");
		//2�����Ժ�̨ҵ���߼�ȥ�ж�����û��������Ƿ�����Ҷ���Ӧ
		UserDao a = new UserDao();
		String supervalue = a.LoginUserInfo(userid,password);
		HttpSession s = req.getSession();
		
		s.setAttribute("supervalue", supervalue);
		s.setAttribute("user", userid);
	    System.out.print("============"+supervalue);
		//3�����ݽ��ȥ��Ӧҳ��
	    if(supervalue == null)
		{
			JOptionPane.showMessageDialog(null, "�������˺Ż������������������룡", "��ʾ", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/login.html");
		}
		else if(supervalue != null)
		{
			
			s.setAttribute("password", password);
		    if(supervalue.trim().equals("1")||supervalue.trim().equals("2")||supervalue.trim().equals("3"))
		    {
			if(supervalue.trim().equals("1"))
			{
			resp.sendRedirect(req.getContextPath()+"/admin/index.jsp");
			}
			else {
//				UserDto td = new UserDto();
//				Vector<UserDto> v = new Vector<UserDto> ();
//				td.setUserId(user);
//				td.setPassword(password);
//				a.UpdateUserInfo(td);    //�����޸ĺ���
//				//v=a.findalluserInfo();
//				v= a.finduserinfor(user, password);
//				HttpSession t = req.getSession();
//				t.setAttribute("pwd", v);
//				//resp.sendRedirect("updateUserpwd.jsp");
//			resp.sendRedirect(req.getContextPath()+"/person_mian.html");
				if(supervalue.trim().equals("2"))
				{
					resp.sendRedirect(req.getContextPath()+"/teacher/ok.jsp?userid="+userid+"");
				}
				else if(supervalue.trim().equals("3"))
				{					
					resp.sendRedirect(req.getContextPath()+"/student/student.jsp?userid="+userid+"");
				}
			}
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
		}
		
	}
		
}