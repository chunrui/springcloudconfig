package en.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import en.edu.lingnan.Dao.UserInformationDAO;

public class UserIdCheckServlet extends HttpServlet {
	protected void doPost (HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String userid=req.getParameter("userid");
		System.out.println("userid:   "+userid);
		UserInformationDAO udao=new UserInformationDAO();
		boolean flag = udao.FindAUserInfo1(userid);
		if(flag){
			resp.getWriter().print("true"); //��trueֵ���ظ�ҳ��register.html
		}
	}

}
