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
</head>
<body>
   <form action="updateBookServlet">
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">����λ�ã�ͼ�����</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form  action="">
	         <span>����Ա��</span>
	         <input type="text" name="" value="" class="text-word" style="height:23px">
	         <input name="" type="button" value="��ѯ" class="text-but" style="height:23px; width:55px">
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
       <th align="center" valign="middle" class="borderright">���</th>
       <th align="center" valign="middle" class="borderright">�����</th>
       <th align="center" valign="middle" class="borderright">����</th>
       <th align="center" valign="middle" class="borderright">����</th>
       <th align="center" valign="middle" class="borderright">�۸�</th>
       <th align="center" valign="middle" class="borderright">״̬</th>
       <th align="center" valign="middle" class="borderright">����</th>
    </tr>
    <%
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   //Str ing bid=new String(request.getParameter("bid").getBytes("ISO-8859-1"));
	   String bid=request.getParameter("bid");
       Vector<BooksDto> v = new Vector<BooksDto> ();
       v = (Vector<BooksDto>)session.getAttribute("allbook");
       Iterator it = v.iterator();
       BooksDto b = null;
       while(it.hasNext())
       {
    	   b = (BooksDto)it.next();
    	  if((b.getBookId()).equals(bid))
    	   {
    		  System.out.println("wwwwwww");
       
    %>
    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
    
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" readOnly="true" name="bid" value=<%=b.getBookId()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="bnum" value=<%= b.getBreference_number() %>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="bname" value=<%=b.getBookName()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="bauthor" value=<%= b.getBookauthor()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="bprice" value=<%=b.getBprice()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="bstate" value=<%= b.getBookstate() %>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="bmun" value=<%= b.getNum() %>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:72px;" type="submit" value="ȷ���޸�"></td>
       
    </tr>
    <%
    	  }
       } 
    %>
    </table>
    </form>

</body>
</html>