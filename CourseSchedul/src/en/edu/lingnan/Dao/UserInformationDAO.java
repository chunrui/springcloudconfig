package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import en.edu.lingnan.Dto.UserDto;
import en.edu.lingnan.Dto.UserInformationDTO;
import en.edu.lingnan.util.DataAccess;



public class UserInformationDAO {
	//��ID�飬���ز���ֵ
	public boolean FindAUserInfo(String _TeacherID){
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
				
//				prep=conn.prepareStatement//Ԥ����(preparedStatement)�ӿ�
//						("select * from StudentInformation where SIflag=1 and StudentID='"+_StudentID+"'");
//				rs=prep.executeQuery();//����֮��Ľ������һ�������rs��Ȼ����Ҫ�ѽ������Ķ���ȡ������ֻ���жϽ�������Ƿ��м�¼����
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
	public int FindUserByIdAndPassword(String _uid,String _password){
		int superValue = 0;
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;	
		try {
				conn=DataAccess.getConnection();
				stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//����SQL������ִ��
				String sql="select * from UserInformation where Userid='"+_uid+"' and UserPsw='"+_password+"'";
				rs=stat.executeQuery(sql);
				
				//����֮��Ľ������һ�������rs��Ȼ����Ҫ�ѽ������Ķ���ȡ������ֻ���жϽ�������Ƿ��м�¼����
		        if(rs.first())//���rs�����������ж�������ô��һ��һ���ж���
		        {
//		        	superValue =Integer.parseInt(rs.getString("UserAuth"));
		        	superValue=Integer.parseInt(rs.getString("UserAuth").trim());
		        	System.out.println("------1-----"+superValue);
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
		return superValue;
	}
//��ȫ��
		public Vector<UserInformationDTO> findAllUserInfo() {
			Vector<UserInformationDTO> v=new Vector<UserInformationDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//����SQL������ִ��
					String sql="select * from UserInformation where Uflag=1";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //��������
						UserInformationDTO u=new UserInformationDTO();
						u.setUserID(rs.getString("UserID"));
						u.setUserName(rs.getString("UserName"));
						u.setUserSex(rs.getString("UserSex"));
						u.setUserPsw(rs.getString("UserPsw"));
						u.setUIflag(rs.getInt("Uflag"));
						u.setUserAuth(rs.getInt("UserAuth"));
						v.add(u);
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
//��id�ò��ң�����Ƿ����
		public boolean FindAUserInfo1(String _TeacherID){
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
	
	//��ID��
		public Vector<UserInformationDTO> FindAUserInfoByID(String _UserID) {
			Vector<UserInformationDTO> v=new Vector<UserInformationDTO>();
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;		
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//����SQL������ִ��
					String sql="select * from UserInformation where Uflag=1 and UserID='"+_UserID+"'";
					rs=stat.executeQuery(sql);
					while(rs.next()){ //��������
						UserInformationDTO u=new UserInformationDTO();
						u.setUserID(rs.getString("UserID"));
						u.setUserName(rs.getString("UserName"));
						u.setUserSex(rs.getString("UserSex"));
						u.setUserPsw(rs.getString("UserPsw"));
						u.setUserAuth(rs.getInt("UserAuth"));
						u.setUIflag(rs.getInt("Uflag"));
						v.add(u);
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
//��
		public boolean updateTeachInfo(UserInformationDTO udto) {
			boolean flag=false;
			String userid=udto.getUserID();
			String username=udto.getUserName();
			String usersex=udto.getUserSex();
			String userpsw=udto.getUserPsw();
			int userauth=udto.getUserAuth();
			int uflag=1;
			String sql="update UserInformation set UserID='"+userid+"',UserName='"+username+"',UserSex='"+usersex+"',UserPsw='"+userpsw+"',UserAuth='"+userauth+"',Uflag='"+uflag+"' where UserID='"+userid+"'";
			Connection conn=null;
			Statement stat=null;	
			try {
					conn=DataAccess.getConnection();
					stat=conn.createStatement();//����SQL������ִ��
					stat.executeUpdate(sql);
					flag=true;
					
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
			return flag;
		}


		//�û���ӡ�
		//��Ϣ���
			public boolean addUserInfo(UserInformationDTO udto)
			{
				Connection conn = null;
			    PreparedStatement prep = null;
			    Statement stmt = null;
				ResultSet rs = null;
				String userid=udto.getUserID();
				String username=udto.getUserName();
				String usersex=udto.getUserSex();
				String userpsw=udto.getUserPsw();
				int userauth=udto.getUserAuth();
				int uflag=1;
				boolean flag = false;
				try {
					 conn=DataAccess.getConnection();
						stmt = conn.createStatement();
					    rs=stmt.executeQuery("select * from UserInformation where UserID ='"+userid+"'");
					    if(rs.next())
					    {
					    	String sql1 = "update UserInformation set Uflag =1 where UserID='"+userid+"'";
							 stmt.executeUpdate(sql1);
					    }
					    else {
					    	String sql = "insert into UserInformation(UserId,UserName,UserSex,UserPsw,UserAuth)"
									+ "values('"+userid+"','"+username+"','"+usersex+"','"+userpsw+"','"+userauth+"')";
							stmt.executeUpdate(sql);
						}
						flag = true;
						System.out.println("����ɹ�������");
				}catch (SQLException e) {
					System.out.println("����SQL�����ִ���");
					e.printStackTrace();
				}
				finally{
					DataAccess.closeconn(conn, stmt, prep, rs);
			}
				return flag;
			}

}
