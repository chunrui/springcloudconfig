package en.edu.lingnan.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;
import java.sql.PreparedStatement;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.xpath.internal.operations.And;

import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.ClassDto;
import en.edu.lingnan.Dto.UserDto;
import en.edu.lingnan.util.DataAccess;

public class UserDao  {
	//��ѯ��Ϣ�����û���Ϣ
	public Vector<UserDto> findalluserInfo()
	{
		Vector<UserDto> v = new Vector<UserDto> ();
		Connection conn = null;
	    Statement stmt = null;
	    PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from user where Aflag = 1");
			 while (rs.next())
			 {
				 UserDto a = new  UserDto();
				 a.setAid(rs.getString(1));
				 a.setAuser(rs.getString(2));
				 a.setApassword(rs.getString(3));
				 a.setAsuperuser(rs.getString(4));
				 v.add(a);
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

	
	//����id�Ų�ѯ�û���Ϣ
		public Vector<UserDto> finduserInfoByid(String aid)
		{
			Vector<UserDto> v = new Vector<UserDto> ();
			Connection conn = null;
		    Statement stmt = null;
		    PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from user where Aid='"+aid+"' and Aflag = 1");
				 while (rs.next())
				 {
					 UserDto a = new  UserDto();
					 a.setAid(rs.getString(1));
					 a.setAuser(rs.getString(2));
					 a.setApassword(rs.getString(3));
					 a.setAsuperuser(rs.getString(4));
					 v.add(a);
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
		
		
		//�����˺������ѯ�û�id��
		public Vector<UserDto> finduserinfor(String user,String password)
		{
			Vector<UserDto> v = new Vector<UserDto> ();
			Connection conn = null;
		    Statement stmt = null;
		    PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from user where Auser='"+user+"' and Apassword='"+password+"' and Aflag = 1");
				 while (rs.next())
				 {
					 UserDto a = new  UserDto();
					 a.setAid(rs.getString(1));
					 a.setAuser(rs.getString(2));
					 a.setApassword(rs.getString(3));
					 a.setAsuperuser(rs.getString(4));
					 v.add(a);
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
		
//����id���Ƿ����
		    public boolean finduserId_in(String aid)
			   	{
					Vector<UserDto> v = new Vector<UserDto> ();
					Connection conn = null;
				    Statement stmt = null;
				    PreparedStatement prep = null;
					ResultSet rs = null;
					boolean flag = false;
					try {
						 conn=DataAccess.getConnection();
						 stmt = conn.createStatement();
						 rs = stmt.executeQuery("select * from user where Aid='"+aid+"' and Aflag = 1");
						 while (rs.next())
						 {
							 flag = true;
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
				
		
//�����˺ţ�������Ҹ��û��Ƿ����
		public boolean ifusein(String user,String password)
		{
			Vector<UserDto> v = new Vector<UserDto> ();
			Connection conn = null;
		    Statement stmt = null;
		    PreparedStatement prep = null;
			ResultSet rs = null;
			boolean flag = false;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery("select * from user where Auser='"+user+"' and Apassword='"+password+"' and Aflag = 1");
				 while (rs.next())
				 {
					 UserDto a = new  UserDto();
					 a.setAid(rs.getString(1));
					 a.setAuser(rs.getString(2));
					 a.setApassword(rs.getString(3));
					 a.setAsuperuser(rs.getString(4));
					 v.add(a);
					 flag = true;
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
	
    //�û���ӡ�
	//��Ϣ���
		public boolean addUserInfo(UserDto adto)
		{
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			String user = adto.getAuser();
			String password = adto.getApassword();
			String id = adto.getAid();
			String superuser = adto.getAsuperuser();
			boolean flag = false;
			try {
				 conn=DataAccess.getConnection();
					stmt = conn.createStatement();
				    rs=stmt.executeQuery("select * from user where Aid='"+id+"'");
				    if(rs.next())
				    {
				    	String sql1 = "update user set Aflag =1 where Aid='"+id+"'";
						 stmt.executeUpdate(sql1);
				    }
				    else {
				    	String sql = "insert into user(Aid,Auser,Apassword,Asuperuser)"
								+ "values('"+id+"','"+user+"','"+password+"','"+superuser+"')";
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
		
		
		//�û���Ϣ�޸�
		public  boolean UpdateUserInfo(UserDto udto)
		{
			boolean flag2=false;
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			String aid= udto.getAid();
			String user = udto.getAuser(); 
			String password = udto.getApassword(); 
			String superuser = udto.getAsuperuser();
			
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				 String sql = "update user set Aid='"+aid+"',Auser='"+user+"',Apassword='"+password+"',Asuperuser='"+superuser+"' where Aid='"+aid+"' and Aflag =1";
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
		

	// �޸��˺ţ�����
		//�û���Ϣ�޸�
				public  boolean UpdateUserandpwd(String user,String pwd)
				{
					Vector<UserDto> v = new Vector<UserDto> ();
					boolean flag2=false;
					Connection conn = null;
				    PreparedStatement prep = null;
				    Statement stmt = null;
					ResultSet rs = null;
					UserDto udto = new UserDto();
					//String aid= udto.getAid();
				    user = udto.getAuser(); 
					pwd = udto.getApassword();
					v = finduserinfor(user,pwd);
					UserDto aid = v.elementAt(0);
				//	Vector<UserDto> aid =v;
					String superuser = "2";
					
					
					//String superuser = udto.getAsuperuser();
					try {
						 conn=DataAccess.getConnection();
						 stmt = conn.createStatement();
						 String sql = "update user set Aid='"+aid+"',Auser='"+user+"',Apassword='"+pwd+"',Asuperuser='"+superuser+"' where Aid='"+aid+"' and Aflag =1";
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
				
		
		
		
//�û���¼����
public String LoginUserInfo(String username,String password)
{
	Connection conn = null;
    Statement stmt = null;
    PreparedStatement prep = null;
	ResultSet rs = null;
	String str = null;
    try{ 
        if(!(username.equals("")||password.equals("")))
        {               
    		conn=DataAccess.getConnection();
			stmt = conn.createStatement();        
			String sql="select * from user where Auser='"+username+"' and Aflag = 1" ;       
            rs=stmt.executeQuery(sql);
            if(rs.next())
            {
        	 if(rs.getString("Apassword").equals(password))         
    	 {        
            str = rs.getString("Asuperuser");     
    	 }
            }
        	 else {
        		 str="No";
             	System.out.println("����������˺�����");
     		} 
            } 
            else
            {
            	str="No";
            	System.out.println("�����˺�Ϊ�գ�");
            }
        	 
        
    } 

    catch (SQLException e)
    {
        System.out.println("����SQL�����ִ���");
        e.printStackTrace();
     		}
     finally{
     			DataAccess.closeconn(conn, stmt, prep, rs);		
     	}

		return str;
}

//ɾ���û�
public boolean deleteUsersid(String aid) 
{
	Connection conn = null;
    PreparedStatement prep = null;
    Statement stmt = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	boolean flag = true;
	try {
		 conn=DataAccess.getConnection();
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery("select * from user where Aid='" + aid + "' and  Aflag = 1");
		 if(rs.next())
		 {
			 rs1 = stmt.executeQuery("select * from student where Sid='" + aid + "' and  Sflag = 1");
			 if(rs1.next())
			 {
				 String sql1 = "update student set Sflag= 0 where Sid='" + aid + "'";
				 stmt.executeUpdate(sql1);
				 
			 }
			 String sql = "update user set Aflag= 0 where Aid='" + aid + "'";
			 stmt.executeUpdate(sql);
			 flag=true;
			 
		 }
		 else {
			flag=false;
		}
	}catch (SQLException e) {
		System.out.println("����SQL�����ִ���");
		e.printStackTrace();
	}
	finally{
		try {
			if(rs1 != null)
			{
				rs1.close();
				rs1 = null;
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		DataAccess.closeconn(conn, stmt, prep, rs);
}
	return flag;
}

}
