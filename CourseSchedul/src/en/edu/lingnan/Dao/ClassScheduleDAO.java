package en.edu.lingnan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import en.edu.lingnan.Dto.ClassScheduleDTO;
import en.edu.lingnan.util.DataAccess;

public class ClassScheduleDAO {
	//------------�������ݿ����������-------------
	public Vector<ClassScheduleDTO> findAllClassScheduleInfo() {   
		Vector<ClassScheduleDTO> v=new Vector<ClassScheduleDTO>();
		Connection conn=null;
		Statement stat=	null;
		ResultSet rs=null;
		PreparedStatement prep = null;
		try {		
			conn=DataAccess.getConnection();
			stat=conn.createStatement();  //����sql������ִ��
			String sql="select * from ClassSchedule where CSflag=1";
			rs=stat.executeQuery(sql);
			while(rs.next()){  //��������
				ClassScheduleDTO cs=new ClassScheduleDTO();
				cs.setClassScheduleID(rs.getString("ClassScheduleID"));
				cs.setClassID(rs.getString("ClassID"));
				cs.setCourseID(rs.getString("CourseID"));
				cs.setWeekday(rs.getString("Weekday"));
				cs.setClassTime(rs.getString("ClassTime"));
				cs.setTeacherId(rs.getString("TeacherId"));
				cs.setClassroomID(rs.getString("ClassroomID"));				
				v.add(cs);
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
	
	
	
////��ѧ��ClassScheduleID����(��һ�ַ���)
//public Vector<ClassScheduleDTO> findClassScheduleID(String _csid){
//	Vector<ClassScheduleDTO> v=new Vector<ClassScheduleDTO>();
//	boolean flag=false;
//	Connection conn=null;
//	PreparedStatement prep=	null;
//	Statement stat=	null;
//	ResultSet rs=null;
//	try {	
//		conn=DataAccess.getConnection();
//		String s =null;
//		Statement stmt = null;
//		prep=conn.prepareStatement
//		("select * from ClassSchedule where ClassScheduleID=? and CSflag=1");
//		prep.setString(1, _csid);
//		rs=prep.executeQuery();
//		if(rs.next()){
//			ClassScheduleDTO cs=new ClassScheduleDTO();
//			cs.setClassScheduleID(rs.getString("ClassScheduleID"));
//			cs.setClassID(rs.getString("ClassID"));
//			cs.setCourseID(rs.getString("CourseID"));
//			cs.setWeekday(rs.getString("Weekday"));
//			cs.setClassTime(rs.getString("ClassTime"));
//			cs.setTeacherId(rs.getString("TeacherId"));
//			cs.setClassroomID(rs.getString("ClassroomID"));				
//			v.add(cs);
//			}
//		else{
//			flag=false;
//			System.out.println("����������γ̱��");
//		}
//
//	}  catch (SQLException e) {
//		System.out.println("����SQL�����ִ���");
//		e.printStackTrace();
//	}
//	finally{
//		DataAccess.closeconn(conn, stat, prep, rs);		
//	}
//	return v;
//	}
//
//



//��ѧ��ClassScheduleID����(��һ�ַ���)
public Vector<ClassScheduleDTO> findClassScheduleInfoByClassScheduleID(String csid) {   
	Vector<ClassScheduleDTO> v=new Vector<ClassScheduleDTO>();
	Connection conn=null;
	Statement stat=	null;
	ResultSet rs=null;
	try {		
		conn=DataAccess.getConnection();
		stat=conn.createStatement();  //����sql������ִ��
		String sql="select *from ClassSchedule where ClassScheduleID= '"+csid+"' and CSflag=1";
		rs=stat.executeQuery(sql);
		while(rs.next()){  //��������
			ClassScheduleDTO cs=new ClassScheduleDTO();
			cs.setClassScheduleID(rs.getString("ClassScheduleID"));
			cs.setClassID(rs.getString("ClassID"));
			cs.setCourseID(rs.getString("CourseID"));
			cs.setWeekday(rs.getString("Weekday"));
			cs.setClassTime(rs.getString("ClassTime"));
			cs.setTeacherId(rs.getString("TeacherId"));
			cs.setClassroomID(rs.getString("ClassroomID"));				
			v.add(cs);
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

//��ѧ��ClassID����(�ڶ��ַ���)
public Vector<ClassScheduleDTO> findClassScheduleInfoByClassID(String cid) {   
	Vector<ClassScheduleDTO> v=new Vector<ClassScheduleDTO>();
	Connection conn=null;
	Statement stat=	null;
	ResultSet rs=null;
	try {		
		conn=DataAccess.getConnection();
		stat=conn.createStatement();  //����sql������ִ��
		String sql="select *from ClassSchedule where ClassID = '"+cid+"' and CSflag=1";
		rs=stat.executeQuery(sql);
		while(rs.next()){  //��������
			ClassScheduleDTO cs=new ClassScheduleDTO();
			cs.setClassScheduleID(rs.getString("ClassScheduleID"));
			cs.setClassID(rs.getString("ClassID"));
			cs.setCourseID(rs.getString("CourseID"));
			cs.setWeekday(rs.getString("WeekDay"));
			cs.setClassTime(rs.getString("ClassTime"));
			cs.setTeacherId(rs.getString("TeacherId"));
			cs.setClassroomID(rs.getString("ClassroomID"));				
			v.add(cs);
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


//���γ̱��ɾ������
public boolean deleteClassScheduleByClassScheduleID(String csid){    
	boolean flag=false;
	Connection conn=null;
	Statement stat=	null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	try {	
		conn=DataAccess.getConnection();
		stat=conn.createStatement();  //����sql������ִ��
		rs =  stat.executeQuery("select * from ClassSchedule  where ClassScheduleID='"+csid+"' and CSflag=1");
		if(rs.next())
		{

			String	ClassID=rs.getString(2);
		    String	CourseID=rs.getString(3);
		    String	WeekDay=rs.getString(4);
		    String	ClassTime=rs.getString(5);
		    String	TeacherId=rs.getString(6);
		    String ClassroomID=rs.getString(7);
		    rs1 =  stat.executeQuery("select * from TeacherCourse where ClassTime='" + ClassTime  + "' and WeekDay='" + WeekDay  + "' and TeacherId='" + TeacherId + "' and CourseID='" + CourseID + "'  and ClassID='" + ClassID + "' and TCflag=1");
			if(rs1.next())
			{
				String sql1="update  TeacherCourse set TCflag=0  where ClassTime='" + ClassTime  + "' and WeekDay='" + WeekDay  + "' and TeacherId='" + TeacherId + "' and CourseID='" + CourseID + "' and ClassID='" + ClassID + "' and TCflag=1";
				stat.executeUpdate(sql1);
			}
		
		String sql="update  ClassSchedule set CSflag=0 where ClassScheduleID='"+csid+"'";
		stat.executeUpdate(sql);
		String sql3 = "update ClassroomUse set Status='����'  where ClassroomID ='" +ClassroomID  + "' and WeekDay='" + WeekDay  + "' and ClassTime='" + ClassTime + "' and CUflag=1";
	    stat.executeUpdate(sql3);
	    rs2 = stat.executeQuery("select * from MajorSchedule where CourseID ='" +CourseID + "' and MSflag=1");
	    if(rs2.next())
		{
			int EveryWeekCourseTime = rs2.getInt(9);  //��ȡÿ���Ͽ���
			EveryWeekCourseTime=EveryWeekCourseTime+2;
	    String sql5 = "update MajorSchedule set EveryWeekCourseTime="+EveryWeekCourseTime+"  where CourseID  ='" +CourseID  + "' and  MSflag=1";
	    stat.executeUpdate(sql5);
		flag=true;
		}
		}
		else {
			flag=false;
		}
	}  catch (SQLException e) {
		System.out.println("����sql���ʱ���ִ���");
		e.printStackTrace();
	}finally{
		try {
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

//�޸��ſα������
/*public boolean updateClassScheduleInfo(ClassScheduleDTO csdto) {   
	boolean flag=false;
	Connection conn = null;
    Statement stmt = null;
	ResultSet rs = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	String ClassScheduleID=csdto.getClassScheduleID();
	String ClassID=csdto.getClassID();
	String CourseID=csdto.getCourseID();
	String Weekday=csdto.getWeekday();
	String ClassTime=csdto.getClassTime();
	String TeacherId=csdto.getTeacherId();
	String ClassroomID=csdto.getClassroomID();
	try {
	conn=DataAccess.getConnection();
    stmt=conn.createStatement();  //����sql������ִ��
    //���ҽ����Ƿ�Ϊ��
	rs =  stmt.executeQuery("select * from ClassroomUse where ClassroomID='" + ClassroomID  + "' and WeekDay='" + Weekday  + "' and ClassTime='" + ClassTime + "' and CUflag=1");
	if(rs.next())
	{
		if(rs.getString(5).trim().equalsIgnoreCase("����"))
		{
			//�����Ƿ���Ͻ�ʦ�ڿα�
		  rs3 = stmt.executeQuery("select * from Teacher_schedule where CourseID='" + CourseID + "' and TeacherId='" + TeacherId + "' and TTflag=1");
		    if(rs3.next())
		    {
		    	//�����Ƿ��иð༶
		    	rs4 =stmt.executeQuery("select * from ClassInformation where ClassID='" + ClassID+ "' and CIflag=1");
		        if(rs4.next())
		       {
		        //ִ�в������
	         String sql="update ClassSchedule set ClassID= '"+ClassID+"',CourseID='"
	    +CourseID+"',Weekday='"+Weekday+"',ClassTime='"+ClassTime+"',TeacherId='"+TeacherId+"',ClassroomID='"+ClassroomID+"' where ClassScheduleID='"+ClassScheduleID+"'";	
		stmt.executeUpdate(sql);
		String sql3 = "update ClassroomUse set Status='��ռ��'  where ClassroomID ='" +ClassroomID  + "' and WeekDay='" + Weekday  + "' and ClassTime='" + ClassTime + "' and CUflag=1";
	    stmt.executeUpdate(sql3);
		flag=true;
	           } 
		    }
		 }
	}    //����������
       else {
				flag = false;
			}
		}catch (SQLException e) {
		System.out.println("����sql���ʱ���ִ���");
		e.printStackTrace();
	}finally{
		try {
			if(rs4 != null)
			{
				rs4.close();
				rs4 = null;
			}
			if(rs3 != null)
			{
				rs3.close();
				rs3 = null;
			}
			if(rs != null)
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
	return flag;
}*/
public boolean updateClassScheduleInfo(ClassScheduleDTO csdto) {
	boolean flag = false;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs1 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	String ClassScheduleID = csdto.getClassScheduleID();
	String ClassID = csdto.getClassID();
	String CourseID = csdto.getCourseID();
	String Weekday = csdto.getWeekday();
	String ClassTime = csdto.getClassTime();
	String TeacherId = csdto.getTeacherId();
	String ClassroomID = csdto.getClassroomID();
	int CSflag = csdto.getCSflag();
	try {
		conn = DataAccess.getConnection();
		stmt = conn.createStatement(); // ����sql������ִ��
		// ���ҽ����Ƿ�Ϊ��
		rs1 = stmt
				.executeQuery("select * from ClassroomUse where ClassroomID='"
						+ ClassroomID
						+ "' and WeekDay='"
						+ Weekday
						+ "' and ClassTime='"
						+ ClassTime
						+ "' and CUflag=1");
		if (rs1.next()) {
			String state = rs1.getString(5); // ��ȡ����ʹ��״̬
			System.out.print(state);
			if ((state.trim()).equalsIgnoreCase("����")) {
				// �����Ƿ���Ͻ�ʦ�ڿα�
				rs3 = stmt
						.executeQuery("select * from Teacher_schedule where CourseID='"
								+ CourseID
								+ "' and TeacherId='"
								+ TeacherId + "' and TTflag=1");

				if (rs3.next()) {
					// �����Ƿ��иð༶
					rs4 = stmt
							.executeQuery("select * from ClassInformation where ClassID='"
									+ ClassID + "' and CIflag=1");
					if (rs4.next()) {
						// ִ�в������
						String sql = "update ClassSchedule set ClassID= '"
								+ ClassID + "',CourseID='" + CourseID
								+ "',Weekday='" + Weekday + "',ClassTime='"
								+ ClassTime + "',TeacherId='" + TeacherId
								+ "',ClassroomID='" + ClassroomID
								+ "',CSflag='" + CSflag
								+ "' where ClassScheduleID='"
								+ ClassScheduleID + "'";
						stmt.executeUpdate(sql);
						
						String sql1 = "update ClassroomUse set Status = '��ռ��' where ClassroomID='"
								+ ClassroomID + "'";
						stmt.executeUpdate(sql1);
						flag = true;
					}
				}
			}
		} // ����������
		else {
			flag = false;
		}
	} catch (SQLException e) {
		System.out.println("����sql���ʱ���ִ���");
		e.printStackTrace();
	} finally {
		try {
			if (rs4 != null) {
				rs4.close();
				rs4 = null;
			}
			if (rs3 != null) {
				rs3.close();
				rs3 = null;
			}
			if (rs1 != null) {
				rs1.close();
				rs1 = null;
			}

			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (SQLException e) {
			System.out.println("�ر����ӡ���估�����ʱ���ִ���");
			e.printStackTrace();
		}
	}
	return flag;
}

//-----------------�ſα��������--------------
public boolean insertClassScheduleInfo(ClassScheduleDTO csdto) {   
	boolean flag=false;
    PreparedStatement prep = null;
    Statement stmt = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs5 = null;
	ResultSet rs3 = null;
	ResultSet rs6 = null;
	ResultSet rs4 = null;
	Connection conn=null;
	String ClassScheduleID=csdto.getClassScheduleID();
	String ClassID=csdto.getClassID();
	String CourseID=csdto.getCourseID();
	String Weekday=csdto.getWeekday();
	String ClassTime=csdto.getClassTime();
	String TeacherId=csdto.getTeacherId();
	String ClassroomID=csdto.getClassroomID();
	//�༶��Ϣ��רҵ�γ̱���ʦ��Ϣ����Ϣ���ұ�
//	TeacherCourse  TCflag                                     TeacherCourseID
//	ClassSchedule  CSflag                                  ClassScheduleID
//	MajorSchedule  MSflag                           CourseID
//	ClassroomUse   CUflag                      ClassroomID               
//	ClassroomInformation  CRIflag              ClassroomID 
//	TeacherInformation  TIflag               TeacherID 
//	StudentInformation  SIflag            StudentID
//	ClassInformatio   CIflag            ClassID 
//	MajorInformation    MIflag         MajorID 
//	UserInformation  Uflag          UserID 
	try {
		conn=DataAccess.getConnection();
	    stmt=conn.createStatement(); 
		//û�оͽ������ݲ���
	    rs = stmt.executeQuery("select * from ClassSchedule where ClassScheduleID='"+ClassScheduleID+"'");
		if(rs.next())
		 {
			String sql4 = "update ClassSchedule set CSflag=1 where ClassScheduleID='"+ClassScheduleID+"'";
		    stmt.executeUpdate(sql4);
			flag=true;
		 }
		else{
			
	    rs1 = stmt.executeQuery("select * from MajorSchedule where CourseID ='" +CourseID + "' and MSflag=1");
	    if(rs1.next())
		{
			int EveryWeekCourseTime = rs1.getInt(9);  //��ȡÿ���Ͽ���
			System.out.println("1111");
			if(EveryWeekCourseTime>0)
			{
				System.out.println("11112");
	         rs2 =  stmt.executeQuery("select * from ClassroomUse where ClassroomID ='" +ClassroomID  + "' and WeekDay='" + Weekday  + "' and ClassTime='" + ClassTime + "' and CUflag=1");
			if(rs2.next())
			{
				System.out.println("11113");
				String state = rs2.getString(5);  //��ȡ����ʹ��״̬
				System.out.println("111131"+state);
				if(rs2.getString(5).trim().equalsIgnoreCase("����"))
				{
					System.out.println("11114");
					 rs3 =  stmt.executeQuery("select * from ClassroomInformation where ClassroomID ='" +ClassroomID  + "'  and CRIflag=1");
						if(rs3.next())
						{
							System.out.println("11115");
							int NumberMax = rs3.getInt(4);  //��ȡ���������
							 rs4 =stmt.executeQuery("select * from ClassInformation where ClassID='" + ClassID+ "' and CIflag=1");
                                 if(rs4.next())
                                 {
                                	 System.out.println("11116");
                                	 int ClassNumber = rs4.getInt(5); 
                                    if(NumberMax>=ClassNumber )
                                    {
                                    	System.out.println("11117");
				                     rs5 = stmt.executeQuery("select * from Teacher_schedule where CourseID='" + CourseID + "' and TeacherId='" + TeacherId + "' and TTflag=1");
				                      if(rs5.next())
				                           {
				                    	  String sql = "insert into ClassSchedule(ClassScheduleID,ClassID,CourseID,Weekday,ClassTime,TeacherId,ClassroomID)"
													+ "values('"+ClassScheduleID+"','"+ClassID+"','"+CourseID+"','"+Weekday+"','"+ClassTime+"','"+TeacherId+"','"+ClassroomID+"')";
				                         
				    	                  stmt.executeUpdate(sql);
				    	                   System.out.println("����ſ���Ϣ�ɹ�����");
				    	                   EveryWeekCourseTime = EveryWeekCourseTime -2;
				    					    String sql4 = "update MajorSchedule set EveryWeekCourseTime="+EveryWeekCourseTime+"  where CourseID ='" +CourseID + "' and MSflag=1";
				    					    stmt.executeUpdate(sql4);
				    					   // String Status="��ռ��";
				    					    String sql3 = "update ClassroomUse set Status='��ռ��'  where ClassroomID ='" +ClassroomID  + "' and WeekDay='" + Weekday  + "' and ClassTime='" + ClassTime + "' and CUflag=1";
				    					    stmt.executeUpdate(sql3);
				    					    flag = true;
				                           }
                                      }
                                  }
							 }
						}
			    }
			}
		}
	    else {
	    	flag = false;
			System.out.println("����ſ���Ϣʧ�ܣ���");
		}
				                           
		}
		
	}catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			try{
				if(rs5 != null)
				{
					rs5.close();
					rs5 = null;
				}
			if(rs4 != null)
			{
				rs4.close();
				rs4 = null;
			}
			if(rs3 != null)
			{
				rs3.close();
				rs3 = null;
			}
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
			if(rs6 != null)
			{
				rs6.close();
				rs6 = null;
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		DataAccess.closeconn(conn, stmt, prep, rs);
	}
	return flag;
}
 
}
