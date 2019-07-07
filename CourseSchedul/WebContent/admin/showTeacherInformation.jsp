<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="gb2312">
    <title>��У�ſ�ϵͳ</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--ͷ��-->
    <header class="publicHeader">
        <h1>��У�ſ�ϵͳ</h1>
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
                <span>�û�����ҳ��</span>
            </div>
            <form action="selectTeacherInformation">
                <div class="search">             
             		<span>��ʦ��ţ�</span>
             		<input type="text" name="TeacherID" id="TeacherID" placeholder="�������ʦ���"/>
                	<input type="submit" style="height:33px; width:75px" value="��ѯ"/>
             	</form>
                <a href="addTeacherInformation.jsp">��ӽ�ʦ</a>
            </div>
            <!--�û�-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th></th>
                    <th width="10%">��ʦ���</th>
                    <th width="20%">��ʦ����</th>
                    <th width="10%">��ʦ�Ա�</th>
                    <th width="10%">��ʦ�绰</th>
                    <th width="10%">��ʦ����</th>
                    <th width="10%">״̬</th>
                    <th width="25%">����</th>
                </tr>
                <%
					Vector<teacherInformationDTO> v = new Vector<teacherInformationDTO>();
					v = (Vector<teacherInformationDTO>) session.getAttribute("TeacherUser");
					Iterator it = v.iterator();
					teacherInformationDTO s = null;
					while (it.hasNext()) {
						s = (teacherInformationDTO) it.next();
				%>
				<tr>
				   <td><input type="checkbox" name="check" value="<%=s.getTeacherID()%>"></td>
					<td><%=s.getTeacherID()%></td>
					<td><%=s.getTeacherName()%></td>
					<td><%=s.getTeacherSex()%></td>
					<td><%=s.getTeacherTel()%></td>
					<td><%=s.getTeacherAge()%></td>
					<td><%=s.getTIflag()%></td>
					<td>
                        <a href="findTeacherInfoById?TeacherID=<%=s.getTeacherID()%>&flag=<%=0%>"><img src="img/read.png" alt="�鿴" title="�鿴"/></a>
                        <a href="findTeacherInfoById?TeacherID=<%=s.getTeacherID()%>&flag=<%=1%>"><img src="img/xiugai.png" alt="�޸�" title="�޸�"/></a>
                        <a href="deleteTeacherInformationServlet?TeacherID=<%=s.getTeacherID()%>"><img src="img/schu.png" alt="ɾ��" title="ɾ��"/></a>
                    </td>
				</tr>
				<%
					}
				%>
            </table>

        </div>
    </section>
    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>