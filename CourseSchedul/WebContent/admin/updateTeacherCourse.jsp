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
                <li ><a href="searchAllMajorSchedule">רҵ�γ̱����</a></li>
                <li ><a href="findTeacherCourseServlet">��ʦ�ſι���</a></li>
                <li ><a href="findClassScheduleServlet">�༶�ſι���</a></li>
                <li><a href="showpersonalInfo.jsp?UserID=<%=UserID%>">��������</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>���������ڵ�λ����:</strong> <span>�û�����ҳ�� >> ��ʦ�ſα��޸�ҳ��</span>
		</div>
		<div class="providerAdd">
			<form action="updateTeacherCourseServlet">
				<!--div��class Ϊerror����֤����ok����֤�ɹ�-->
				<%
					Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
					v = (Vector<teacherCourseDTO>) session.getAttribute("TeacherUser");
					Iterator it = v.iterator();
					teacherCourseDTO s = null;
					while (it.hasNext()) {
						s = (teacherCourseDTO) it.next();
				%>
				<div>
					<label for="TeacherCourseID">��ʦ�γ̱��:</label> <input type="text"
						name="TeacherCourseID" id="TeacherCourseID" value=<%=s.getTeacherCourseID()%>/> <span>*</span>
				</div>
				
				<div>
					<label for="TeacherCourseID">��ʦ���:</label> <input type="text"
						name="TeacherID" id="TeacherID" value=<%=s.getTeacherID()%>/> <span>*</span>
				</div>		
				<div>
					<label for="CourseID">�γ̱��:</label> <input type="text"
						name="CourseID" id="CourseID" value=<%=s.getCourseID()%>/> <span>*</span>
				</div>
				<div>
					<label for="ClassID">�༶���:</label> <input type="text"
						name="ClassID" id="ClassID" value=<%=s.getClassID()%>/> <span>*</span>
				</div>
				<div>
                    <label for="WeekDay">����**:</label>
                    <select name="WeekDay" id="WeekDay">
	               <option value="����һ" selected="WeekDay">&nbsp;&nbsp;����һ</option>
	               <option value="���ڶ�" selected="WeekDay">&nbsp;&nbsp;���ڶ�</option>
	               <option value="������" selected="WeekDay">&nbsp;&nbsp;������</option>
	               <option value="������" selected="WeekDay">&nbsp;&nbsp;������</option>
	               <option value="������" selected="WeekDay">&nbsp;&nbsp;������</option>
	               <option value="������" selected="WeekDay">&nbsp;&nbsp;������</option>
	               <option value="������" selected="WeekDay">&nbsp;&nbsp;������</option>
                  </select>
                </div>

                <div>
                    <label >������</label>
                    <select name="ClassTime" id="classtime">
	               <option value="1,2" selected="ClassTime">&nbsp;&nbsp;1,2</option>
	               <option value="3,4" selected="ClassTime">&nbsp;&nbsp;3,4</option>
	               <option value="5,6" selected="ClassTime">&nbsp;&nbsp;5,6</option>
	               <option value="7,8" selected="ClassTime">&nbsp;&nbsp;7,8</option>
	               <option value="9,10" selected="ClassTime">&nbsp;&nbsp;9,10</option>
                  </select>
                </div>
				
				
				<div>
					<label for="ClassroomID">���ұ��:</label> <input type="text"
						name="ClassroomID" id="ClassroomID" value=<%=s.getClassroomID()%>/> <span>*</span>
				</div>
				<div>
					<label for="TCflag">״̬:</label> <input type="text"
						name="TCflag" id="TCflag" value=<%=s.getTCflag()%>> <span>*</span>
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