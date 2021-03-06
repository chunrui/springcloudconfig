<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>高校排课管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>高校排课管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b">Student</span> , 欢迎你！</p>
        <a href="../login.html">退出</a>
    </div>
</header>
<!--时间-->
<% String UserID=(String)session.getAttribute("user"); %>
<section class="publicTime">
    <span id="time">2018年6月21日 10:11  星期四</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">                
                <li ><a href="showclassschedule.jsp?UserID=<%=UserID%>">班级课表</a></li>
                <li ><a href="showstudentInfo.jsp?UserID=<%=UserID%>">个人信息</a></li>
                <li><a href="changInformation.jsp?UserID=<%=UserID%>">信息修改</a></li>
                <li><a href="../login.html">退出系统</a></li>
            </ul>
        </nav>
    </div>
    </div>
    </div>
    <div class="right">
        <img class="wColck" src="img/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>Student</h2>
            <p>高校排课管理管理系统!</p>
			<span id="hours"></span>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
</body>
</html>