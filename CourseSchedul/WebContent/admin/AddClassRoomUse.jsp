<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*, en.edu.lingnan.Dao.*" %>
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
            <span>�û�����ҳ�� >> ����ʹ��״̬���ҳ��</span>
        </div>
        <div class="providerAdd">
            <form action="addClassRoomUseServlet">
                <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
               <div>
                    <label for="cid">����ʹ��״̬��ţ�</label>
                    <input type="text" name="cid"/>
                    <span >*���벻�ظ�����ʹ��״̬���</span>
                </div>
                
                 <div>
                    <label for="useid">���ұ�ţ�</label>
                    <input type="text" name="useid" >
                    <span >*</span>
                </div>
              
                <div>
                    <label for="weekday">���ڣ�</label>
                    <select name="weekday" id="weekday">
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
                    <select name="classtime" id="classtime">
	               <option value="1,2" selected="classtime">&nbsp;&nbsp;1,2</option>
	               <option value="3,4" selected="classtime">&nbsp;&nbsp;3,4</option>
	               <option value="5,6" selected="classtime">&nbsp;&nbsp;5,6</option>
	               <option value="7,8" selected="classtime">&nbsp;&nbsp;7,8</option>
	               <option value="9,10" selected="classtime">&nbsp;&nbsp;9,10</option>
                  </select>
                </div>
               
                <div>
                    <label for="cstate">״̬��</label>
                    <select name="cstate" id="cstate">
	               <option value="����" selected="cstate">&nbsp;&nbsp;����</option>
	               <option value="��ռ��" selected="cstate">&nbsp;&nbsp;��ռ��</option>
                  </select>
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