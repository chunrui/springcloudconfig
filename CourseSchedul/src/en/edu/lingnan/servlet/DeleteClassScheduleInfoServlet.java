package en.edu.lingnan.servlet;
import en.edu.lingnan.Dao.ClassScheduleDAO;
import en.edu.lingnan.Dto.ClassScheduleDTO;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
public class DeleteClassScheduleInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ClassScheduleID=req.getParameter("ClassScheduleID");
		ClassScheduleDAO csdo = new ClassScheduleDAO();
		Vector<ClassScheduleDTO> v=new Vector<ClassScheduleDTO>();
		boolean flag= csdo.deleteClassScheduleByClassScheduleID(ClassScheduleID);
		if(flag)
		{
		
		JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		v = csdo.findAllClassScheduleInfo();
		HttpSession s=req.getSession();
		s.setAttribute("allClassScheduleInfo", v);
		resp.sendRedirect("FindClassSchedule1.jsp");
		
		}
		else{	
			JOptionPane.showMessageDialog(null, "ɾ��ʧ��,��鿴Լ��������", "��ʾ", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
			System.out.println("ɾ������");
		}
	}

}
