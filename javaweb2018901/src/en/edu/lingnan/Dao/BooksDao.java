package en.edu.lingnan.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;
import java.sql.PreparedStatement;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.UserDto;
import en.edu.lingnan.util.DataAccess;


public class BooksDao {

	//��ѯͼ����鼮��¼��Ϣ
	public Vector<BooksDto> findallBooksInfo()
	{
		Vector<BooksDto> v = new Vector<BooksDto> ();
		Connection conn = null;
	    Statement stmt = null;
	    PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from book where Bflag = 1");
			 while (rs.next())
			 {
				 BooksDto btdo = new BooksDto();
				 btdo.setBookId(rs.getString(1));
				 btdo.setBreference_number(rs.getString(2));
				 btdo.setBprice(rs.getDouble(3));
				 btdo.setBookName(rs.getString(4));
				 btdo.setBookauthor(rs.getString(5));
				 btdo.setBookstate(rs.getString(6));
				 btdo.setNum(rs.getInt(7));
				 v.add(btdo);
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
	
	//����id�Ų���
			public Vector<BooksDto>findBooksid(String bid)
			{
				Vector<BooksDto> v = new Vector<BooksDto> ();
				Connection conn = null;
			    PreparedStatement prep = null;
			    Statement stmt = null;
				ResultSet rs = null;
				try {
					 conn=DataAccess.getConnection();
					 stmt = conn.createStatement();
					 rs = stmt.executeQuery("select * from book where Bid='"+bid+"' and Bflag = 1");
					 while (rs.next())
					 {
						 BooksDto btdo = new BooksDto();
						 btdo.setBookId(rs.getString(1));
						 btdo.setBreference_number(rs.getString(2));
						 btdo.setBprice(rs.getDouble(3));
						 btdo.setBookName(rs.getString(4));
						 btdo.setBookauthor(rs.getString(5));
						 btdo.setBookstate(rs.getString(6));
						 btdo.setNum(rs.getInt(7));
						 v.add(btdo);
						 System.out.println("����ͼ��ɹ�����");
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
		
															
	
     //ͼ����Ϣɾ��
	public boolean deleteBooksid(String bid)
	{
		Connection conn = null;
	    PreparedStatement prep = null;
	    Statement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from book where Bid='" + bid + "' and  Bflag = 1");
			 if(rs.next())
			 {
				 String sql = "update book set Bflag= 0 where Bid='" + bid + "'";
				 stmt.executeUpdate(sql);
				 System.out.println("ɾ��ͼ��ɹ���");
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
	//���
	public boolean addBooksInfo(BooksDto bto)
	{
		Connection conn = null;
	    PreparedStatement prep = null;
	    Statement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		String bid = bto.getBookId();
		String name = bto.getBookName();
		String author = bto.getBookauthor();
		String  state = bto.getBookstate();
		Double price = bto.getBprice();
		int mun = bto.getNum();
		 
		String reference_number = bto.getBreference_number();
		try {
			 conn=DataAccess.getConnection();
				stmt = conn.createStatement();
				//�����Ƿ����bid������
				 rs = stmt.executeQuery("select * from book where Bid='" + bid + "'");
				if(rs.next())
				 {
					String sql = "update book set Bflag= 1 where Bid='" + bid + "'";
					stmt.executeUpdate(sql);
					System.out.println("����ͼ��ɹ�!");
					flag = true;
				 } 
				//û�оͽ������ݲ���
				else {
					
				String sql = "insert into book(Bid,Bname,Bauthor,Bstate,Bprice,Breference_number,Bmun)"
						+ "values('"+bid+"','"+name+"','"+author+"','"+state+"',"+price+",'"+reference_number+"',"+mun+")";
			    stmt.executeUpdate(sql);
			    System.out.println("����ͼ��ɹ�!");
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


		//ͼ����Ϣ����
		public boolean UpdateBooksInfo(BooksDto bto)
		{
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			boolean flag = false;
			String bid = bto.getBookId();
			String name = bto.getBookName();
			String author = bto.getBookauthor();
			String  state = bto.getBookstate();
			Double price = bto.getBprice();
			int mun = bto.getNum();
			String reference_number = bto.getBreference_number();
			try {
				    conn=DataAccess.getConnection();
				    stmt = conn.createStatement();                
				    String sql = "update book set Bid='"+bid+"',Bname='"+name+"',Bauthor='"+author+"',Bstate='"+state+"',Bprice="+price+",Breference_number='"+reference_number+"',Bmun="+mun+" where Bid='"+bid+"' and Bflag = 1";
				    stmt.executeUpdate(sql);
				    System.out.println("�޸ĳɹ�!");
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
}