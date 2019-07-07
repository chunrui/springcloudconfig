<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.BooksDto"%>
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
    		    	   location.href="DeleteBookcheckServlet?arr="+arr;
    		    	
    		}
    	else
    		alert("������ѡ��һ����¼����ɾ��");
    	
    }
    
</script>
</head>
<body>
     <form action="findBookByidServlet">
   <table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">����λ�ã�ͼ�����</td>
  </tr>
  <tr>
    <td align="left" valign="top">
   <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form  action="findBookByidServlet">
	         <span>����Ա��</span>
	         <input type="text" name="Bid"  id="bid" class="text-word" style="height:23px" >
	         <input name="submit" type="submit" value="��ѯ" class="text-but" style="height:23px; width:55px">
	         </form>
	         <input type="button" style="height:23px;width:55px;margin-left:100px" id="btn1" value="ȫѡ" onClick="allcheck();"/>
             <input type="button" style="height:23px;width:55px;margin-left:30px" id="btn2" value="��ѡ" onClick="allnotcheck();"/>
             <input type="button" style="height:23px;width:55px;margin-left:30px" id="btn3" value="��ѡ" onClick="backcheck();"/>
             <input type="button" style="height:23px;width:64px;margin-left:30px" id="btn2" value="����ɾ��" onClick="deletecheck();"/>
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
        <th align="center" valign="middle" class="borderright">�����</th>
        <th align="center" valign="middle" class="borderright">����</th>
        <th align="center" valign="middle" class="borderright">����</th>
        <th align="center" valign="middle" class="borderright">�۸�</th>
        <th align="center" valign="middle" class="borderright">״̬</th>
        <th align="center" valign="middle" class="borderright">����</th>
        <th align="center" valign="middle">����</th>
        <th valign="middle">����</th>
      </tr>
    <%
       Vector<BooksDto> v = new Vector<BooksDto> ();
       v = (Vector<BooksDto>)session.getAttribute("allbook");
       Iterator it = v.iterator();
       BooksDto b = null;
       while(it.hasNext())
       {
    	   b = (BooksDto)it.next();
    %>
     <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
     
       <td align="center" valign="middle" class="borderright borderbottom"><input type="checkbox" name="check" value="<%=b.getBookId() %>"></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=b.getBookId()%></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= b.getBreference_number() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=b.getBookName()%></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= b.getBookauthor()%></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=b.getBprice()%></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= b.getBookstate() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= b.getNum() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><a href="updateBook.jsp?bid=<%=b.getBookId()%>">�޸�</a></td>
       <td align="center" valign="middle" class="borderright borderbottom"><a href="deleteBookServlet?bid=<%=b.getBookId()%>">ɾ��</a></td>
    </tr>
    <% 
       }
    %>
    </table>
    </form>
</body>
</html>