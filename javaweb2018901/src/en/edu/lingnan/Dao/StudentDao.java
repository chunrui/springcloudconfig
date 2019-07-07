package en.edu.lingnan.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;
import java.sql.PreparedStatement;
import en.edu.lingnan.Dto.StudentDto;
import en.edu.lingnan.util.DataAccess;


public class StudentDao {

	//��ѯ ѧ����¼��Ϣ
	public Vector<StudentDto> findallStudentInfo()
	{
		Vector<StudentDto> v = new Vector<StudentDto> ();
		Connection conn = null;
	    Statement stmt = null;
	    PreparedStatement prep = null;
		ResultSet rs = null;
		
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from student where Sflag = 1");
			 while (rs.next())
			 {
				 StudentDto s = new  StudentDto();
				 s.setSid(rs.getString(1));
				 s.setStudentname(rs.getString(2));
				 s.setStudentage(rs.getString(3));
				 s.setStudentsex(rs.getString(4));
				 s.setStudentclass(rs.getString(5));;
				 s.setStudentdep(rs.getString(6));
				 v.add(s);
				 
			 }
			
			 
		}catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stmt, prep, rs);		
	}
	
		return v;
	}

	//��ѯѧ��id������Ϣ
		public Vector<StudentDto> findStudentByid(String sid)
		{
			Vector<StudentDto> v = new Vector<StudentDto> ();
			Connection conn = null;
		    Statement stmt = null;
		    PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from student where Sflag = 1 and Sid='"+sid+"'");
				 while (rs.next())
				 {
					 StudentDto s = new  StudentDto();
					 s.setSid(rs.getString(1));
					 s.setStudentname(rs.getString(2));
					 s.setStudentage(rs.getString(3));
					 s.setStudentsex(rs.getString(4));
					 s.setStudentclass(rs.getString(5));;
					 s.setStudentdep(rs.getString(6));
					 v.add(s);
				 }
				 
			}catch (SQLException e) {
				System.out.println("����SQL�����ִ���");
				e.printStackTrace();
			}
			finally{
				DataAccess.closeconn(conn, stmt, prep, rs);		
		}
		
			return v;
		}
		
//		//��������ѧ�����������Ϣ����
//		public Vector<StudentDto> findStudentByone(String one)
//		{
//			Vector<StudentDto> v = new Vector<StudentDto> ();
//			Connection conn = null;
//		    Statement stmt = null;
//		    PreparedStatement prep = null;
//			ResultSet rs = null;
//			ResultSet rs1 = null;
//			ResultSet rs2 = null;
//			ResultSet rs3 = null;
//			ResultSet rs4 = null;
//			ResultSet rs5 = null;
//			boolean flag=false;
//			try {
//				 conn=DataAccess.getConnection();
//				 stmt = conn.createStatement();
//				 if(flag==false)
//				 {
//					 rs = stmt.executeQuery("select * from student where  Sflag = 1 and Sid='"+one+"'");
//				 while (rs.next())
//				 {
//					 StudentDto s = new  StudentDto();
//					 s.setSid(rs.getString(1));
//					 s.setStudentname(rs.getString(2));
//					 s.setStudentage(rs.getString(3));
//					 s.setStudentsex(rs.getString(4));
//					 s.setStudentclass(rs.getString(5));;
//					 s.setStudentdep(rs.getString(6));
//					 v.add(s);
//					 flag=true;
//				 }
//				 }
//				 else if(flag==false)
//				{
//				 rs1 = stmt.executeQuery("select * from student where Sflag = 1 and Sname='"+one+"'");
//				 while (rs1.next())
//				 {
//					 StudentDto s = new  StudentDto();
//					 s.setSid(rs.getString(1));
//					 s.setStudentname(rs.getString(2));
//					 s.setStudentage(rs.getString(3));
//					 s.setStudentsex(rs.getString(4));
//					 s.setStudentclass(rs.getString(5));;
//					 s.setStudentdep(rs.getString(6));
//					 v.add(s);
//					 flag=true;
//				 }
//				}

				 
//				 if(flag==false)
//				 {
//					 JOptionPane.showMessageDialog(null, "�����������Ϣ�������������룡", "��ʾ", JOptionPane.ERROR_MESSAGE); 
//				 }
//				 else{
//					 JOptionPane.showMessageDialog(null, "���ҳɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
//				 }
	
		
  //ɾ��
	public boolean deleteStudentid(String sid)
	{
		boolean flag=false;
		Connection conn = null;
	    Statement stmt = null;
	    PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from student where Sid='"+sid+"' and Sflag = 1" );
			 if(rs.next())
			 {
				 String sql1 = "update user set Aflag= 0 where Aid='"+sid+"'";
				 stmt.executeUpdate(sql1);
				 String sql = "update student set Sflag= 0 where Sid='"+sid+"'";
				 stmt.executeUpdate(sql);
				 System.out.println("ɾ��ѧ���ɹ���");
			 }
			 flag=true;	
		}catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stmt, prep, rs);
	}
		return flag;
	}
	
	// ѧ����Ϣ���
	public boolean addStudentInfo(StudentDto sdto)
	{
		Connection conn = null;
	    PreparedStatement prep = null;
	    boolean flag = false;
	    Statement stmt = null;
		ResultSet rs = null;
		String sid= sdto.getSid();
		String name = sdto.getStudentname(); 
		String age = sdto.getStudentage();
		String sex = sdto.getStudentsex(); 
		String classid = sdto.getStudentclass();
		String dep = sdto.getStudentdep();
		try {
			conn=DataAccess.getConnection();
			stmt = conn.createStatement();
			//�����Ƿ����bid������
			 rs = stmt.executeQuery("select * from student where Sid='" + sid + "'");
			//û�оͽ������ݲ���
			if(rs.next())
			 {
				String sql = "update student set Sflag= 1 where Sid='" + sid + "'";
				stmt.executeUpdate(sql);
				System.out.println("ѧ������ɹ�!");
				flag=true;
			 } 
			
			else {
				ResultSet rs1 = stmt.executeQuery("select * from user where Aid='" + sid + "' and Aflag=1");
				if(rs1.next())
				{
			String sql = "insert into student(Sid,Sname,Sage,Ssex,Sclassid,Sdepartment) "
					+ "values('"+sid+"','"+name+"','"+age+"','"+sex+"','"+classid+"','"+dep+"')";
			stmt.executeUpdate(sql);
			System.out.println("ѧ������ɹ�!");
			flag=true;
				}
				else{
					flag=false;
					//JOptionPane.showMessageDialog(null, "ͼ������û�������,��������ӣ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		}catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stmt, prep, rs);
	}
		return flag;
	}
	
	//ѧ����Ϣ����
		public  boolean UndateStudentInfo(StudentDto sdto)
		{
			boolean flag2=false;
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			String sid= sdto.getSid();
			String sname = sdto.getStudentname(); 
			String sage = sdto.getStudentage();
			String sex = sdto.getStudentsex(); 
			String classid = sdto.getStudentclass();
			String dep = sdto.getStudentdep();
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 String sql = "update student set Sid='"+sid+"',Sage='"+sage+"',Sname='"+sname+"',Ssex='"+sex+"',Sclassid='"+classid+"',Sdepartment='"+dep+"' where Sid='"+sid+"' and Sflag =1";
				 stmt.executeUpdate(sql);
				 flag2=true;
			}catch (SQLException e) {
				System.out.println("����SQL�����ִ���");
				e.printStackTrace();
			}
			finally{
				DataAccess.closeconn(conn, stmt, prep, rs);
				
		}
			return flag2;
		}
}