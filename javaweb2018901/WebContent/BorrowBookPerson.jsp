 <%@page import="en.edu.lingnan.Dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>��Ҫ������main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link href="css/table.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />


<SCRIPT type="text/javascript">
//��֤�������ݺϷ��ĺ���
function check()
{
	if(form.bbid.value==""){
		alert("ͼ��Id����Ϊ��");
		form.bbid.focus();
		return false;
	}
	if(form.bsid.value==""){
		alert("���ı�Ų���Ϊ��");
		form.bsid.focus();
		return false;
	}
	if(form.borrowtime.value==""){
		alert("����ʱ��Ϊ��");
		form.borrowtime.focus();
		return false;
	}
	if(form.returntime.value==""){
		alert("����ʱ�䲻��Ϊ��");
		form.returntime.focus();
		return false;
	}
	if(form.duetime.value==""){
		alert("����ʱ�䲻��Ϊ��");
		form.duetime.focus();
		return false;
	}
	if(form.mun.value==""){
		alert("������������Ϊ��");
		form.mun.focus();
		return false;
	}
	if(form.state.value==""){
		alert("����״̬����Ϊ��");
		form.state.focus();
		return false;
	}
	if(form.fine.value==""){
		alert("�������Ϊ��");
		form.fine.focus();
		return false;
	}
	}
</SCRIPT>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">����λ�ã��û�����&nbsp;&nbsp;>&nbsp;&nbsp;�޸��û���Ϣ</td>
     <tr><td  style="text-align:right; width:150px;font-size:14px;"><a style="text-align:right; width:150px;font-size:15px;" href="person_mian.html" target="mainFrame" onFocus="this.blur()">����</a></td>
  </tr><tr>
      
  		 
  		
  <%  
  
 
  UserDto s = null;
  Vector<UserDto> v = new Vector<UserDto> ();
  v = (Vector<UserDto>)session.getAttribute("userinfo");
  Iterator it = v.iterator();
  String bsid = null;
  String bid = null;
  while(it.hasNext())
  {
	   s = (UserDto)it.next();
	  
	   bid=new String(request.getParameter("bid").getBytes("ISO-8859-1"));
	   System.out.println("----"+bid);
 %>
  
  <tr>
    <td align="left" valign="top">
    <form name="form" action="borrowBook_personServlet">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">ͼ���ţ�</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bbid"  id="bbid" class="text-word"  type="text" placeholder="" value=<%=bid%> ;">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">�����߱�ţ�</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bsid"   id="bsid" class="text-word"  type="text" placeholder="" value=<%=s.getAid() %> ;">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">����ʱ�䣺</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bborrowtime"  id="borrowtime" class="text-word"  type="text" placeholder="����ʱ��" value="" onFocus="this.value='';">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">����ʱ�䣺</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Breturntime"  readOnly="true" id="returntime" class="text-word"  type="text" placeholder="�����뻹��ʱ��" value="null" ';">
        </td>
        </tr>
        
        
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">����ʱ�䣺</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bduetime"  id="duetime" class="text-word"  type="text" placeholder="�����뵽��ʱ��" value="" onFocus="this.value='';">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">����������</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bbmun"  id="mun" class="text-word"  type="text" placeholder="�������������" value="" onFocus="this.value='';">
        </td>
        </tr>
       
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">����״̬��</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <select name="Bbstate" id="state">
	    <option value="δ�黹" selected="Bbstate">&nbsp;&nbsp;δ�黹</option>
        </select>
        </td>
      </tr>
        
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">�����</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bfine"  id="fine" class="text-word"  type="text" placeholder="�����뷣����" value="" onFocus="this.value='';">
        </td>
        
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <div class="submit"><input value="�ύ" type="submit" name="submit" onClick="return check();" style="background: rgb(0, 142, 200); padding: 8px 12px; border-radius: 4px; border: 2px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;">

        </div>
        </td>
        <%
  }
        %>
    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>