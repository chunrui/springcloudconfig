<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="charset=GB2312">
    <title>�����˵�����ϵͳ</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<!--ͷ��-->
	<header class="publicHeader">
	<h1>��У�ſι���ϵͳ</h1>

	<div class="publicHeaderR">
		<p>
			<span>����ã�</span><span style="color: #fff21b"> Admin</span> , ��ӭ�㣡
		</p>
		<a href="../login.html">�˳�</a>
	</div>
	</header>
	<!--ʱ��-->
	<section class="publicTime"> <span id="time">2015��1��1��11:11
		����һ</span> <a href="#">��ܰ��ʾ��Ϊ���������������ʹ�ø߰汾���������IE10+��</a> </section>
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
                <li><a href="findPersonalInfoServlet">��������</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>���������ڵ�λ����:</strong> <span>���¿γ̱����ҳ��</span>
		</div>
		<div class="search"></div>
    <form action="insertClassScheduleServlet">
    <div class="providerAdd">
    <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
                <div>
                    <label for="cid">�γ̱��ţ�</label>
                    <input type="text" name="ClassScheduleID" />
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="useid">�༶��ţ�</label>
                    <input type="text" name="ClassID" >
                    <span >*</span>
                </div>
                
                  <div>
                    <label for="useid">�γ̱�ţ�</label>
                    <input type="text" name="CourseID" >
                    <span >*</span>
                </div>
                
                <div>
                    <label for="weekday">����**��</label>
                    <select name="WeekDay" id="WeekDay">
	               <option value="����һ" selected="weekday">&nbsp;&nbsp;����һ</option>
	               <option value="���ڶ�" selected="weekday">&nbsp;&nbsp;���ڶ�</option>
	               <option value="������" selected="weekday">&nbsp;&nbsp;������</option>
	               <option value="������" selected="weekday">&nbsp;&nbsp;������</option>
	               <option value="������" selected="weekday">&nbsp;&nbsp;������</option>
	               <option value="������" selected="weekday">&nbsp;&nbsp;������</option>
	               <option value="������" selected="weekday">&nbsp;&nbsp;������</option>
                  </select>
                </div>

                <div>
                    <label >������</label>
                    <select name="ClassTime" id="classtime">
	               <option value="12��" selected="ClassTime">&nbsp;&nbsp;12��</option>
	               <option value="34��" selected="ClassTime">&nbsp;&nbsp;34��</option>
	               <option value="56��" selected="ClassTime">&nbsp;&nbsp;56��</option>
	               <option value="78��" selected="ClassTime">&nbsp;&nbsp;78��</option>
                  </select>
                </div>
               
               <div>
                    <label for="TeacherID">��ʦ��ţ�</label>
                    <input type="text"  name="TeacherID" />
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="ClassroomID">���ұ�ţ�</label>
                    <input type="text" name="ClassroomID" >
                    <span >*</span>
                </div>     
                <div class="providerAddBtn">
                    <!--<a href="#">����</a>-->
                    <!--<a href="userList.html">����</a>-->
                    <input style="line-height:10px;height:30px;width:90px;" type="submit" value="ȷ��">
                
                    <input type="button" value="����" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
</body>
</html>