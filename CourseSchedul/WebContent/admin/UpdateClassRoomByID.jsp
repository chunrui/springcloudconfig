<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
    <title>��У�ſι���ϵͳ</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--ͷ��-->
<form action="updateClassRoomServlet">
<header class="publicHeader">
        <h1>��У�ſι���ϵͳ</h1>
        <div class="publicHeaderR">
            <p><span>����ã�</span><span style="color: #fff21b"> Admin</span> , ��ӭ�㣡</p>
            <a href="../login.html">�˳�</a>
        </div>
    </header>
<!--ʱ��-->
<%String UserID=(String)session.getAttribute("user"); %>
    <section class="publicTime">
        <span id="time">2015��1��1�� 11:11  ����һ</span>
        <a href="#">��ܰ��ʾ��Ϊ���������������ʹ�ø߰汾���������IE10+��</a>
    </section>
<!--��������-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>�����б� <span></span></h2>
            <nav>
                <ul class="list">
               <li ><a href="findAllUserServlet">�û���Ϣ����</a></li>
                <li ><a href="findStudentInfoServlet">ѧ����Ϣ����</a></li>
                <li ><a href="findTeacherInformationServlet">��ʦ��Ϣ����</a></li>
                <li ><a href="findAllTeacher_scheduleInfoServlet">��ʦ�ο���Ϣ����</a></li>
                <li ><a href="findAllClassRoomServlet">������Ϣ����</a></li>
                <li ><a href="findAllClassRoomUseServlet">����ʹ��״̬</a></li>
                <li ><a href="findClassIfoServlet">�༶��Ϣ����</a></li>
                <li ><a href="findMajorIfoServlet">רҵ��Ϣ����</a></li>
                <li ><a href="searchAllMajorSchedule">רҵ�γ̱����</a></li>
                <li ><a href="findTeacherCourseServlet">��ʦ�ſι���</a></li>
                <li ><a href="findClassScheduleServlet">�༶�ſι���</a></li>
                <li><a href="showpersonalInfo.jsp?UserID=<%=UserID%>">��������</a></li>
                </ul>
            </nav>
        </div>
       
    
        <div class="right">
            <div class="location">
                <strong>���������ڵ�λ����:</strong>
                <span>�û�����ҳ��</span>
            </div>
            <form action="updateClassRoomServlet">
            <div class="search">
                <span>�û�����</span>
                <input type="text" name="Cid"  id="cid" placeholder="�������û�ID���"/>
                <input name="submit" type="submit" style="height:33px; width:75px" value="��ѯ" >
                </form>
                <a href="addUser.jsp">����û�</a>
            </div>
            <!--�û�-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                 
    <% 
    request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   
	   String cid=request.getParameter("cid");
	   Vector<ClassRoomDto> v = new Vector<ClassRoomDto> ();
    v = (Vector<ClassRoomDto>)session.getAttribute("allclassroom");
    Iterator it = v.iterator();
    ClassRoomDto c = null;
    //System.out.println("wwwwwww");
    while(it.hasNext())
    {
 	  c = (ClassRoomDto)it.next();
 	  System.out.println("---------"+c.getRoomid());
 	  System.out.println("+++++++++"+cid);
 	  if((c.getRoomid().trim()).equals(cid))
 	   {
 		  System.out.println("kkkkk");
 		//  System.out.println("-----------"+c.getRoomid());
 %>
 <div class="right">
        <div class="location">
            <strong>���������ڵ�λ����:</strong>
            <span>�û�����ҳ�� >> ������Ϣ�޸�</span>
        </div>
        <div class="providerAdd">
  <div>
                    <label for="cid">���ұ�ţ�</label>
                    <input type="text" readOnly="true" name="cid" value=<%=c.getRoomid() %>/>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="cname">�������ƣ�</label>
                    <input type="text" name="cname" value=<%=c.getRoomname() %>>
                    <span >*</span>
                </div>
                <div>
                    <label >�������ͣ�</label>
                    <select name="ctype" id="ctype">
	               <option value="��ͨ����" selected="ctype">&nbsp;&nbsp;��ͨ����</option>
	               <option value="��ý�����" selected="ctype">&nbsp;&nbsp;��ý�����</option>
                  </select>
                </div>
                <div>
                    <label for="maxnum">�����������</label>
                    <input type="text" name="maxnum" value=<%=c.getMaxnum() %>>
                    <span >*</span>
                </div>
               
               
                <div class="providerAddBtn">
                    <!--<a href="#">����</a>-->
                    <!--<a href="userList.html">����</a>-->
                    <input style="line-height:10px;height:30px;width:90px;" type="submit" value="ȷ��">
                
                    <input type="button" value="����" onclick="history.back(-1)"/>
                </div>
                  <%
    	  }
       } 
    %>
    </table>
    </form>
</body>
</html>

