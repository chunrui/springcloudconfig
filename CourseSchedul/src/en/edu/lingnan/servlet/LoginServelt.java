/*package en.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import en.edu.lingnan.Dao.UserInformationDAO;


public class LoginServelt extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
	throws ServletException,IOException{
		//���е�servelt������������
		//1���ӿͻ��˽���ҳ�洫����������
		String userid=null;
		String username=null;
		String password=null;
		userid=req.getParameter("userid");
		password=req.getParameter("password");
		System.out.println("1:"+userid+"  "+password);
		
		//2���������ݣ����ú�̨��ҵ���߼�ȥ�����ж�����û����������Ƿ�����Ҷ�Ӧ����DAO����÷�����
		UserInformationDAO udao=new UserInformationDAO();
		int superValue= udao.FindUserByIdAndPassword(userid, password);
//		Boolean flag= rdo.FINDReaderByIdAndPassword(userid, password);
			System.out.println("---2-----"+superValue);
//		System.out.println("---2-----"+flag);
			HttpSession s=req.getSession();
			s.setAttribute("superValue", superValue);
			s.setAttribute("userid", userid);
		//������Ĵ��������ص���Ӧҳ��
			if(superValue!=0)
			{
				if(superValue==2)
				{
					resp.sendRedirect(req.getContextPath()+"/teacher/ok.jsp?userid="+userid+"");
				}
				else if(superValue==3)
				{					
					resp.sendRedirect(req.getContextPath()+"/student/student.jsp?userid="+userid+"");
				}
			}						 	
			else 
				resp.sendRedirect(req.getContextPath()+"/error.html?userid="+userid+"");	
	}

}*/
