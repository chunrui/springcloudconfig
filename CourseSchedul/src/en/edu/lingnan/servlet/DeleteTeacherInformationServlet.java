package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.teacherInformationDAO;
import en.edu.lingnan.Dto.teacherInformationDTO;
public class DeleteTeacherInformationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherID = req.getParameter("TeacherID");
	
		int n = JOptionPane.showConfirmDialog(null, "确认删除吗?", "提示", JOptionPane.YES_NO_OPTION);   
		if (n == JOptionPane.YES_OPTION) { 
			teacherInformationDAO sd = new teacherInformationDAO();
			boolean flag = sd.deleteTeacherInformationByID(TeacherID);
			if(flag)
			{
			Vector<teacherInformationDTO> v = new Vector<teacherInformationDTO>();
			v = sd.findTeacherInformation();
			HttpSession s = req.getSession();
			s.setAttribute("TeacherUser", v);
		    JOptionPane.showMessageDialog(new JFrame(),"删除成功！");
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(),"删除失败！");
			}
		} 
		else if (n == JOptionPane.NO_OPTION) {   
		    JOptionPane.showMessageDialog(new JFrame(),"已取消");  
		}  		
		resp.sendRedirect("findTeacherInformationServlet");
	}
	
}
