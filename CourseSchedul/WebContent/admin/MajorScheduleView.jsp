<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
    <title>��У�ſι���ϵͳ</title>
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
<%String UserID=(String)session.getAttribute("user"); %>
<section class="publicTime">
    <span id="time">2018��1��1�� 11:11  ����һ</span>
    <a href="#">��ܰ��ʾ��Ϊ���������������ʹ�ø߰汾���������IE10+��</a>
</section>
<!--��������-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>�����б� <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="findAllUserServlet">�û���Ϣ����</a></li>
                <li ><a href="findStudentInfoServlet">ѧ����Ϣ����</a></li>
                <li ><a href="findTeacherInformationServlet">��ʦ��Ϣ����</a></li>
                <li ><a href="findAllTeacher_scheduleInfoServlet">��ʦ�ο���Ϣ����</a></li>
                <li ><a href="findAllClassRoomServlet">������Ϣ����</a></li>
                <li ><a href="findAllClassRoomUseServlet">����ʹ��״̬</a></li>
                <li ><a href="findClassIfoServlet">�༶��Ϣ����</a></li>
                <li ><a href="findMajorIfoServlet">רҵ��Ϣ����</a></li>
                <li ><a href="searchAllMajorSchedule">רҵ�γ̱����</a></li>
                <li ><a href="findTeacherCourseServlet">��ʦ�ſι���</a></li>
                <li ><a href="findClassScheduleServlet">�༶�ſι���</a></li>
                <li><a href="showpersonalInfo.jsp?UserID=<%=UserID%>">��������</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>���������ڵ�λ����:</strong>
            <span>רҵ�γ̹���ҳ�� >> ��Ϣ�鿴</span>
        </div>
        <div class="providerView">
        <%         
        String CourseID = request.getParameter("CourseID");
        MajorScheduleDAO mdao = new MajorScheduleDAO();
		Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
		v=mdao.findMajorScheduleByID(CourseID);
        Iterator it = v.iterator();
        MajorScheduleDTO m = null;
        while(it.hasNext()){
	    m = (MajorScheduleDTO)it.next();
%>
            <p><strong>�γ�ID:</strong><span><%=m.getCourseID() %></span></p>
            <p><strong>רҵID:</strong><span><%=m.getMajorID() %></span></p>
            <p><strong>�γ�����:</strong><span><%=m.getCourseName() %></span></p>
            <p><strong>�γ�ѧʱ:</strong><span><%=m.getCourseTime() %></span></p>
            <p><strong>ѧ��:</strong><span><%=m.getYearTime() %></span></p>
            <p><strong>ѧ��:</strong><span><%=m.getTermTime() %></span></p>
            <p><strong>��������:</strong><span><%=m.getClassroomType() %></span></p> 
            <p><strong>ʣ���ſ���:</strong><span><%=m.getEveryWeekCourseTime() %></span></p> 
            <a href="MajorScheduleList.jsp">����</a>
<%
	  }
%>

        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>