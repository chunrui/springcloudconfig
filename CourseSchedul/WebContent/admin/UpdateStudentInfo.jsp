<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
            <span>ѧ������ҳ�� >> ѧ���޸�ҳ��</span>
        </div>
        <div class="providerAdd">
        <form action="updateStudentInfoServlet">
       <% 
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   String StudentID=request.getParameter("StudentID");
	   Vector<StudentDTO> v=new Vector<StudentDTO>();
	   v = (Vector<StudentDTO>)session.getAttribute("allstudentinfo");
	   Iterator it=v.iterator();
	   StudentDTO s=null;
		while(it.hasNext()){
			s=(StudentDTO)it.next();
			if((s.getStudentID().trim()).equals(StudentID)){
    %>
                <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
                <div>
                    <label for="StudentID">ѧ���˺ţ�</label>
                    <input type="text" readOnly="true" name="StudentID" value=<%=s.getStudentID()%>/>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="StudentName">ѧ��������</label>
                    <input type="text" name="StudentName" value=<%=s.getStudentName()%>/>
                    <span >*</span>
                </div>
                
                <div>
                    <label for="ClassID">ѧ���༶�ţ�</label>
                    <input type="text" name="ClassID" value=<%=s.getClassID() %>>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="StudentAge">ѧ������:</label>
                    <input type="text" name="StudentAge" value=<%=s.getStudentAge() %>>
                    <span >*</span>
                </div>
                <div>
                    <label >ѧ���Ա�</label>
                    <select name="StudentSex" id="StudentSex">
	               <option value="��" selected="StudentSex">&nbsp;&nbsp;��</option>
	               <option value="Ů" selected="StudentSex">&nbsp;&nbsp;Ů</option>
                  </select>
                </div>
                
                 <div>
                    <label >��־λ��</label>
                    <select name="SIflag" id="StudentSex">
	               <option value="0" selected="SIflag">&nbsp;&nbsp;0</option>
	               <option value="1" selected="SIflag">&nbsp;&nbsp;1</option>
                  </select>
                </div>
               
                <div class="providerAddBtn">
                    <!--<a href="#">����</a>-->
                    <!--<a href="userList.html">����</a>-->
                    <input style="line-height:10px;height:30px;width:90px;"  type="submit" value="ȷ��">
                
                    <input type="button" value="����" onclick="history.back(-1)"/>
                </div>
                  <%
    	  }
       } 
    %>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>






