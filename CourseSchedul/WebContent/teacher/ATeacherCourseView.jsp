<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��ʦ�����ڿα�</title>
 <link rel="stylesheet" href="css/public.css"/>
 <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--ͷ��-->
<header class="publicHeader">
    <h1>��У�ſι���ϵͳ</h1>

    <div class="publicHeaderR">
        <p><span>����ã�</span><span style="color: #fff21b"> Admin</span> , ��ӭ�㣡</p>
        <a href="../login.html">�˳�</a>
    </div>
</header>
<!--ʱ��-->
<% String userid = request.getParameter("userid");
%>
<section class="publicTime">
    <span id="time">2015��1��1�� 11:11  ����һ</span>
    <a href="#">��ܰ��ʾ��Ϊ���������������ʹ�ø߰汾���������IE10+��</a>
</section>
<!--��������-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>�����б� <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="ATeacherCourseView.jsp?userid=<%=userid%>">��ʦ�ڿα�</a></li>
                <li><a href="TeacherPersonInfoView.jsp?userid=<%=userid%>">������Ϣ</a></li>              
                <li><a href="TeaInfoUpdate.jsp?userid=<%=userid%>">��Ϣ�޸�</a></li>
                <li><a href="http://localhost:8080/CourseSchedul/login.html">�˳�ϵͳ</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>���������ڵ�λ����:</strong>
            <span>��ʦҳ�� >> ��ʦ�����ڿα�ҳ��</span>
        </div>
        <div class="providerView">
               <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="16%">��ʦID</th>
                <th width="16%">�༶ID</th>
                <th width="16%">�γ�ID</th>
                <th width="16%">���ڼ�</th>
                <th width="16%">�ڼ��ڿ�</th>
                <th width="16%">�Ͽν���</th>
            </tr>
           
 <%
            teacherCourseDAO tdao = new teacherCourseDAO();
			Vector <teacherCourseDTO> v = new Vector<teacherCourseDTO> ();
		    v=tdao.findTeacherCourseByteacherID(userid);
			//v=tdao.findATeachCourseByID(userid);
            Iterator it = v.iterator();
            teacherCourseDTO t = null; 
            while(it.hasNext())
            {
    	    System.out.println(userid);
	        t = (teacherCourseDTO)it.next();
	        System.out.println("0000iii"+userid);
 %>
 <tr align="center">
    
    <td><%=t.getTeacherID() %></td>
    <td><%=t.getClassID() %></td>
    <td><%=t.getCourseID() %></td>
    <td><%=t.getWeekDay() %></td>
    <td><%=t.getClassTime() %></td>
    <td><%=t.getClassroomID() %></td>
    
</tr>
<%
	}
%>
        </table>
            <a href="http://localhost:8080/CourseSchedul/teacher/ok.jsp?userid=<%=userid %>">����</a>
        </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>