<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.StudentDto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��Ҫ������main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<link href="css/table.css" type="text/css" rel="stylesheet" />
</head>
<body>
   <form action="findstudentByIdServlet">
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">����λ�ã����߹���</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form  action="findstudentByIdServlet">
	         <span>����Ա��</span>
	         <input type="text" name="Sid"  id="sid" class="text-word" style="height:23px" >
	         <input name="submit" type="submit" value="��ѯ" class="text-but" style="height:23px; width:55px">
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="#" target="mainFrame" onFocus="this.blur()" class="add"></a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
    <tr>
        <td></td>
        <th align="center" valign="middle" class="borderright">���</th>
        <th align="center" valign="middle" class="borderright">����</th>
        <th align="center" valign="middle" class="borderright">����</th>
        <th align="center" valign="middle" class="borderright">�Ա�</th>
        <th align="center" valign="middle" class="borderright">���</th>
        <th align="center" valign="middle" class="borderright">ѧԺ</th>
        <th align="center" valign="middle" class="borderright">����</th>
        <th align="center" valign="middle" class="borderright">����</th>
      </tr>
    <%
    Vector<StudentDto> v = new Vector<StudentDto> ();
    v = (Vector<StudentDto>)session.getAttribute("allstudent");
    Iterator it = v.iterator();
    StudentDto s = null;
    while(it.hasNext())
    {
 	   s = (StudentDto)it.next();
 %>
  <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
    <td align="center" valign="middle" class="borderright borderbottom"><input type="checkbox" name="check" value="<%= s.getSid() %>"></td>
    <td align="center" valign="middle" class="borderright borderbottom"><%= s.getSid() %></td>
    <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentname() %></td>
    <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentage() %></td>
    <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentsex() %></td>
    <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentclass() %></td>
    <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentdep() %></td>
    <td align="center" valign="middle" class="borderright borderbottom"><a href="UpdateStudent.jsp?sid=<%=s.getSid()%>">�޸�</a></td>
    <td align="center" valign="middle" class="borderright borderbottom"><a href="deleteStudentServlet?sid=<%=s.getSid()%>">ɾ��</a></td>
 </tr>
    <% 
       }
    %>
    
    </table>
    </form>
</body>
</html>