<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="GB2312">
<title>��У�ſ�ϵͳ</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<!--ͷ��-->
	<header class="publicHeader">
	<h1>��У�ſ�ϵͳ</h1>

	<div class="publicHeaderR">
		<p>
			<span>����ã�</span><span style="color: #fff21b"> Admin</span> , ��ӭ�㣡
		</p>
		<a href="login.html">�˳�</a>
	</div>
	</header>
	<!--ʱ��-->
	<section class="publicTime"> <span id="time">2015��1��1��
		11:11 ����һ</span> <a href="#">��ܰ��ʾ��Ϊ���������������ʹ�ø߰汾���������IE10+��</a> </section>
	<!--��������-->
	<section class="publicMian ">
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>�����б� <span></span>
		</h2>
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
                <li><a href="logoutServlet">�˳�ϵͳ</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>���������ڵ�λ����:</strong> <span>�û�����ҳ�� >> �û���Ϣ�鿴ҳ��</span>
		</div>
		<%
			Vector<teacherInformationDTO> v = new Vector<teacherInformationDTO>();
			v = (Vector<teacherInformationDTO>) session
					.getAttribute("TeacherUser");
			Iterator it = v.iterator();
			teacherInformationDTO s = null;
			while (it.hasNext()) {
				s = (teacherInformationDTO) it.next();
		%>
		<div class="providerView">
			<p>
				<strong>��ʦ��:</strong><span><%=s.getTeacherID()%></span>
			</p>
			<p>
				<strong>��ʦ����:</strong><span><%=s.getTeacherName()%></span>
			</p>
			<p>
				<strong>��ʦ�Ա�:</strong><span><%=s.getTeacherSex()%></span>
			</p>
			<p>
				<strong>��ʦ�绰:</strong><span><%=s.getTeacherTel()%></span>
			</p>
			<p>
				<strong>��ʦ����:</strong><span><%=s.getTeacherAge()%></span>
			</p>
			<p>
				<strong>״̬:</strong><span><%=s.getTIflag()%></span>
			</p>
		</div>
		<%
			}
		%>
		<div class="providerAddBtn">
			<input type="button" value="����" onclick="history.back(-1)" />
		</div>
	</div>
	</section>
	<footer class="footer"> </footer>
	<script src="js/time.js"></script>

</body>
</html>