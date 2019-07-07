package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import en.edu.lingnan.Dto.teacherCourseDTO;
import en.edu.lingnan.util.DataAccess;
public class teacherCourseDAO {
	//�������еĽ�ʦ�ڿ���Ϣ
	public Vector<teacherCourseDTO> findTeacherCourse() {
		Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();// ����SQL������ִ��
			String sql = "select * from TeacherCourse";
			rs = stat.executeQuery(sql);
			while (rs.next()) {// ��������
				teacherCourseDTO s = new teacherCourseDTO();
				s.setTeacherCourseID(rs.getString("TeacherCourseID"));
				s.setTeacherID(rs.getString("TeacherID"));
				s.setCourseID(rs.getString("CourseID"));
				s.setClassID(rs.getString("ClassID"));
				s.setWeekDay(rs.getString("WeekDay"));
				s.setClassTime(rs.getString("ClassTime"));
				s.setClassroomID(rs.getString("ClassroomID"));
				s.setTCflag(rs.getInt("TCflag"));
				v.add(s);
			}
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("�ر����ӡ���估������ǳ��ִ���");
				e.printStackTrace();
			}
		}
		return v;
	}
	
	public Vector<teacherCourseDTO> findTeacherCourseByID(String _TeacherCourseID) {
		Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();// ����SQL������ִ��
			String sql = "select * from TeacherCourse where TeacherCourseID = '"+_TeacherCourseID+"'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {// ��������
				teacherCourseDTO s = new teacherCourseDTO();
				s.setTeacherCourseID(rs.getString("TeacherCourseID"));
				s.setTeacherID(rs.getString("TeacherID"));
				s.setCourseID(rs.getString("CourseID"));
				s.setClassID(rs.getString("ClassID"));
				s.setWeekDay(rs.getString("WeekDay"));
				s.setClassTime(rs.getString("ClassTime"));
				s.setClassroomID(rs.getString("ClassroomID"));
				s.setTCflag(rs.getInt("TCflag"));
				v.add(s);
			}
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("�ر����ӡ���估������ǳ��ִ���");
				e.printStackTrace();
			}
		}
		return v;
	}
	
	//����TeacherCourseID�����ҽ�ʦ�ڿ���Ϣ
	public Vector<teacherCourseDTO> findTeacherCourseByteacherID(String _teacherID) {
		Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();// ����SQL������ִ��
			String sql = "select * from TeacherCourse where TeacherID= '"+_teacherID+"'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {// ��������
				teacherCourseDTO s = new teacherCourseDTO();
				s.setTeacherCourseID(rs.getString("TeacherCourseID"));
				s.setTeacherID(rs.getString("TeacherID"));
				s.setCourseID(rs.getString("CourseID"));
				s.setClassID(rs.getString("ClassID"));
				s.setWeekDay(rs.getString("WeekDay"));
				s.setClassTime(rs.getString("ClassTime"));
				s.setClassroomID(rs.getString("ClassroomID"));
				s.setTCflag(rs.getInt("TCflag"));
				v.add(s);
			}
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("�ر����ӡ���估������ǳ��ִ���");
				e.printStackTrace();
			}
		}
		return v;
	}

	// ���ӽ�ʦ�ڿ���Ϣ��Ԫ��
	public boolean addTeacherCourse(teacherCourseDTO sdto) {
		boolean flag = false;
		String TeacherCourseID = sdto.getTeacherCourseID();
		String TeacherID = sdto.getTeacherID();
		String CourseID = sdto.getCourseID();
		String ClassID = sdto.getClassID();
		String WeekDay = sdto.getWeekDay();
		String ClassTime = sdto.getClassTime();
		String ClassroomID = sdto.getClassroomID();
		int TCflag = sdto.getTCflag();
		System.out.println("������");
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		ResultSet rs5 = null;
		Connection conn=null;	
		conn=DataAccess.getConnection();
		try{
		conn=DataAccess.getConnection();
		stmt = conn.createStatement();
		//�����Ƿ����roomid������
		 rs = stmt.executeQuery("select * from TeacherCourse where TeacherCourseID='"+TeacherCourseID+"' and TCflag=1");
		if(rs.next())
		 {
			flag=false;
			 JOptionPane.showMessageDialog(null, "����ӵĽ�ʦ�ſα��Ѿ����ڣ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
			
		 }
		//û�оͽ������ݲ���MSflag
		else {
			rs1 = stmt.executeQuery("select * from TeacherInformation where TeacherID='"+TeacherID+"' and TIflag=1");
			if(rs1.next())
			{
				rs2 = stmt.executeQuery("select * from MajorSchedule where CourseID='"+CourseID+"' and MSflag=1");
				if(rs2.next())
				{
					rs3 = stmt.executeQuery("select * from ClassInformation where ClassID='"+ClassID+"' and CIflag=1");
					if(rs3.next())
					{
						rs4 = stmt.executeQuery("select * from ClassroomUse where ClassroomID='"+ClassroomID+"' and CUflag=1 and WeekDay='"+WeekDay+"' and  ClassTime='"+ClassTime+"'");
						if(rs4.next())
						{ 
							String state = rs4.getString(4);  //��ȡ����ʹ��״̬
							if(state=="����")
							{

								String sql1 = "insert into TeacherCourse values(TeacherCourseID,TeacherID,CourseID,ClassID,WeekDay,ClassTime,ClassroomID,TCflag)" + "('" + TeacherCourseID
										+ "','" + TeacherID + "','" + CourseID + "','" + ClassID
										+ "','" + WeekDay + "','" + ClassTime + "','" + ClassroomID + "','" + TCflag + "')";
								stmt.executeUpdate(sql1);
								flag = true;
							}
						}
					}
				}
			}
			else {
				flag = false;
			}
		}
				
		}
		catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
				e.printStackTrace();
			}finally{
				try {
					if(rs4!=null){
						rs4.close();
						rs4=null;
					}
					if(rs3!=null){
						rs3.close();
						rs3=null;
					}
					if(rs2!=null){
						rs2.close();
						rs2=null;
					}
					if(rs1!=null){
						rs1.close();
						rs1=null;
					}
					if(rs!=null){
						rs.close();
						rs=null;
					}
					if(stmt!=null){
					   stmt.close();
					   stmt=null;
					}
					if(conn!=null){
					   conn.close();
					   conn=null;
					}				
				} catch (SQLException e) {
					System.out.println("�ر����ӡ���估�����ʱ���ִ���");
					e.printStackTrace();
				}	
		}
		return flag;
	}

	// ɾ����ʦ��Ϣ��Ԫ��
	public boolean deleteTeacherCourseByID(String TeacherCourseID) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();// ����SQL������ִ��
			String sql1 = "delete from TeacherCourse where TeacherCourseID = '" + TeacherCourseID
					+ "'";
			System.out.println("��������");
