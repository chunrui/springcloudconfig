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
		<a href="../login.html">�˳�</a>
	</div>
	</header>
	<!--ʱ��-->
	<%String UserID=(String)session.getAttribute("user"); %>
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
                <li ><a href="searchAllMajorSchedule">רҵ�γ̱�����</a></li>
                <li ><a href="findTeacherCourseServlet">��ʦ�ſι���</a></li>
                <li ><a href="findClassScheduleServlet">�༶�ſι���</a></li>
                <li><a href="showpersonalInfo.jsp?UserID=<%=UserID%>">��������</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>���������ڵ�λ����:</strong> <span>�û�����ҳ�� >> �û��޸�ҳ��</span>
		</div>
		<div class="providerAdd">
			<form action="updateTeacherInformationServlet">
				<!--div��class Ϊerror����֤����ok����֤�ɹ�-->
				<%
					Vector<teacherInformationDTO> v = new Vector<teacherInformationDTO>();
					v = (Vector<teacherInformationDTO>) session.getAttribute("TeacherUser");
					Iterator it = v.iterator();
					teacherInformationDTO s = null;
					while (it.hasNext()) {
						s = (teacherInformationDTO) it.next();
				%>
				<div>
					<label for="TeacherID">��ʦ���:</label> <input type="text"
						name="TeacherID" id="TeacherID" value=<%=s.getTeacherID()%> /> <span>*</span>
				</div>		
				<div>
					<label for="TeacherName">��ʦ����:</label> <input type="text"
						name="TeacherName" id="TeacherName" value=<%=s.getTeacherName()%> /> <span>*</span>
				</div>
				<div>
					<label for="TeacherSex">��ʦ�Ա�:</label> <input type="text"
						name="TeacherSex" id="TeacherSex" value=<%=s.getTeacherSex()%> /> <span>*</span>
				</div>
				<div>
					<label for="TeacherTel">��ʦ�绰:</label> <input type="text"
						name="TeacherTel" id="TeacherTel" value=<%=s.getTeacherTel()%> /> <span>*</span>
				</div>
				<div>
					<label for="TeacherAge">��ʦ����:</label> <input type="text"
						name="TeacherAge" id="TeacherAge" value=<%=s.getTeacherAge()%> />
				</div>
				<div>
					<label for="TIflag">״̬:</label> <input type="text"
						name="TIflag" id="TIflag" value=<%=s.getTIflag()%> /> <span>*</span>
				</div>
				<div class="providerAddBtn">
					<!--<a href="#">����</a>-->
					<!--<a href="userList.html">����</a>-->
					<input style="line-height:10px;height:30px;width:90px;" type="submit" value="����"/> <input
						type="button" value="����" onclick="history.back(-1)" />
				</div>
				<%
					}
				%>
			</form>
		</div>

	</div>
	</section>
	<footer class="footer"> </footer>
	<script src="js/time.js"></script>

</body>
</html>