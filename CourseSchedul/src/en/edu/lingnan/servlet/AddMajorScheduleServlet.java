package en.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import en.edu.lingnan.Dao.MajorScheduleDAO;
import en.edu.lingnan.Dto.MajorScheduleDTO;


public class AddMajorScheduleServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String CourseID=req.getParameter("CourseID"); 
		String MajorID= req.getParameter("MajorID");
		
		System.out.println("heyhey"+CourseID);
		String EveryWeekCourseTime1=req.getParameter(" EveryWeekCourseTime");
		int  EveryWeekCourseTime = Integer.parseInt( EveryWeekCourseTime1);
		String CourseName=new String(req.getParameter("CourseName").getBytes("ISO-8859-1"));
		String CourseTime=new String(req.getParameter("CourseTime").getBytes("ISO-8859-1"));
		String YearTime=new String(req.getParameter("YearTime").getBytes("ISO-8859-1"));
		String TermTime=new String(req.getParameter("TermTime").getBytes("ISO-8859-1"));
		String ClassroomType=new String(req.getParameter("ClassroomType").getBytes("ISO-8859-1"));
		System.out.println( 666+CourseID+"   "+MajorID+"   "+CourseName+"    "+CourseTime+"   "+YearTime+"    ");
		MajorScheduleDTO mdto = new MajorScheduleDTO();
		MajorScheduleDAO mdao = new MajorScheduleDAO();
		mdto.setCourseID(CourseID);
		mdto.setMajorID(MajorID);
		mdto.setCourseName(CourseName);
		mdto.setCourseTime(CourseTime);
		mdto.setYearTime(YearTime);
		mdto.setTermTime(TermTime);
		mdto.setTermTime(ClassroomType);
		mdto.setEveryWeekCourseTime(EveryWeekCourseTime);
		//���ú���������
		boolean flag=mdao.InsertMajorSchedule(mdto);
		System.out.println(flag);
		 //���ȷ���޸�֮���ֻص�չʾ�����鼮��Ϣ��ҳ��
		if(flag)
		{
			JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);	
		Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
		v=mdao.findAllMajorSchedule();
		HttpSession s = req.getSession();
		s.setAttribute("allMajorSchedule", v);
//		s.setAttribute("userid", userid);
		resp.sendRedirect("MajorScheduleList.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "���ʧ�ܣ���鿴�����Ϣ�Ƿ���ȷ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/admin/index.html");
		}
	}

}
