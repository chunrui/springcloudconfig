<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>

<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />

</head>
<body>
<div class="header">

		<p>学号：${user_id }   &nbsp;&nbsp;姓名：${user_name } </p>

		<div class="contact"><a href="LoginOut" style="text-decoration: none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;退出</a></div>

</div>
<div class="header1">
		<p>生物判题考试管理系统</p>
		<div class="w2">
		<ul>
			<li><a href="http://localhost:8080/ExamSys/teachers/manage_students.jsp">教学公告</a></li>
			<li><a href="question_bankServlet?action=showEM&user_id=${user.user_id }">试题资源</a></li>
			<li><a href="tstudent_management?action=showStuClass2&user_id=${user.user_id }">学生管理</a></li>
			<li><a href="tstudent_management?action=showCl&user_id=${user.user_id }">统计管理</a></li>
			<li><a href="tstudent_management?action=showUser&user_id=${user.user_id }&user_name=${user.user_name }&user_pwd=${user.user_pwd}">修改密码</a></li>
		</ul>
				
		</div>

</div>
<!-- header结束 -->
<div class="m1">

 	<div class="round1"><a href="#">修改密码</a></div>
</div>
<div id="container">
<div id="findstu">

	<table class="providerTable" cellpadding="0" cellspacing="0">
	                
                
       				

       			<tr class="firstTr">                                     
                    <th style="text-align:left;">账号:${user_id}</th>                  
                </tr>
                <tr class="firstTr">                                     
                     <th style="text-align:left;">用户名:${user_name}</th>              
                </tr>
                <tr class="firstTr">                                     
                     <th style="text-align:left;">
                 <form action="tstudent_management?action=updateUserPwd&user_id=${user_id}&user_name=${user_name}" method="post">
						密码：<input type="text" name="user_pwd" placeholder="${user_pwd}">
            			<input type="submit" class="bt" value="确认修改"/>
				</form>	
				</th>	              
                </tr>
				 
            </table>
          

</div>
</div>



</body>
</html>