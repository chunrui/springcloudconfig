<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"  import="java.util.* , en.edu.lingnan.Dto.*" %>
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
                <li ><a href="searchAllMajorSchedule">רҵ�γ̱�����</a></li>
                <li ><a href="findTeacherCourseServlet">��ʦ�ſι���</a></li>
                <li ><a href="findClassScheduleServlet">�༶�ſι���</a></li>
                <li><a href="showpersonalInfo.jsp?UserID=<%=UserID%>">��������</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>���������ڵ�λ����:</strong>
            <span>�û�����ҳ�� >> �û��޸�ҳ��</span>
        </div>
        <div class="providerAdd">
        <form action="updateTeacher_scheduleServlet">
       <% 
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   String Tsno=request.getParameter("Tsno");
	   Vector<Teacher_scheduleDTO> v = new Vector<Teacher_scheduleDTO> ();
	    v = (Vector<Teacher_scheduleDTO>)session.getAttribute("allTeacher_scheduleInfo");
	    Iterator it = v.iterator();
	    Teacher_scheduleDTO tsdo = null;
	    while(it.hasNext())
	    {
	    	tsdo = (Teacher_scheduleDTO)it.next();
    	  System.out.println("+++++++++"+Tsno);
    	  if((tsdo.getTsno().trim()).equals(Tsno))
    	   {
    		  System.out.println("kkkkk");
    		//  System.out.println("-----------"+c.getRoomid());
       
    %>
                <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
                <div>
                    <label for="Tsno">�οα���ţ�</label>
                    <input type="text" readOnly="true" name="Tsno" value=<%=tsdo.getTsno() %>/>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="TeacherID">��ʦ��ţ�</label>
                    <input type="text" name="TeacherID" value=<%=tsdo.getTeacherID() %>/>
                    <span >*</span>
                </div>
                
                <div>
                    <label for="CourseID">�γ̱�ţ�</label>
                    <input type="text" name="CourseID" value=<%=tsdo.getCourseID() %>/>
                    <span >*</span>
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





