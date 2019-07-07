package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import en.edu.lingnan.Dto.StudentDTO;
import en.edu.lingnan.util.DataAccess;


/*public class StudentDAO {
//------------�������ݿ����������-------------
public Vector<StudentDTO> findAllStudentInfo() {   
	Vector<StudentDTO> v=new Vector<StudentDTO>();
	Connection conn=null;
	Statement stat=	null;
	ResultSet rs=null;
	try {		
		conn=DataAccess.getConnection();
		stat=conn.createStatement();  //����sql������ִ��
		String sql="select *from StudentInformation where SIflag=1";
		rs=stat.executeQuery(sql);
		while(rs.next()){  //��������
			StudentDTO s=new StudentDTO();
			s.setStudentID(rs.getString("StudentID"));
			s.setStudentName(rs.getString("StudentName"));
			s.setStudentSex(rs.getString("StudentSex"));
			s.setClassID(rs.getString("ClassID"));
			s.setStudentAge(rs.getInt("StudentAge"));
			v.add(s);
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
//��ѧ��StudentID����(��һ�ַ���)
public boolean findStudentID(String _sid){
	boolean flag=false;
	Connection conn=null;
	PreparedStatement prep=	null;
	Statement stat=	null;
	ResultSet rs=null;
	try {		
		conn=DataAccess.getConnection();
		String s=null;
		prep=conn.prepareStatement
		("select *from StudentInformation where StudentID=?");
		prep.setString(1, _sid);
		rs=prep.executeQuery();
		if(rs.first()){
			flag=true;
			System.out.println("StudentID"+"   "+"StudentName"+"      "+"StudentSex"+"    "+"ClassID"+"    "+"StudentAge");
			System.out.println(rs.getString("StudentID")+"  "+rs.getString("StudentName")+"      "+rs.getString("StudentSex")+"      "+rs.getString("ClassID")+"          "+rs.getInt("StudentAge"));
		}
		else{
			flag=false;
			System.out.println("���������ѧ��ѧ��");
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

//��ѧ��StudentID����(�ڶ��ַ���)
public Vector<StudentDTO> findStudentInfoById(String sid) {   
	Vector<StudentDTO> v=new Vector<StudentDTO>();
	Connection conn=null;
	Statement stat=	null;
	ResultSet rs=null;
	try {		
		conn=DataAccess.getConnection();
		stat=conn.createStatement();  //����sql������ִ��
		String sql="select *from StudentInformation where StudentID= '"+sid+"' and SIflag=1";
		rs=stat.executeQuery(sql);
		while(rs.next()){  //��������
			StudentDTO s=new StudentDTO();
			s.setStudentID(rs.getString("StudentID"));
			s.setStudentName(rs.getString("StudentName"));
			s.setStudentSex(rs.getString("StudentSex"));
			s.setClassID(rs.getString("ClassID"));
			s.setStudentAge(rs.getInt("StudentAge"));
			v.add(s);
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

//��ѧ������StudentName����
public boolean findStudentName(String _sname){
	boolean flag=false;
	Connection conn=null;
	PreparedStatement prep=	null;
	Statement stat=	null;
	ResultSet rs=null;
	try {		
		conn=DataAccess.getConnection();
		String s=null;
		prep=conn.prepareStatement
		("select *from StudentInformation where StudentName=?");
		prep.setString(1, _sname);
		rs=prep.executeQuery();
		if(rs.first()){
			flag=true;
			System.out.println("StudentID"+"   "+"StudentName"+"      "+"StudentSex"+"    "+"ClassID"+"    "+"StudentAge");
			System.out.println(rs.getString("StudentID")+"  "+rs.getString("StudentName")+"      "+rs.getString("StudentSex")+"      "+rs.getString("ClassID")+"          "+rs.getInt("StudentAge"));
		}
		else{
			flag=false;
			System.out.println("���������ѧ������");
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

//��ѧ��ѧ��ɾ������
public boolean deleteStudentByStudentID(String sid){    
	boolean flag=false;
	Connection conn=null;
	Statement stat=	null;
	try {	
		conn=DataAccess.getConnection();
		stat=conn.createStatement();  //����sql������ִ��
		String sql="update StudentInformation set SIflag=0 where StudentID='"+sid+"'";
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

//������ɾ������
public boolean deleteStudentByStudentName(String name){    
	boolean flag=false;
	Connection conn=null;
	Statement stat=	null;
	try {	
		conn=DataAccess.getConnection();
		stat=conn.createStatement();  //����sql������ִ��
		String sql="update StudentInformation set SIflag=0 where StudentName='"+name+"'";
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

//-----------------��ѧ�����������--------------
public boolean insertStudentInfo(StudentDTO sdto) {   
	boolean flag1=false;
	String StudentID=sdto.getStudentID();
	String StudentName=sdto.getStudentName();
	String StudentSex=sdto.getStudentSex();
	String ClassID=sdto.getClassID();
	int StudentAge=sdto.getStudentAge();
	int SIflag=sdto.getSIflag();
	String sql="insert into StudentInformation values"
			+"('"+StudentID+"','"+StudentName+"','"+StudentSex+"','"+ClassID+"','"+StudentAge+"','"+SIflag+"')";
	Connection conn=null;
	Statement stat=	null;
	try {		
		conn=DataAccess.getConnection();
		stat=conn.createStatement();  //����sql������ִ��
		stat.executeUpdate(sql);
		flag1=true;
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
	return flag1;
}
//�޸�ѧ��������
public boolean updateStudentInfo(StudentDTO sdto) {   
	boolean flag=false;
	String StudentID=sdto.getStudentID();
	String StudentName=sdto.getStudentName();
	String StudentSex=sdto.getStudentSex();
	String ClassID=sdto.getClassID();
	int StudentAge=sdto.getStudentAge();
	String sql="update StudentInformation set StudentName= '"+StudentName+"',StudentSex='"
	+StudentSex+"',ClassID='"+ClassID+"',StudentAge='"+StudentAge+"' where StudentID='"+StudentID+"'";			
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

}*/
public class StudentDAO {
	//------------�������ݿ����������-------------
	public Vector<StudentDTO> findAllStudentInfo() {   
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		Connection conn=null;
		Statement stat=	null;
		ResultSet rs=null;
		try {		
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			String sql="select *from StudentInformation";
			rs=stat.executeQuery(sql);
			while(rs.next()){  //��������
				StudentDTO s=new StudentDTO();
				s.setStudentID(rs.getString("StudentID"));
				s.setStudentName(rs.getString("StudentName"));
				s.setStudentSex(rs.getString("StudentSex"));
				s.setClassID(rs.getString("ClassID"));
				s.setStudentAge(rs.getInt("StudentAge"));
				s.setSIflag(rs.getInt("SIflag"));
				v.add(s);
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


	public String  findStudentClassInfo(String _Sid) {   
		
		String cid=null;
		Connection conn=null;
		Statement stat=	null;
		ResultSet rs=null;
		try {		
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			String sql="select * from StudentInformation where StudentID='"+_Sid+"'";
			rs=stat.executeQuery(sql);
			while(rs.next()){  //��������
				cid=rs.getString("ClassID");

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
		return cid;
	}





	//��ѧ��StudentID����(��һ�ַ���)
	public boolean findStudentID(String _sid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=	null;
		Statement stat=	null;
		ResultSet rs=null;
		try {		
			conn=DataAccess.getConnection();
			String s=null;
			prep=conn.prepareStatement
			("select *from StudentInformation where StudentID=?");
			prep.setString(1, _sid);
			rs=prep.executeQuery();
			if(rs.first()){
				flag=true;
				System.out.println("StudentID"+"   "+"StudentName"+"      "+"StudentSex"+"    "+"ClassID"+"    "+"StudentAge");
				System.out.println(rs.getString("StudentID")+"  "+rs.getString("StudentName")+"      "+rs.getString("StudentSex")+"      "+rs.getString("ClassID")+"          "+rs.getInt("StudentAge"));
			}
			else{
				flag=false;
				System.out.println("���������ѧ��ѧ��");
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

	//��ѧ��StudentID����(�ڶ��ַ���)
	public Vector<StudentDTO> findStudentInfoById(String sid) {   
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		Connection conn=null;
		Statement stat=	null;
		ResultSet rs=null;
		try {		
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			String sql="select *from StudentInformation where StudentID= '"+sid+"' and SIflag=1";
			rs=stat.executeQuery(sql);
			while(rs.next()){  //��������
				StudentDTO s=new StudentDTO();
				s.setStudentID(rs.getString("StudentID"));
				s.setStudentName(rs.getString("StudentName"));
				s.setStudentSex(rs.getString("StudentSex"));
				s.setClassID(rs.getString("ClassID"));
				s.setStudentAge(rs.getInt("StudentAge"));
				s.setSIflag(rs.getInt("SIflag"));
				v.add(s);
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

	//��ѧ������StudentName����
	public boolean findStudentName(String _sname){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=	null;
		Statement stat=	null;
		ResultSet rs=null;
		try {		
			conn=DataAccess.getConnection();
			String s=null;
			prep=conn.prepareStatement
			("select *from StudentInformation where StudentName=?");
			prep.setString(1, _sname);
			rs=prep.executeQuery();
			if(rs.first()){
				flag=true;
				System.out.println("StudentID"+"   "+"StudentName"+"      "+"StudentSex"+"    "+"ClassID"+"    "+"StudentAge");
				System.out.println(rs.getString("StudentID")+"  "+rs.getString("StudentName")+"      "+rs.getString("StudentSex")+"      "+rs.getString("ClassID")+"          "+rs.getInt("StudentAge"));
			}
			else{
				flag=false;
				System.out.println("���������ѧ������");
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

	//��ѧ��ѧ��ɾ������
	public boolean deleteStudentByStudentID(String sid){    
		boolean flag=false;
		Connection conn=null;
		Statement stat=	null;
		try {	
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			String sql="update StudentInformation set SIflag=0 where StudentID='"+sid+"'";
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

	//������ɾ������
	public boolean deleteStudentByStudentName(String name){    
		boolean flag=false;
		Connection conn=null;
		Statement stat=	null;
		try {	
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			String sql="update StudentInformation set SIflag=0 where StudentName='"+name+"'";
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

	//-----------------��ѧ�����������--------------
	public boolean insertStudentInfo(StudentDTO sdto) {   
		boolean flag1=false;
		String StudentID=sdto.getStudentID();
		String StudentName=sdto.getStudentName();
		String StudentSex=sdto.getStudentSex();
		String ClassID=sdto.getClassID();
		int StudentAge=sdto.getStudentAge();
		int SIflag=sdto.getSIflag();
		Statement stmt=	null;
		Connection conn=null;	
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
		  conn=DataAccess.getConnection();
		  stmt = conn.createStatement(); //����sql������ִ��
		  rs = stmt.executeQuery("select * from StudentInformation where StudentID='"+StudentID+"' and  SIflag = 1");
		 if(rs.next())
		 {
			 JOptionPane.showMessageDialog(null, "��ѧ���Ѿ����ڣ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
			 flag1 =false;
		 }
		 else{
			 rs1 = stmt.executeQuery("select * from UserInformation where UserID='" + StudentID + "' and  Uflag = 1");
			 if(rs1.next())
			 {
			 rs2 = stmt.executeQuery("select * from ClassInformation  where ClassID='" + ClassID + "' and  CIflag = 1");
			 if(rs2.next())
			 {
				 
				 String sql2="insert into StudentInformation values"
							+"('"+StudentID+"','"+StudentName+"','"+StudentSex+"','"+ClassID+"','"+StudentAge+"','"+SIflag+"')";
				 stmt.executeUpdate(sql2);
			     flag1=true;
			 }
			 }
			 else {
				 flag1=false;
			}
		 }
		}  catch (SQLException e) {
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
			try {
				
				if(rs2 != null)
				{
					rs2.close();
					rs2 = null;
				}
				if(rs1 != null)
				{
					rs1.close();
					rs1 = null;
				}
				if(rs!= null)
				{
					rs.close();
					rs = null;
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
		return flag1;
	}
	//�޸�ѧ��������
	public boolean updateStudentInfo(StudentDTO sdto) {   
		boolean flag=false;
		String StudentID=sdto.getStudentID();
		String StudentName=sdto.getStudentName();
		String StudentSex=sdto.getStudentSex();
		String ClassID=sdto.getClassID();
		int StudentAge=sdto.getStudentAge();
		int SIflag=1;
		String sql="update StudentInformation set StudentName= '"+StudentName+"',StudentSex='"
		+StudentSex+"',ClassID='"+ClassID+"',StudentAge='"+StudentAge+"',SIflag='"+SIflag+"' where StudentID='"+StudentID+"'";			
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

