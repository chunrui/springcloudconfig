<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��ʦ������Ϣ</title>
 <link rel="stylesheet" href="css/public.css"/>
 <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
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
            <span>��ʦҳ�� >> ������Ϣ�鿴ҳ��</span>
        </div>     
        <%
            TeacherInformationDAO1 tdao = new TeacherInformationDAO1();
			Vector <teacherInformationDTO> v = new Vector<teacherInformationDTO> ();
			v=tdao.findATeaInfoByID(userid);
            Iterator it = v.iterator();
            teacherInformationDTO t = null;
            while(it.hasNext()){
	             t = (teacherInformationDTO)it.next();
         %>
         <%
            UserInformationDAO udao = new UserInformationDAO();
			Vector <UserInformationDTO> v1 = new Vector<UserInformationDTO> ();
			v1=udao.FindAUserInfoByID(userid);
            Iterator it1 = v1.iterator();
            UserInformationDTO u = null;
            while(it1.hasNext()){
    	    System.out.println(userid);
	        u = (UserInformationDTO)it1.next();
         %>
                <%  String a=u.getUserPsw();System.out.println(a+"111");%>
           <div class="providerView">
           <p><strong>��ʦID:</strong><span><%=t.getTeacherID() %></span></p>
            <p><strong>��ʦ����:</strong><span><%=t.getTeacherName() %></span></p>
            <p><strong>��ʦ�Ա�:</strong><span><%=t.getTeacherSex() %></span></p>
            <p><strong>��ʦ�ֻ�����:</strong><span><%=t.getTeacherTel() %></span></p>
            <p><strong>��ʦ����:</strong><span><%=t.getTeacherAge() %></span></p>
            <p><strong>��ʦ��¼����:</strong><span><%=u.getUserPsw() %></span></p>
            <a href="http://localhost:8080/CourseScheduling/ok.jsp?userid=<%=userid %>">����</a>
        </div>
        
 <%
	}
%>
        
<%
	}
%>
        
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>
</body>
</html>