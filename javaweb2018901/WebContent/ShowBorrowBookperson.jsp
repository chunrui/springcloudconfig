<%@page import="en.edu.lingnan.Dao.BorrowBookDao"%>
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
</head>
<body>
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">����λ�ã�ͼ����Ĳ鿴</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
	          <tr>
   		 <td width="90%" align="left" valign="middle">
	          
	         <span>�û���</span>
	         <input type="text" name="Bid"  id="bid" class="text-word" style="height:23px" >
	         <input name="submit" type="submit" value="��ѯ" class="text-but" style="height:23px; width:55px">
	      
         </td>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="person_mian.html" target="mainFrame" onFocus="this.blur()" class="add">����</a></td>
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
        <th align="center" valign="middle" class="borderright">�����߱��</th>
        <th align="center" valign="middle" class="borderright">����ʱ��</th>
        <th align="center" valign="middle" class="borderright">����ʱ��</th>
        <th align="center" valign="middle" class="borderright">����ʱ��</th>
        <th align="center" valign="middle" class="borderright">��������</th>
        <th align="center" valign="middle" class="borderright">����״̬</th>
        <th align="center" valign="middle" class="borderright">������</th>
        <th align="center" valign="middle" class="borderright">����</th>
    </tr>
  <%  
    Vector<UserDto> v = new Vector<UserDto> ();
    
    String aid = null;
    UserDto a=null;
    v = (Vector<UserDto>)session.getAttribute("pwd");
    Iterator it =v.iterator();
    while(it.hasNext())
    {
 	   a = (UserDto)it.next();
 	   aid=a.getAid();
    }
    Vector<BorrowBookDto> v1 = new Vector<BorrowBookDto> ();
    BorrowBookDao sdo= new BorrowBookDao();
    BorrowBookDto bb = null;
    v1=sdo.findaBorrowBookBysid(aid);
    Iterator it1 =v1.iterator();
 	  while(it1.hasNext())
 	  {
 		// StudentDto s = null; 
 		bb=(BorrowBookDto)it1.next();
 %>
  
   <tr>
       <td align="center" valign="middle" class="borderright borderbottom"><input type="checkbox" name="check" value="<%=bb.getBbid() %>+<%=bb.getBcid() %>"></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=bb.getBbid() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=bb.getBcid() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=bb.getBorrowtime()%></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=bb.getBreturntime() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=bb.getBduetime() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=bb.getBmun() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=bb.getBreturnstate() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=bb.getBfine() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><a href="returnBookPersonServlet?bbid=<%=bb.getBbid()%>&bcid=<%=bb.getBcid()%>">����</a></td>
    </tr>
    <% 
       }
    %> 
   
    </table>
    </form>
</table>
</body>
</html>