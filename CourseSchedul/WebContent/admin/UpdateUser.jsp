<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>�����˵�����ϵͳ</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--ͷ��-->

<header class="publicHeader">
    <h1>�����˵�����ϵͳ</h1>

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
            <span>�û�����ҳ�� >> �û��޸�ҳ��</span>
        </div>
        <div class="providerAdd">
        <form action="updateUserServlet">
       <% 
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   String cid=request.getParameter("cid");
	   Vector<UserDto> v = new Vector<UserDto> ();
	    v = (Vector<UserDto>)session.getAttribute("alluser");
	    Iterator it = v.iterator();
	    UserDto u = null;
	    while(it.hasNext())
	    {
	 	   u = (UserDto)it.next();
    	  System.out.println("+++++++++"+cid);
    	  if((u.getUserId().trim()).equals(cid))
    	   {
    		  System.out.println("kkkkk");
    		//  System.out.println("-----------"+c.getRoomid());
       
    %>
                <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
                <div>
                    <label for="userid">�û��˺ţ�</label>
                    <input type="text" readOnly="true" name="cid" value=<%=u.getUserId()%>/>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="password">�û����룺</label>
                    <input type="text" name="cpwd" value=<%=u.getPassword()%>/>
                    <span >*</span>
                </div>
                
                <div>
                    <label for="userName">�û����ƣ�</label>
                    <input type="text" name="cname" value=<%=u.getUserName()%>/>
                    <span >*</span>
                </div>

                <div>
                    <label >�û��Ա�</label>
                    <select name="csex" id="csex">
	               <option value="��" selected="csex">&nbsp;&nbsp;��</option>
	               <option value="Ů" selected="csex">&nbsp;&nbsp;Ů</option>
                  </select>
                </div>
               
                <div>
                    <label for="auth">�û�Ȩ�ޣ�</label>
                    <select name="cauth" id="csex">
	               <option value="1" selected="cauth">&nbsp;&nbsp;1</option>
	               <option value="2" selected="cauth">&nbsp;&nbsp;2</option>
	               <option value="3" selected="cauth">&nbsp;&nbsp;3</option>
                  </select>
                </div>
                 <div>
                    <label for="Uflag">��־λ��</label>
                    <select name="Uflag" id="Uflag">
	               <option value="0" selected="cauth">&nbsp;&nbsp;0</option>
	               <option value="1" selected="cauth">&nbsp;&nbsp;1</option>
	               
                  </select>
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
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>






