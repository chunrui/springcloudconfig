<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
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
    <span id="time">2018��6��21�� 10:11  ������</span>
    <a href="#">��ܰ��ʾ��Ϊ���������������ʹ�ø߰汾���������IE10+��</a>
</section>
<!--��������-->
 <form action="findStudentInfoByIdServlet"> 
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
            <span>ѧ������ҳ�� >> ѧ����Ϣ�鿴ҳ��</span>
        </div>   
   <% 
    Vector<StudentDTO> v = new Vector<StudentDTO> ();
    String StudentID=request.getParameter("StudentID");
    v = (Vector<StudentDTO>)session.getAttribute("allstudentinfo");
    Iterator it = v.iterator();
    StudentDTO s = null;
    while(it.hasNext())
    {
 	   s = (StudentDTO)it.next();
 	  System.out.print("00000000kkk");
 	   if((s.getStudentID().trim()).equals(StudentID))
     {
 %>
        <div class="providerView">
            <p><strong>ѧ���ţ�</strong><span><%=s.getStudentID() %></span></p>
            <p><strong>ѧ��������</strong><span><%=s.getStudentName() %></span></p>
            <p><strong>ѧ���Ա�</strong><span><%=s.getStudentSex() %></span></p>
            <p><strong>ѧ���༶��</strong><span><%=s.getClassID() %></span></p>
            <p><strong>ѧ�����䣺</strong><span><%=s.getStudentAge() %></span></p>          
            <a href="userList.html">����</a>
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