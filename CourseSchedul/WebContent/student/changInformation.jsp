<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="GB2312">
    <title>��У�ſι���ϵͳ</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<script type="text/javascript">
function check(){
	if(form.StudentName.value==""){
		alert("ѧ����������Ϊ��");
		form.StudentName.focus();
		return false;
	}
	if(form.StudentSex.value==""){
		alert("ѧ���Ա���Ϊ��");
		form.StudentSex.focus();
		return false;
	}
	if(form.ClassID.value==""){
		alert("ѧ���༶����Ϊ��");
		form.ClassID.focus();
		return false;
	}
	if(form.StudentAge.value==""){
		alert("ѧ�����䲻��Ϊ��");
		form.StudentAge.focus();
		return false;
	}
	if(form.UserPsw.value==""){
		alert("ѧ�����벻��Ϊ��");
		form.UserPsw.focus();
		return false;
	}
        alert("����ɹ���");}	
</script>
<body>
<!--ͷ��-->

<header class="publicHeader">
    <h1>��У�ſι���ϵͳ</h1>

    <div class="publicHeaderR">
        <p><span>����ã�</span><span style="color: #fff21b"> Admin</span> , ��ӭ�㣡</p>
        <a href="../login.html">�˳�</a>
    </div>
</header>
<!--ʱ��-->
<% String UserID=request.getParameter("UserID"); %>
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
                <li ><a href="showclassschedule.jsp?UserID=<%=UserID%>">�༶�α�</a></li>
                <li ><a href="showstudentInfo.jsp?UserID=<%=UserID%>">������Ϣ</a></li>
                <li><a href="changInformation.jsp?UserID=<%=UserID%>">��Ϣ�޸�</a></li>
                <li><a href="../login.html">�˳�ϵͳ</a></li>
            </ul>
        </nav>    
    </div>
    <div class="right">
        <div class="location">
            <strong>���������ڵ�λ����:</strong>
            <span>��Ϣ�޸�ҳ�� </span>
        </div>   
        <div class="providerAdd">
        <form action="updateInfoServlet" name="form">
          <% 
   	StudentDAO sdo = new StudentDAO();  	
    System.out.println(UserID+"55555");	
    Vector<StudentDTO> v=new Vector<StudentDTO>();
	v=sdo.findStudentInfoById(UserID);
	StudentDTO s=null;
	Iterator it=v.iterator();			
	while(it.hasNext())
   {
	   s = (StudentDTO)it.next();	   
	  //if((s.getStudentID().trim()).equals(UserID)){ 
 %>
 
 <% 
   	UserDao udao = new UserDao();  		
    Vector<UserDto> v1=new Vector<UserDto>();
	v1=udao.finduserInfoByid(UserID);
	UserDto u=null;
	Iterator it1=v1.iterator();			
	while(it1.hasNext())
   {
	   u = (UserDto)it1.next();	   
 %>
                <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
              <div class="">
                   <label for="providerId">ѧ�����:</label>
                    <input type="text" name="StudentID" readOnly="true" id="providerId" value=<%=s.getStudentID() %> />
                    <span>*</span>
                     </div> 
                <div>
                    <label for="providerName">ѧ������:</label>
                    <input type="text" name="StudentName" id="providerName" value=<%=s.getStudentName() %> >
                    <span >*</span>
                </div>
                <div>
                    <label for="people">ѧ���Ա�:</label>
                    <input type="text" name="StudentSex" id="people" value=<%=s.getStudentSex() %>/>
                    <span>*</span>

                </div>
                <div>
                    <label for="phone">�༶���:</label>
                    <input type="text" name="ClassID" id="phone" value=<%=s.getClassID() %>/>
                    <span></span>
                </div>
                <div>
                    <label for="address">ѧ������:</label>
                    <input type="text" name="StudentAge" id="address" value=<%=s.getStudentAge() %>>
                    <span></span>

                </div>
                <div>
                    <label for="fax">ѧ������:</label>
                    <input type="text" name="UserPsw" id="fax" value=<%=u.getPassword() %>/>
                    <span></span>

                </div>
               
                <div class="providerAddBtn">
                    <!--<a href="#">����</a>-->
                    <!--<a href="userList.html">����</a>-->
                    <input style="line-height:10px;height:30px;width:90px;"  type="submit" onClick="return check();" value="ȷ��">
                
                    <input type="button" value="����" onclick="history.back(-1)"/>
                </div>
<%
  } 
 %>
   <%
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






