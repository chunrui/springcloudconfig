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
            <span>����ʹ�ù���ҳ�� >> ����ʹ�ò鿴ҳ��</span>
        </div>   
   <% 
   request.setCharacterEncoding("GB2312");
   response.setContentType("text/html;charset=GB2312");
   
   String cid=request.getParameter("cid");
   Vector<ClassRoomUseDto> v = new Vector<ClassRoomUseDto> ();
   v = (Vector<ClassRoomUseDto>)session.getAttribute("allclassroomuse");
   Iterator it = v.iterator();
   ClassRoomUseDto  u= null;
   //System.out.println("wwwwwww");
   while(it.hasNext())
   {
	  u = (ClassRoomUseDto)it.next();
	  System.out.println("---------"+u.getRoomUserid());
	  
	  System.out.println("+++++++++"+cid);
	  if((u.getRoomUserid().trim()).equals(cid))
	   {
		  System.out.println("kkkkk");
 %>
            <div class="providerView">
            <p><strong>����ʹ�ñ�ţ�</strong><span><%=u.getRoomUserid()%></span></p>
            <p><strong>���ұ�ţ�</strong><span><%=u.getRoomid() %></span></p>
            <p><strong>����**��</strong><span><%=u.getWeekday() %></span></p>
            <p><strong>ʹ�ý��� ��</strong><span><%=u.getClasstime() %></span></p>
            <p><strong>ʹ��״̬��</strong><span><%=u.getUserstate()%></span></p>
            <a href="ShowAllClassRoomUse.jsp">����</a>
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