<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>�����˵�����ϵͳ</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--ͷ��-->
<header class="publicHeader">
    <h1>�����˵�����ϵͳ</h1>

    <div class="publicHeaderR">
        <p><span>����ã�</span><span style="color: #fff21b"> Admin</span> , ��ӭ�㣡</p>
        <a href="../login.html">�˳�</a>
    </div>
</header>
<!--ʱ��-->
<%String UserID=(String)session.getAttribute("user"); %>
<section class="publicTime">
    <span id="time">2015��1��1�� 11:11  ����һ</span>
    <a href="#">��ܰ��ʾ��Ϊ���������������ʹ�ø߰汾���������IE10+��</a>
</section>
<!--��������-->
 <form action="findUserByidServlet"> 
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
            <span>�û�����ҳ�� >> �û���Ϣ�鿴ҳ��</span>
        </div>   
   <% 
   String ClassScheduleID = request.getParameter("ClassScheduleID");
	Vector<ClassScheduleDTO> v1 = new Vector<ClassScheduleDTO>();
	v1 = (Vector<ClassScheduleDTO>) session.getAttribute("classSchedule");
	Iterator it = v1.iterator();
	ClassScheduleDTO sdto = null;
	while (it.hasNext()) {
		sdto = (ClassScheduleDTO) it.next();
		if ((sdto.getClassScheduleID().trim())
				.equalsIgnoreCase(ClassScheduleID)) {
   		//  System.out.println("-----------"+c.getRoomid());
 %>��

        <div class="providerView">
            <p><strong>�ſα�ţ�</strong><span><%=sdto.getClassScheduleID() %></span></p>
            <p><strong>�༶��ţ�</strong><span><%=sdto.getClassID() %></span></p>
            <p><strong>�γ̱�ţ�</strong><span><%=sdto.getCourseID() %></span></p>
            <p><strong>����**��</strong><span><%=sdto.getWeekday() %></span></p>
            <p><strong>�Ͽν�����</strong><span><%=sdto.getClassTime() %></span></p>
            <p><strong>��ʦ��ţ�</strong><span><%=sdto.getTeacherId() %></span></p>
            <p><strong>���ұ�ţ�</strong><span><%=sdto.getClassroomID() %></span></p>
            <a href="FindClassSchedule1.jsp">����</a>
        </div>
        <%
        }
    }
        %>
    </div>
    </form>
</section>

<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>