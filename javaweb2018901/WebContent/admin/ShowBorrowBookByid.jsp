<%@page import="en.edu.lingnan.Dao.BorrowBookDao"%>
<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.BorrowBookDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<link href="css/table.css" type="text/css" rel="stylesheet" />
<script>
    function allcheck()
    {
    	var checkobj = document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
    		checkobj[i].checked = true;
    }
    function allnotcheck()
    {
    	var checkobj = document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
    		checkobj[i].checked = false;
    }
    function backcheck()
    {
    	var checkobj = document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
    		if(checkobj[i].checked == true)
    			  checkobj[i].checked=false;
    		else
    			checkobj[i].checked=true;
    }
    function deletecheck()
    {
    	var checkobj = document.getElementsByName("check");
    	var arr=[];
    	var flag=false;
    	for(var i=0;i<checkobj.length;i++)
    		{
    		   if(checkobj[i].checked == true)
    			   {
    			   arr.push(checkobj[i].value);
    		       flag = true;
    		}
    		}
    	if(flag == true)
    		{
    		    if(confirm("��ȷ��Ҫɾ����Щ��¼��"))
    		    	   location.href="DeleteBorrowBookcheckServlet?arr="+arr;
    		    	
    		}
    	else
    		alert("������ѡ��һ����¼����ɾ��");
    	
    }
    
</script>
</head>
<body>
    <form action="findBorrowbookByidServlet">
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">����λ�ã�ͼ����Ĺ���</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form  action="findBorrowbookByidServlet">
	         <span>����Ա��</span>
	         <input type="text" name="Bbid"  id="bbid" class="text-word" style="height:23px;width:100px;"  placeholder="������ͼ��ID"  onFocus="this.value='';">
	         <input type="text" name="Bsid"  id="bsid" class="text-word" style="height:23px;width:100px;"  placeholder="�����������ID"  onFocus="this.value='';">
	         <input name="submit" type="submit" value="��ѯ" class="text-but" style="height:23px; width:55px">
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">��������Ա</a></td>
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
        <th align="center" valign="middle" class="borderright">����</th>
       
    </tr>
    <%
       Vector<BorrowBookDto> v = new Vector<BorrowBookDto> ();
       v = (Vector<BorrowBookDto>)session.getAttribute("allborrowbook");
       Iterator it = v.iterator();
       BorrowBookDto bb = null;
       while(it.hasNext())
       {
    	   bb = (BorrowBookDto)it.next();
    	   
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
      <td align="center" valign="middle" class="borderright borderbottom"><a href="updateBorrowBook.jsp?bbid=<%=bb.getBbid()%>&bcid=<%=bb.getBcid()%>">�޸�</a></td>
       <td align="center" valign="middle" class="borderright borderbottom"><a href="deleteBorrowBookServlet?bbid=<%=bb.getBbid()%>&bcid=<%=bb.getBcid()%>">����</a></td>
    </tr>
    <% 
       }
    %> 
    </table>
    </form>
</body>
</html>