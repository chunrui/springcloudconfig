package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import en.edu.lingnan.Dto.Teacher_scheduleDTO;
import en.edu.lingnan.util.DataAccess;


public class Teacher_scheduleDAO {
	public Vector<Teacher_scheduleDTO> findTeacher_scheduleInfo() {   
		Vector<Teacher_scheduleDTO> v=new Vector<Teacher_scheduleDTO>();
		Connection conn=null;
		Statement stat=	null;
		ResultSet rs=null;
		try {		
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			String sql="select *from Teacher_schedule";
			rs=stat.executeQuery(sql);
			while(rs.next()){  //��������
				Teacher_scheduleDTO ts=new Teacher_scheduleDTO();
				ts.setTsno(rs.getString("Tsno"));
				ts.setTeacherID(rs.getString("TeacherID"));
				ts.setCourseID(rs.getString("CourseID"));
				v.add(ts);
			}	
		}  catch (SQLException e){
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs=null;
				}
				if(stat!=null){
					stat.close();
					stat=null;
				}
				if(conn!=null){
					conn.close();
					conn=null;
				}
			} catch(Exception e) {
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}	
		}
		return v;
	}

	//����ʦTeacherID����(��һ�ַ���)
	public boolean findTeacherID(String _tid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=	null;
		Statement stat=	null;
		ResultSet rs=null;
		try {		
			conn=DataAccess.getConnection();
			String s=null;
			prep=conn.prepareStatement
			("select *from Teacher_schedule where TeacherID=?");
			prep.setString(1, _tid);
			rs=prep.executeQuery();
			if(rs.first()){
				flag=true;
				System.out.println("Tsno"+"   "+"TeacherID"+"      "+"CourseID");
				System.out.println(rs.getString("Tsno")+"  "+rs.getString("TeacherID")+"      "+rs.getString("CourseID"));
			}
			else{
				flag=false;
				System.out.println("�����������ʦ��");
			}

		}  catch (SQLException e) {		
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(prep!=null){
					prep.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}	
		}
		return flag;
	}	

	//����ʦTeacherID����(�ڶ��ַ���)
	public Vector<Teacher_scheduleDTO> findTeacher_scheduleInfoById(String tid) {   
		Vector<Teacher_scheduleDTO> v=new Vector<Teacher_scheduleDTO>();
		Connection conn=null;
		Statement stat=	null;
		ResultSet rs=null;
		try {		
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			String sql="select *from Teacher_schedule where TeacherID= '"+tid+"'";
			rs=stat.executeQuery(sql);
			while(rs.next()){  //��������
				Teacher_scheduleDTO ts=new Teacher_scheduleDTO();
				ts.setTsno(rs.getString("Tsno"));
				ts.setTeacherID(rs.getString("TeacherID"));
				ts.setCourseID(rs.getString("CourseID"));
				v.add(ts);
			}	
		}  catch (SQLException e) {
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs=null;
				}
				if(stat!=null){
					stat.close();
					stat=null;
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
		return v;
	}

	//����ʦTeacherID����(�ڶ��ַ���)
		public Vector<Teacher_scheduleDTO> findTeacher_scheduleInfoByTsno(String tsid) {   
			Vector<Teacher_scheduleDTO> v=new Vector<Teacher_scheduleDTO>();
			Connection conn=null;
			Statement stat=	null;
			ResultSet rs=null;
			try {		
				conn=DataAccess.getConnection();
				stat=conn.createStatement();  //����sql������ִ��
				String sql="select *from Teacher_schedule where Tsno= '"+tsid+"'";
				rs=stat.executeQuery(sql);
				while(rs.next()){  //��������
					Teacher_scheduleDTO ts=new Teacher_scheduleDTO();
					ts.setTsno(rs.getString("Tsno"));
					ts.setTeacherID(rs.getString("TeacherID"));
					ts.setCourseID(rs.getString("CourseID"));
					v.add(ts);
				}	
			}  catch (SQLException e) {
				System.out.println("����sql���ʱ���ִ���");
				e.printStackTrace();
			}finally{
				try {
					if(rs!=null){
						rs.close();
						rs=null;
					}
					if(stat!=null){
						stat.close();
						stat=null;
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
			return v;
		}		
		//���οα���ɾ������
		public boolean deleteTeacher_scheduleByTsno(String tsid){    
			boolean flag=false;
			Connection conn=null;
			Statement stat=	null;
			try {	
				conn=DataAccess.getConnection();
				stat=conn.createStatement();  //����sql������ִ��
				String sql="delete from Teacher_schedule  where Tsno='"+tsid+"'";
				stat.executeUpdate(sql);
				flag=true;
			}  catch (SQLException e) {
				System.out.println("����sql���ʱ���ִ���");
				e.printStackTrace();
			}finally{
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
					System.out.println("�ر����ӡ���估�����ʱ���ִ���");
					e.printStackTrace();
				}	
			}		
			return flag;
		}		

	//����ʦ��ɾ������
	public boolean deleteTeacher_scheduleByTeacherID(String tid){    
		boolean flag=false;
		Connection conn=null;
		Statement stat=	null;
		try {	
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			String sql="delete from Teacher_schedule  where TeacherID='"+tid+"'";
			stat.executeUpdate(sql);
			flag=true;
		}  catch (SQLException e) {
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}	
		}		
		return flag;
	}	

	//-----------------���ʦ�οα��������--------------
	public boolean insertTeacher_scheduleInfo(Teacher_scheduleDTO tdto) {   
		boolean flag=false;
		String Tsno=tdto.getTsno();
		String TeacherID=tdto.getTeacherID();
		String CourseID=tdto.getCourseID();
		String sql="insert into Teacher_schedule values"
				+"('"+Tsno+"','"+TeacherID+"','"+CourseID+"')";
		Connection conn=null;
		Statement stat=	null;
		try {		
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			stat.executeUpdate(sql);
			flag=true;
		}  catch (SQLException e) {
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}	
		}
		return flag;
	}	
	//�޸Ľ�ʦ�οα�����
	public boolean updateTeacher_scheduleInfo(Teacher_scheduleDTO tdto) {   
		boolean flag=false;
		String Tsno=tdto.getTsno();
		String TeacherID=tdto.getTeacherID();
		String CourseID=tdto.getCourseID();
		String sql="update Teacher_schedule set TeacherID= '"+TeacherID+"',CourseID='"
		+CourseID+"'where Tsno='"+Tsno+"'";			
		Connection conn=null;
		Statement stat=	null;
		try {		
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			stat.executeUpdate(sql);
			flag=true;
		}  catch (SQLException e) {
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
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
				System.out.println("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}	
		}
		return flag;
	}
	
	
}
