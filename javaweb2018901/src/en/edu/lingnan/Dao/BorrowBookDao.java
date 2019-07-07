package en.edu.lingnan.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import en.edu.lingnan.Dto.BooksDto;
import en.edu.lingnan.Dto.BorrowBookDto;
import en.edu.lingnan.util.DataAccess;
public class BorrowBookDao {

	//��ѯͼ��ݽ�����Ϣ
	public Vector<BorrowBookDto> findallBorrowBookInfo()
	{
		Vector<BorrowBookDto> v = new Vector<BorrowBookDto> ();
		Connection conn = null;
	    Statement stmt = null;
	    PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from borrow_books where Bbflag = 1");
			 while (rs.next())
			 {
				 BorrowBookDto  bb = new  BorrowBookDto();
				 bb.setBbid(rs.getString(1));
				 bb.setBcid(rs.getString(2));
				 bb.setBorrowtime(rs.getString(3));
				 bb.setBduetime(rs.getString(4));
				 bb.setBreturntime(rs.getString(5));
				 bb.setBfine(rs.getInt(6));
				 bb.setBreturnstate(rs.getString(7));
				 bb.setBmun(rs.getInt(8));
				 v.add(bb);	
				 v.add(bb);
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
	
	//����ͼ��id������id�Ų���
	      public Vector<BorrowBookDto> findaBorrowBookByid(String bbid,String bsid)
	         {
		       Vector<BorrowBookDto> v = new Vector<BorrowBookDto> ();
				Connection conn = null;
			    PreparedStatement prep = null;
			    Statement stmt = null;
				ResultSet rs = null;
				try {
					 conn=DataAccess.getConnection();
					 stmt = conn.createStatement();
					 String sql = "select * from borrow_books where Bbid='"+bbid+"' and Bsid='"+bsid+"' and Bbflag = 1";
					 rs = stmt.executeQuery(sql);
					 while (rs.next())
					 {
                         BorrowBookDto  bb = new  BorrowBookDto();
                         bb.setBbid(rs.getString(1));
        				 bb.setBcid(rs.getString(2));
        				 bb.setBorrowtime(rs.getString(3));
        				 bb.setBduetime(rs.getString(4));
        				 bb.setBreturntime(rs.getString(5));
        				 bb.setBfine(rs.getInt(6));
        				 bb.setBreturnstate(rs.getString(7));
        				 bb.setBmun(rs.getInt(8));
						 v.add(bb);	
						 System.out.println("���ҽ�����Ϣ�ɹ�����");
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
	      
	      
	    //���ݶ���id�Ų���
	      public Vector<BorrowBookDto> findaBorrowBookBysid(String bsid)
	         {
		       Vector<BorrowBookDto> v = new Vector<BorrowBookDto> ();
				Connection conn = null;
			    PreparedStatement prep = null;
			    Statement stmt = null;
				ResultSet rs = null;
				try {
					 conn=DataAccess.getConnection();
					 stmt = conn.createStatement();
					 String sql = "select * from borrow_books where Bsid='"+bsid+"' and Bbflag = 1";
					 rs = stmt.executeQuery(sql);
					 while (rs.next())
					 {
                         BorrowBookDto  bb = new  BorrowBookDto();
                         bb.setBbid(rs.getString(1));
        				 bb.setBcid(rs.getString(2));
        				 bb.setBorrowtime(rs.getString(3));
        				 bb.setBduetime(rs.getString(4));
        				 bb.setBreturntime(rs.getString(5));
        				 bb.setBfine(rs.getInt(6));
        				 bb.setBreturnstate(rs.getString(7));
        				 bb.setBmun(rs.getInt(8));
						 v.add(bb);	
						 System.out.println("���ҽ�����Ϣ�ɹ�����");
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
		
					
		
															
	
     //����
	public boolean deleteBorrowBooksByid(String bbid,String bsid)
	{
		Connection conn = null;
	    PreparedStatement prep = null;
	    Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		boolean flag =false;
		ResultSet rs3 = null;
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 int allnum=100;
			 int num=100;
//			String sql3="select count(*) as num from borrow_books where Bbid='"+bbid+"' and Bbflag = 1";
//			rs=stmt.executeQuery(sql3);
//			rs.next();
//			//���ֻ��һ���˽�
//			if(rs.getInt("num")==1)
//			{
//		     String sql = "update borrow_books set Bbflag= 0 where Bbid='"+bbid+"' and Bsid='"+bsid+"'";
//		     stmt.executeUpdate(sql);
//		     System.out.println("ɾ��ͼ��ɹ���������........");
//			 rs1 = stmt.executeQuery("select * from book where Bid='"+bbid+"' and  Bflag = 1");
//			 if(rs1.next())
//			 {
//				 String sql5 = "update book set Bflag= 0 where Bid='"+bbid+"'";
//				 stmt.executeUpdate(sql5);
//			 }		
//			 rs2 = stmt.executeQuery("select * from student where Sid='"+bbid+"' and  Sflag = 1");
//			 if(rs2.next())
//			 {
//				 String sql4 = "update student set Sflag= 0 where Sid='"+bbid+"'";
//				 stmt.executeUpdate(sql4);
//			 }
//			 flag = true;
//			}
//			//���˽�
//			else {
			 String sql3="select * from borrow_books where Bbid='"+bbid+"' and Bsid='"+bsid+"' and Bbflag = 1";
			 rs = stmt.executeQuery(sql3);
			 if(rs.next())
			 {
				 num=rs.getInt(8);
			 }
			 rs1 = stmt.executeQuery("select * from book where Bid='"+bbid+"' and  Bflag = 1");
			 if(rs1.next())
			 {
				 allnum=rs1.getInt(7);
			 }
			     allnum=num+allnum;
			     String sql4 = "update book set Bmun="+allnum+" where Bid='"+bbid+"' and Bflag=1";
			     stmt.executeUpdate(sql4);
				 String sql = "delete from borrow_books  where Bbid='"+bbid+"' and Bsid='"+bsid+"'";
				 stmt.executeUpdate(sql);
				 System.out.println("�黹ͼ��ɹ���");
				 flag = true;
			//}
		
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
				if(rs2 != null)
				{
					rs2.close();
					rs2 = null;
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			DataAccess.closeconn(conn, stmt, prep, rs);
		}
		return flag;
	}
	

	
	// ѧ�����飨allnum��ͼ����������
	public boolean addBorrowBooks_Student(BorrowBookDto bbdto)
	{
		Connection conn = null;
	    PreparedStatement prep = null;
	    Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		boolean flag = false;
		String bbid = bbdto.getBbid();
		String bsid = bbdto.getBcid();
		String borrowtime = bbdto.getBorrowtime();
		String duetime = bbdto.getBduetime();
		String returntime = bbdto.getBreturntime();
		String returnstate = bbdto.getBreturnstate();
		double fine = bbdto.getBfine();
		int bmun = bbdto.getBmun();
		int  mun=100;
		
	//	String duetime = bbdto.getBduetime();
		try {
			 conn=DataAccess.getConnection();
			 stmt = conn.createStatement();
			 rs1 = stmt.executeQuery("select * from book where Bid='" + bbid + "' and Bflag=1");
			 if(rs1.next())
			 {
				  mun = rs1.getInt(7);
			 }
			 if(mun<bmun||bmun<=0)
			 {
				 flag=false;
			 }

		else {
					
		             String sql2 = "insert into borrow_books(Bbid,Bsid,Bborrowtime,Breturntime, Bduetime,Bbstate,Bfine,Bbmun)"
					+ "values('"+bbid+"','"+bsid+"','"+borrowtime+"','"+returntime+"','"+duetime+"','"+returnstate+"',"+fine+","+bmun+")";
		           stmt.executeUpdate(sql2);
				    System.out.println("���ͼ��2�ɹ�����");
				    mun = mun -bmun;
				    String sql4 = "update book set Bmun="+mun+" where Bid='"+bbid+"' and Bflag=1";
				    stmt.executeUpdate(sql4);
				    flag = true;
					}
		}catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			try{
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
	
	
	
	// ������Ϣ���
		public boolean addBorrowBooksInfo(BorrowBookDto bbdto)
		{
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			boolean flag = false;
			String bbid = bbdto.getBbid();
			String bsid = bbdto.getBcid();
			String borrowtime = bbdto.getBorrowtime();
			String returntime = bbdto.getBreturntime();
			String returnstate = bbdto.getBreturnstate();
			double fine = bbdto.getBfine();
			String duetime = bbdto.getBduetime();
			int bmun = bbdto.getBmun();
			int num=100;
			try {
				 conn=DataAccess.getConnection();
				 stmt = conn.createStatement();
				//�����Ƿ����bbid��bsid������
//				 rs = stmt.executeQuery("select * from borrow_books where Bbid='" + bbid + "' and Bsid='" + bsid + "'");
//				if(rs.next())   //�У�����־λ��Ϊ1
//				 {
//					String sql = "update borrow_books set Bbflag= 1 where Bbid='" + bbid + "' and Bsid='" + bsid + "'";
//					stmt.executeUpdate(sql);
//					System.out.println("����ͼ��1�ɹ�!");
//					flag = true;
//				 }
//				//û�оͽ������ݲ���
//				else {
					  rs1 = stmt.executeQuery("select * from book where Bid='" + bbid + "' and Bflag=1");
					if(rs1.next())
					{
						num = rs1.getInt(7);
						if(num<bmun)
						{
							flag=false;
						}
						else {
						rs2 = stmt.executeQuery("select * from student where Sid='" + bsid + "' and Sflag=1");
						if(rs2.next())
						{
							 String sql2 = "insert into borrow_books(Bbid,Bsid,Bborrowtime,Breturntime, Bduetime,Bbstate,Bfine,Bbmun)"
										+ "values('"+bbid+"','"+bsid+"','"+borrowtime+"','"+returntime+"','"+duetime+"','"+returnstate+"',"+fine+","+bmun+")";
					   stmt.executeUpdate(sql2);
					    System.out.println("���ͼ��2�ɹ�����");
					    flag = true;
					    num=num-bmun;
					    String sql4 = "update book set Bmun="+num+" where Bid='"+bbid+"' and Bflag=1";
					    stmt.executeUpdate(sql4);
						}
					}
					}
					else{
						flag=false;
					}
			//	 }
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
					if(rs2 != null)
					{
						rs2.close();
						rs2 = null;
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				DataAccess.closeconn(conn, stmt, prep, rs);
		}
			return flag;
		}
		
	
	//
	
	
	// ����
//		public boolean ReturnBooksInfo(BorrowBookDto bbdto,int allnum)
//		{
//			Connection conn = null;
//		    PreparedStatement prep = null;
//		    Statement stmt = null;
//			ResultSet rs = null;
//			ResultSet rs1 = null;
//			ResultSet rs2 = null;
//			boolean flag = false;
//			String bbid = bbdto.getBbid();
//			String bsid = bbdto.getBcid();
//			String borrowtime = bbdto.getBreturntime();
//			String returntime = bbdto.getBreturntime();
//			String returnstate = bbdto.getBreturnstate();
//			double fine = bbdto.getBfine();
//			int bmun = bbdto.getBmun();
//			String duetime = bbdto.getBduetime();
//			try {
//				 conn=DataAccess.getConnection();
//				 stmt = conn.createStatement();
//				//�����Ƿ����bbid��bsid������
//				 if(bmun<=0)
//				 {
//					 flag=false;
//				 }
//				 else {
//					
//				 rs = stmt.executeQuery("select Bbmun as bbmun from borrow_books where Bbid='" + bbid + "' and Bsid='" + bsid + "'");
//				 rs.next();
//				 if(bmun>rs.getInt("bbmun"))
//				 {
//					 flag=false;
//				 }
//
//				else {
//			             String sql2 = "insert into borrow_books(Bbid,Bsid,Bborrowtime,Breturntime, Bduetime,Bbstate,Bfine,Bbmun)"
//						+ "values('"+bbid+"','"+bsid+"','"+borrowtime+"','"+returntime+"','"+duetime+"','"+returnstate+"',"+fine+","+bmun+")";
//			           stmt.executeUpdate(sql2);
//					    System.out.println("���ͼ��2�ɹ�����");
//					    flag = true;
//					    allnum = allnum -bmun;
//					    String sql4 = "update book set Bmun="+allnum+" where Bid='"+bbid+"' and Bflag=1";
//					    stmt.executeUpdate(sql4);
//						}
//					//}
//					else{
//						flag=false;
//					}
//				 }
//				 }
//			}catch (SQLException e) {
//				System.out.println("����SQL�����ִ���");
//				e.printStackTrace();
//			}
//			finally{
//				try {
//					if(rs1 != null)
//					{
//						rs1.close();
//						rs1 = null;
//					}
//					if(rs2 != null)
//					{
//						rs2.close();
//						rs2 = null;
//					}
//				} catch (Exception e2) {
//					// TODO: handle exception
//				}
//				DataAccess.closeconn(conn, stmt, prep, rs);
//		}
//			return flag;
//		}
	
	//����
      public boolean UndateBorrowBooksInfo(BorrowBookDto bbdto)
		{
			Connection conn = null;
		    PreparedStatement prep = null;
		    Statement stmt = null;
			ResultSet rs = null;
			boolean flag = false;
			String bbid = bbdto.getBbid();
			String bcid = bbdto.getBcid();
			String borrowtime = bbdto.getBorrowtime();
			String returntime = bbdto.getBreturntime();
			String returnstate = bbdto.getBreturnstate();
			double fine = bbdto.getBfine();
			int bmun = bbdto.getBmun();
			String duetime = bbdto.getBduetime();
			try {
				    conn=DataAccess.getConnection();
				    stmt = conn.createStatement();
				    String sql1 = "update borrow_books set Bbid='"+bbid+"',Bsid='"+bcid+"',Bborrowtime='"+borrowtime+"',Breturntime='"+returntime+"',Bbstate='"+returnstate+"',Bfine="+fine+",Bduetime='"+duetime+"',Bbmun="+bmun+" where Bbid='"+bbid+"' and Bsid='"+bcid+"' and Bbflag=1";
				    stmt.executeUpdate(sql1);
				    System.out.println("�޸Ľ�����Ϣ�ɹ�����");	
				    System.out.println("____________"+bcid);	
				    flag = true;
				 
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
