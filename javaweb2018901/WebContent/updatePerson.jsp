<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.UserDto" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>��Ҫ������main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link href="css/table.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<link href="css/addstyle.css" type="text/css" rel="stylesheet" />

<SCRIPT type="text/javascript">
//��֤�������ݺϷ��ĺ���
function check()
{
	if(form.sid.value==""){
		alert("����ID�Ų���Ϊ��");
		form.aid.focus();
		return false;
	}
	if(form.sname.value==""){
		alert("������������Ϊ��");
		form.username.focus();
		return false;
	}
	if(form.sage.value==""){
		alert("�������䲻��Ϊ��");
		form.password.focus();
		return false;
	}
	if(form.sex.value==""){
		alert("�����Ա���Ϊ��");
		form.password.focus();
		return false;
	}
	if(form.classid.value==""){
		alert("���߰����Ϊ��");
		form.password.focus();
		return false;
	}
	if(form.dep.value==""){
		alert("����Ժϵ����Ϊ��");
		form.password.focus();
		return false;
	}
	}
</SCRIPT>
</head>
<body>
<!--main_top-->
 <form name="form" action="addpersonServlet">
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">����λ�ã��û�����&nbsp;&nbsp;>&nbsp;&nbsp;��Ӷ���</td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
    <a href="addstudent.html" target="mainFrame" onFocus="this.blur()" class="add">��������</a>
    </td>
  </tr>
  <%
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   //String aid=new String(request.getParameter("aid").getBytes("ISO-8859-1"));
       //String aid = request.getParameter("aid");
       UserDto s = null;
       Vector<UserDto> v = new Vector<UserDto> ();
       v = (Vector<UserDto>)session.getAttribute("user");
       Iterator it = v.iterator();
       while(it.hasNext())
       {
    	   s = (UserDto)it.next();
    %>
  <tr>
  
    <td align="left" valign="top">
   
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">���߱�ţ�</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sid"  id="sid" class="text-word"  type="text"  value=<%=s.getAid()%> onFocus="this.value='';">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">����������</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sname"  id="sname" class="text-word"  type="text" placeholder="�������������" value="" onFocus="this.value='';">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">�������䣺</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sage"  id="sage" class="text-word"  type="text" placeholder="�������������" value="" onFocus="this.value='';">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">�û��Ա�</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <select name="Ssex" id="sex">
	    <option value="��" selected="Ssex">&nbsp;&nbsp;��</option>
	    <option value="Ů" selected="Ssex">&nbsp;&nbsp;Ů</option>
        </select>
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">���߰��</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sclassid"  id="classid" class="text-word"  type="text" placeholder="��������߰��" value="" onFocus="this.value='';">
        </td>
        
         <td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">����Ժϵ��</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sdepartment"  id="dep" class="text-word"  type="text" placeholder="���������Ժϵ" value="" onFocus="this.value='';">
        </td>
        
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <div class="submit"><input value="�ύ" type="submit" name="submit" onClick="return check();" style="background: rgb(0, 142, 200); padding: 8px 12px; border-radius: 4px; border: 2px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;">
  <%
       }
  %>
        </div>
        </td>
    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>