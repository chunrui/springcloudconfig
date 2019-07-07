package en.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import en.edu.lingnan.Dao.UserInformationDAO;
import en.edu.lingnan.Dto.UserInformationDTO;




public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//���е�servelt������������
		//1���ӿͻ��˽���ҳ�洫����������,������4��
		String userid=null;
		String username=null;
		String userpassword=null;
		String usersex=null;
		int userAuth=0;
		int flag=1;
		userid=req.getParameter("userid");
		//ʹ��ISO-8859-1�ַ�������,���ע��ʱ���Ĵ�����̨��������
		username=new String(req.getParameter("username").getBytes("ISO-8859-1"));
		userpassword=req.getParameter("userpassword");
		//ʹ��ISO-8859-1�ַ�������,���ע��ʱ���Ĵ�����̨��������
		usersex=new String(req.getParameter("usersex").getBytes("ISO-8859-1"));
		userAuth=Integer.parseInt(req.getParameter("userAuth"));
		//flag=Integer.parseInt(req.getParameter("flag"));
		System.out.println("1:"+userid+"  "+username+"  "+userpassword+"  "+usersex+"  "+userAuth+"  "+flag);
		
		//2���������ݣ����ú�̨��ҵ���߼�ȥ����DAO����÷�����
		UserInformationDAO udao=new UserInformationDAO();
		UserInformationDTO udto=new UserInformationDTO();
		udto.setUserID(userid);
		udto.setUserName(username);
		udto.setUserPsw(userpassword);
		udto.setUserSex(usersex);
		udto.setUserAuth(userAuth);
		udto.setUIflag(flag);
		boolean flag1 = udao.addUserInfo(udto);
		//3�����ݽ��ȥ����Ӧҳ��
			if(flag1)		
			resp.sendRedirect(req.getContextPath()+"/login.html");
			else
				resp.sendRedirect(req.getContextPath()+"/error.html");
	}

}
