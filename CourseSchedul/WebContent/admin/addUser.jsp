<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="charset=GB2312">
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
            <span>�û�����ҳ�� >> �û����ҳ��</span>
        </div>
        <div class="providerAdd">
            <form action="addUserServlet">
                <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
                <div class="">
                    <label for="userId">�û����룺</label>
                    <input type="text" name="userId" id="userId"/>
                    <span>*�������û����룬�Ҳ����ظ�</span>
                </div>
                
                <div>
                    <label for="userName">�û����ƣ�</label>
                    <input type="text" name="userName" id="userName"/>
                    <span >*�������û�����</span>
                </div>
                <div>
                    <label for="userpassword">�û����룺</label>
                    <input type="text" name="userpassword" id="userpassword"/>
                    <span>*���볤�ȱ������6λС��20λ</span>

                </div>
                <div>
                    <label for="userRemi">ȷ�����룺</label>
                    <input type="text" name="userRemi" id="userRemi"/>
                    <span>*������ȷ������</span>
                </div>
                 <div>
                    <label >�û��Ա�</label>
                    <select name="csex" id="csex">
	               <option value="��" selected="csex">&nbsp;&nbsp;��</option>
	               <option value="Ů" selected="csex">&nbsp;&nbsp;Ů</option>
                  </select>
                </div>
                <div>
                    <label for="auth">�û�Ȩ�ޣ�</label>
                    <select name="cauth" id="csex">
	               <option value="1" selected="cauth">&nbsp;&nbsp;����Ա</option>
	               <option value="3" selected="cauth">&nbsp;&nbsp;ѧ��</option>
	               <option value="2" selected="cauth">&nbsp;&nbsp;��ʦ</option>
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