<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��ʦ������Ϣ�޸�</title>
 <link rel="stylesheet" href="css/public.css"/>
 <link rel="stylesheet" href="css/style.css"/>
</head>
<script type="text/javascript">
function check(){
	if(form.TeacherName.value==""){
		alert("��ʦ��������Ϊ��");
		form.TeacherName.focus();
		return false;
	}
	if(form.TeacherSex.value==""){
		alert("��ʦ�Ա���Ϊ��");
		form.TeacherSex.focus();
		return false;
	}
	if(form.TeacherTel.value==""){
		alert("��ʦ�ֻ����벻��Ϊ��");
		form.TeacherTel.focus();
		return false;
	}
	if(form.TeacherAge.value==""){
		alert("��ʦ���䲻��Ϊ��");
		form.TeacherAge.focus();
		return false;
	}
	if(form.TeacherPwd.value==""){
		alert("��ʦ��¼���벻��Ϊ��");
		form.TeacherPwd.focus();
		return false;
	}
        alert("����ɹ���");}	
</script>
<body>
<!--ͷ��-->
<% String userid = request.getParameter("userid");
%>
<header class="publicHeader">
    <h1>��У�ſι���ϵͳ</h1>

    <div class="publicHeaderR">
        <p><span>����ã�</span><span style="color: #fff21b"> Admin</span> , ��ӭ�㣡</p>
        <a href="../login.html">�˳�</a>
    </div>
</header>
<!--ʱ��-->
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
               <li ><a href="ATeacherCourseView.jsp?userid=<%=userid%>">��ʦ�ڿα�</a></li>
                <li><a href="TeacherPersonInfoView.jsp?userid=<%=userid%>">������Ϣ</a></li>              
                <li><a href="TeaInfoUpdate.jsp?userid=<%=userid%>">��Ϣ�޸�</a></li>
                <li><a href="http://localhost:8080/CourseSchedul/login.html">�˳�ϵͳ</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>���������ڵ�λ����:</strong>
            <span>��ʦҳ�� >> ��Ϣ�޸�ҳ��</span>
        </div>
        <div class="providerAdd">
            <form action="teaInfoUpdate" name="form">
            
            <%
            TeacherInformationDAO1 tdao = new TeacherInformationDAO1();
			Vector <teacherInformationDTO> v = new Vector<teacherInformationDTO> ();
			v=tdao.findATeaInfoByID(userid);
            Iterator it = v.iterator();
            teacherInformationDTO t = null;
            while(it.hasNext()){
	             t = (teacherInformationDTO)it.next();
         %>
         <%
            UserInformationDAO udao = new UserInformationDAO();
			Vector <UserInformationDTO> v1 = new Vector<UserInformationDTO> ();
			v1=udao.FindAUserInfoByID(userid);
            Iterator it1 = v1.iterator();
            UserInformationDTO u = null;
            while(it1.hasNext()){
    	    System.out.println(userid);
	        u = (UserInformationDTO)it1.next();
         %>
                        
                <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
                       <div class="">
                   <label for="providerId">��ʦID:</label>
                    <input type="text" name="TeacherID" readOnly="true" id="providerId" value=<%=t.getTeacherID() %> />
                    <span>*</span>
                     </div> 
                <div>
                    <label for="providerName">��ʦ����:</label>
                    <input type="text" name="TeacherName" id="providerName" value=<%=t.getTeacherName() %> >
                    <span >*</span>
                </div>
                <div>
                    <label for="people">��ʦ�Ա�:</label>
                    <input type="text" name="TeacherSex" id="people" value=<%=t.getTeacherSex() %>/>
                    <span>*</span>

                </div>
                <div>
                    <label for="phone">��ʦ�ֻ�����:</label>
                    <input type="text" name="TeacherTel" id="phone" value=<%=t.getTeacherTel() %>/>
                    <span></span>
                </div>
                <div>
                    <label for="address">��ʦ����:</label>
                    <input type="text" name="TeacherAge" id="address" value=<%=t.getTeacherAge() %>>
                    <span></span>

                </div>
                <div>
                    <label for="fax">��ʦ��¼����:</label>
                    <input type="text" name="TeacherPwd" id="fax" value=<%=u.getUserPsw() %>/>
                    <span></span>

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">����</a>-->
                    <!--<a href="providerList.html">����</a>-->
                    <input type="submit" onClick="return check();" value="����" />
                    <a href="http://localhost:8080/CourseSchedul/ok.jsp?userid=<%=userid %>"><input type="button" value="����" /></a>
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
</html>