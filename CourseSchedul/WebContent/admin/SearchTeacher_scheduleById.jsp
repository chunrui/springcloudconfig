<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"   import="java.util.* , en.edu.lingnan.Dto.*" %>
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
<form action="searchTeacher_scheduleInfoServlet">
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
            <form action="searchTeacher_scheduleInfoServlet">
            <div class="search">
                <span>�û�����</span>
                <input type="text" name="TeacherID"  id="TeacherID" placeholder="�������ʦID���"/>
                <input name="submit" type="submit" style="height:33px; width:75px" value="��ѯ" >
                </form>
                <a href="addUser.jsp">��ӽ�ʦ�ο�</a>
            </div>
            <!--�û�-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th></th>
                    <th width="20%">��ʦ�οα���</th>
                    <th width="20%">��ʦ��</th>
                    <th width="20%">�γ̺�</th>                 
                    <th width="30%">����</th>
                </tr>
      
    <% 
    Vector<Teacher_scheduleDTO> v=new Vector<Teacher_scheduleDTO>();
    v = (Vector<Teacher_scheduleDTO>)session.getAttribute("allTeacher_scheduleInfo");//����ǿ������ת��
    Iterator it = v.iterator();
    Teacher_scheduleDTO ts=null;
    while(it.hasNext())
    {
		ts=(Teacher_scheduleDTO)it.next();	
 %>
 <tr>
       <td><input type="checkbox" name="check" value=<%=ts.getTsno() %>></td>
		<td><%=ts.getTsno() %></td>
		<td><%=ts.getTeacherID() %></td>
		<td><%=ts.getCourseID() %></td>
       <td><a href="ShowTeacher_scheduleInfoById.jsp?Tsno=<%=ts.getTsno() %>"><img src="img/read.png" alt="�鿴" title="�鿴"/></a>
       <a href="UpdateTeacher_scheduleInfo.jsp?TeacherID=<%=ts.getTeacherID() %>"><img src="img/xiugai.png" alt="�޸�" title="�޸�"/></a>
       <a href="deleteTeacher_scheduleInfoServlet?Tsno=<%=ts.getTsno() %>" class="removeUser"><img src="img/schu.png" alt="ɾ��" title="ɾ��"/></a>
       </td> 
 </tr>
    <%
    }
    %>
    </table>
    </form>
</body>
</html>