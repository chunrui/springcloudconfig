<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��ʦҳ����ҳ</title>
 <link rel="stylesheet" href="css/public.css"/>
 <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--ͷ��-->
<% String userid=(String)session.getAttribute("user"); %>
<header class="publicHeader">
    <h1>��У�ſι���ϵͳ</h1>

    <div class="publicHeaderR">
        <p><span>����ã�</span><span style="color: #fff21b"> Admin</span> , ��ӭ�㣡</p>
        <a href="../login.html">�˳�</a>
    </div>
</header>
<!--ʱ��-->
<section class="publicTime">
    <span id="time">2015��1��1�� 11:11  ����һ</span>
    <a href="#">��ܰ��ʾ��Ϊ���������������ʹ�ø߰汾���������IE10+��</a>
</section>
<!--��������-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>�����б� <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="ATeacherCourseView.jsp?userid=<%=userid%>">��ʦ�ڿα�</a></li>
                <li><a href="TeacherPersonInfoView.jsp?userid=<%=userid%>">������Ϣ</a></li>
               
                <li><a href="TeaInfoUpdate.jsp?userid=<%=userid%>">��Ϣ�޸�</a></li>
                <li><a href="http://localhost:8080/CourseSchedul/login.html">�˳�ϵͳ</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <img class="wColck" src="img/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>Admin</h2>
            <p>��ӭ������У�ſι���ϵͳ!</p>
			<span id="hours"></span>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
<div style="text-align:center;">
<p>����ģ�壺<a href="http://www.mycodes.net/" target="_blank">Դ��֮��</a></p>
</div>
</body>
</html>