//			String sql2 = "delete from TeacherInformation where staffID = '"
//					+ TeacherID + "'";
			stat.executeUpdate(sql1);
//			stat.executeUpdate(sql2);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("�ر����ӡ���估������ǳ��ִ���");
				e.printStackTrace();
			}
		}
		return flag;
	}

	 //���½�ʦ�ڿ���Ϣ��Ԫ��
	 public boolean updateTeacherCourse(teacherCourseDTO sdto) {
	 boolean flag = false;
	 	String TeacherCourseID = sdto.getTeacherCourseID();
		String TeacherID = sdto.getTeacherID();
		String CourseID = sdto.getCourseID();
		String ClassID = sdto.getClassID();
		String WeekDay = sdto.getWeekDay();
		String ClassTime = sdto.getClassTime();
		String ClassroomID = sdto.getClassroomID();
		int TCflag = sdto.getTCflag();
//	 String sql1 =
//		 "update ClassInformation set ClassID='"+ClassID+"'";
	 String sql2 =
	 "update TeacherCourse set TeacherID='"+TeacherID+"',CourseID='"+CourseID+"',"
	 		+ "ClassID='"+ClassID+"',WeekDay='"+WeekDay+"',ClassTime='"+ClassTime+"',"
	 		+ "ClassroomID='"+ClassroomID+"',TCflag='"+TCflag+"' where TeacherCourseID='"+TeacherCourseID+"'";
	 Connection conn = null;
	 Statement stat = null;
	 try {
	 conn = DataAccess.getConnection();
	 stat = conn.createStatement();//����SQL������ִ��
//	 stat.executeUpdate(sql1);
	 stat.executeUpdate(sql2);
	 flag = true;
	 } catch (SQLException e) {
	 System.out.println("teacherCourseDAO.updateTeacherCourse����SQL���ʱ���ִ���");
	 e.printStackTrace();
	 } finally{
	 try {
	 if(stat!=null){
	 stat.close();
	 stat=null;
	 }
	 if(conn!=null){
	 conn.close();
	 conn=null;
	 }
	 } catch (SQLException e) {
	 System.out.println("�ر����ӡ���估������ǳ��ִ���");
	 e.printStackTrace();
	 }
	 }
	 return flag;
	 }
	 
	 public Vector<teacherCourseDTO> findTeacherCourseByTname(String tname) {
			Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			String TeacherID1 = null;
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();// ����SQL������ִ��
				String sql1 = "select TeacherID from TeacherInformation where TeacherName = '"
						+ tname + "'";
				rs = stat.executeQuery(sql1);
				if (rs.next()) {
					TeacherID1 = rs.getString("TeacherID");
					System.out.print(TeacherID1);
					String sql = "select * from TeacherCourse where TeacherID= '"
							+ TeacherID1 + "'";
					rs1 = stat.executeQuery(sql);
					while (rs1.next()) {
						System.out.print(rs1.getString("TeacherCourseID"));
						teacherCourseDTO s = new teacherCourseDTO();
						s.setTeacherCourseID(rs1.getString("TeacherCourseID"));
						s.setTeacherID(rs1.getString("TeacherID"));
						s.setCourseID(rs1.getString("CourseID"));
						s.setClassID(rs1.getString("ClassID"));
						s.setWeekDay(rs1.getString("WeekDay"));
						s.setClassTime(rs1.getString("ClassTime"));
						s.setClassroomID(rs1.getString("ClassroomID"));
						s.setTCflag(rs1.getInt("TCflag"));
						v.add(s);
					}
				}
			} catch (SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
				e.printStackTrace();
			} finally {
				try {
					if (rs1 != null) {
						rs1.close();
						rs1 = null;
					}
					if (rs != null) {
						rs.close();
						rs = null;
					}
					if (stat != null) {
						stat.close();
						stat = null;
					}
					if (conn != null) {
						conn.close();
						conn = null;
					}
				} catch (SQLException e) {
					System.out.println("�ر����ӡ���估������ǳ��ִ���");
					e.printStackTrace();
				}
			}
			return v;
		}

		public Vector<teacherCourseDTO> findTeacherCourseByP1(String tname,
				String weekday, String classtime) {
			Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			String TeacherID1 = null;
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();// ����SQL������ִ��
				String sql1 = "select TeacherID from TeacherInformation where TeacherName = '"
						+ tname + "'";
				rs = stat.executeQuery(sql1);
				if (rs.next()) {
					TeacherID1 = rs.getString("TeacherID");
					System.out.print(TeacherID1);
					String sql = "select * from TeacherCourse where TeacherID= '"
							+ TeacherID1 + "' and Weekday='" + weekday
							+ "' and ClassTime='" + classtime + "'";
					rs1 = stat.executeQuery(sql);
					while (rs1.next()) {
						System.out.print(rs1.getString("TeacherCourseID"));
						teacherCourseDTO s = new teacherCourseDTO();
						s.setTeacherCourseID(rs1.getString("TeacherCourseID"));
						s.setTeacherID(rs1.getString("TeacherID"));
						s.setCourseID(rs1.getString("CourseID"));
						s.setClassID(rs1.getString("ClassID"));
						s.setWeekDay(rs1.getString("WeekDay"));
						s.setClassTime(rs1.getString("ClassTime"));
						s.setClassroomID(rs1.getString("ClassroomID"));
						s.setTCflag(rs1.getInt("TCflag"));
						v.add(s);
					}
				}
			} catch (SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
				e.printStackTrace();
			} finally {
				try {
					if (rs1 != null) {
						rs1.close();
						rs1 = null;
					}
					if (rs != null) {
						rs.close();
						rs = null;
					}
					if (stat != null) {
						stat.close();
						stat = null;
					}
					if (conn != null) {
						conn.close();
						conn = null;
					}
				} catch (SQLException e) {
					System.out.println("�ر����ӡ���估������ǳ��ִ���");
					e.printStackTrace();
				}
			}
			return v;
		}

}
