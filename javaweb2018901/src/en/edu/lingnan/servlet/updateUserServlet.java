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

public class updateUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html;charset=GB2312");
		String aid=new String(req.getParameter("aid").getBytes("ISO-8859-1"));
		String user=new String(req.getParameter("user").getBytes("ISO-8859-1"));
		String superuser = req.getParameter("superuser");
		String password = req.getParameter("password");
		//System.out.println(password);
		Vector<UserDto> v = new Vector<UserDto> ();
		UserDao ad = new  UserDao();
		UserDto td = new  UserDto();
		td.setAid(aid);
		System.out.println("======-----==="+aid);
		td.setAuser(user);
		td.setApassword(password);
		td.setAsuperuser(superuser);
		boolean flag=ad.UpdateUserInfo(td);    //�����޸ĺ���
		if(flag)
		{
		JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		v=ad.findalluserInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect("ShowAlluser.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/admin_page.html");
		}
		
	}

}
