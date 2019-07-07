package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import en.edu.lingnan.Dto.MajorInformationDTO;
import en.edu.lingnan.util.DataAccess;

public class MajorInformationDAO {
	//��ȫ��
		public Vector<MajorInformationDTO> findAllMajorInfo() {
			Vector<MajorInformationDTO> v=new Vector<MajorInformationDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//����SQL������ִ��
					String sql="select * from MajorInformation where MIflag=1";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //��������
						 MajorInformationDTO m=new  MajorInformationDTO();
						 m.setMajorID(rs.getString("MajorID"));
						 m.setMajorName(rs.getString("MajorName"));
						 m.setMIflag(rs.getInt("MIflag"));
						v.add(m);
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
		public boolean FindMajorInfoByID(String _MajorID){
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;	
			Statement stat=null;
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//����SQL������ִ��
					String sql="select * from MajorInformation where MIflag=1 and MajorID='"+_MajorID+"'";
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
		
		

}
