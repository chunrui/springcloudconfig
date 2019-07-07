package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import en.edu.lingnan.Dto.teacherInformationDTO;
import en.edu.lingnan.util.DataAccess;


public class TeacherInformationDAO1 {
	//��ȫ��
		public Vector<teacherInformationDTO> findAllTeachInfo() {
			Vector<teacherInformationDTO> v=new Vector<teacherInformationDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//����SQL������ִ��
					String sql="select * from TeacherInformation where TIflag=1";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //��������
						teacherInformationDTO t=new teacherInformationDTO();
						t.setTeacherID(rs.getString("TeacherID"));
						t.setTeacherName(rs.getString("TeacherName"));
						t.setTeacherSex(rs.getString("TeacherSex"));
						t.setTeacherTel(rs.getString("TeacherTel"));
						t.setTIflag(rs.getInt("TIflag"));
						t.setTeacherAge(rs.getInt("TeacherAge"));
						v.add(t);
					}	
			} catch (SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
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


//��ID��
	public Vector<teacherInformationDTO> findATeaInfoByID(String _TeacherID) {
		Vector<teacherInformationDTO> v=new Vector<teacherInformationDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;		
		try {
				conn=DataAccess.getConnection();
				stat=conn.createStatement();//����SQL������ִ��
				String sql="select * from TeacherInformation where TIflag=1 and TeacherID='"+_TeacherID+"'";
				rs=stat.executeQuery(sql);
				while(rs.next()){ //��������
					teacherInformationDTO t=new teacherInformationDTO();
					t.setTeacherID(rs.getString("TeacherID"));
					t.setTeacherName(rs.getString("TeacherName"));
					t.setTeacherSex(rs.getString("TeacherSex"));
					t.setTeacherTel(rs.getString("TeacherTel"));
					t.setTIflag(rs.getInt("TIflag"));
					t.setTeacherAge(rs.getInt("TeacherAge"));
					v.add(t);
				}	
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
	//��ID�飬���ز���ֵ
		public boolean FindATeachInfoByID(String _TeacherID){
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;	
			Statement stat=null;
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//����SQL������ִ��
					String sql="select * from TeacherInformation where TIflag=1 and TeacherID='"+_TeacherID+"'";
					rs=stat.executeQuery(sql);
					
					conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					
//					prep=conn.prepareStatement//Ԥ����(preparedStatement)�ӿ�
//							("select * from StudentInformation where SIflag=1 and StudentID='"+_StudentID+"'");
//					rs=prep.executeQuery();//����֮��Ľ������һ�������rs��Ȼ����Ҫ�ѽ������Ķ���ȡ������ֻ���жϽ�������Ƿ��м�¼����
			        if(rs.first())//���rs�����������ж�������ô��һ��һ���ж���
			        	flag=true;
			} catch (SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally{
					try {
						if(rs!=null){
							rs.close();
							rs=null;
						}
						if(prep!=null){
						   prep.close();
						   prep=null;
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
//��
		public boolean updateTeachInfo(teacherInformationDTO tdto) {
			boolean flag1=false;	
			String tid=tdto.getTeacherID();
			String tname=tdto.getTeacherName();
			String tsex=tdto.getTeacherSex();
			String ttel=tdto.getTeacherTel();
			int tage=tdto.getTeacherAge();
			int tflag=1;
			String sql="update TeacherInformation set TeacherName='"+tname+"',TeacherSex='"+tsex+"',TeacherTel='"+ttel+"',TeacherAge='"+tage+"',TIflag='"+tflag+"' where TeacherID='"+tid+"'";
			Connection conn=null;
			Statement stat=null;	
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//����SQL������ִ��
					stat.executeUpdate(sql);
					flag1=true;
					
			} catch (SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
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
			return flag1;
		}


		
		
}