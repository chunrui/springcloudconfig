<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>���רҵ�γ�</title>
<link rel="stylesheet" href="css/public.css"/>
<link rel="stylesheet" href="css/style.css"/>
</head>
<script type="text/javascript">
function check(){
	if(form.CourseID.value==""){
		alert("�γ�ID����Ϊ��");
		form.CourseID.focus();
		return false;
	} 
	if(form.MajorID.value==""){
		alert("רҵID����Ϊ��");
		form.MajorID.focus();
		return false;
	}
	//var regm1= /^(����)/
	//var regm1= /^[a-zA-Z_]+[a-zA-Z0-9]+$/
	//if(!form.username.value.match(regm1)){
	//	alert("�Բ�����������û������Ϸ���������2-7λ����");
		//alert("�û������벻�Ϸ���������ĸ���»��߿�ͷ");
	//	form.username.focus();
	//	return false;
	//}
	if(form.CourseName.value==""){
		alert("�γ����Ʋ���Ϊ��");
		form.CourseName.focus();
		return false;
	}
	//var regm2= /^([\u4e00-\u9fa5])$/
	//	if(!form.bstate.value.match(regm2)){
	//		alert("�������벻�Ϸ���������ɽ�򲻿ɽ�");
		//	form.bstate.focus();
		//	return false;
		//}
	if(form.CourseTime.value==""){
		alert("�γ�ѧʱ����Ϊ��");
		form.CourseTime.focus();
		return false;
	}
	if(form.YearTime.value==""){
		alert("ѧ�겻��Ϊ��");
		form.YearTime.focus();
		return false;
	}

	if(form.TermTime.value==""){
		alert("ѧ�ڲ���Ϊ��");
		form.TermTime.focus();
		return false;
	}
	if(form.ClassroomType.value==""){
		alert("�������Ͳ���Ϊ��");
		form.ClassroomType.focus();
		return false;
	}
	alert("����ɹ���");
}

function createXmlHttpRequest(){
    var xmlreq = false;
    if (window.XMLHttpRequest){
        xmlreq = new XMLHttpRequest();
    }else
        if (window.ActiveXObject){
    	try{
    	    xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
    	}catch(e1){
    	    try{
    	        xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
    	    }catch(e2){
    	    }
    	}
    }
    return xmlreq;   	
}
function CourseIdCheck(){ //��ʧȥ����ʱ���ᴥ���������
    var request = createXmlHttpRequest();//��������
    var CourseID = document.all.CourseID.value;//��ȡusername��ֵ
    request.open("post","courseIDCheckServlet?CourseID="+CourseID);//���ú�̨��servlet
    request.send();
    request.onreadystatechange = function(){
	if(request.readyState==4){
	        var value = request.responseText;
	        if(value=="true"){
	                //document.all.username.value="���û����Ѵ���";
	                alert("�ÿγ�ID�Ѵ���");
	                form.CourseID.focus();
	                return false;
	        }
    	}
    }
}

function MajorIDcheck(){ //��ʧȥ����ʱ���ᴥ��������� 
    var request = createXmlHttpRequest();//��������
    var MajorID = document.all.MajorID.value;//��ȡuserid��ֵ
    request.open("post","majorIDCheckServlet?MajorID="+MajorID);//���ú�̨��servlet,Ҫȥweb.xml����д���ã�Ȼ��дIdCheckServlet.java
    request.send();
    request.onreadystatechange = function(){
	if(request.readyState==4){
	        var value = request.responseText;
	        if(value=="false"){
	                alert("��רҵID������");
	                form.MajorID.focus();
	                return false;
	        }
    	}
    }
}

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
            <span>רҵ�γ̹���ҳ�� >> רҵ�γ����ҳ��</span>
        </div>
        <div class="providerAdd">
            <form action="addMajorScheduleServlet" name="form">            
                <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
                <div class="">
                    <label for="providerId">�γ�ID:</label>
                    <input type="text" name="CourseID" onBlur="CourseIdCheck()" id="providerId"/>
                    <span>*������γ�ID</span>
                </div>
                <div>
                    <label for="providerName">רҵID:</label>
                    <input type="text" name="MajorID" onBlur="MajorIDcheck()" id="providerName"/>
                    <span >*������רҵID</span>
                </div>
                <div>
                    <label for="people">�γ�����:</label>
                    <input type="text" name="CourseName" id="people"/>
                    <span>*������γ�����</span>

                </div>
                <div>
                    <label for="phone">�γ�ѧʱ:</label>
                    <select name="CourseTime" id="YearTime">
                    <option value="48ѧʱ" selected="CourseTime">&nbsp;&nbsp;48ѧʱ</option>
                    <option value="36ѧʱ" selected="CourseTime">&nbsp;&nbsp;36ѧʱ</option>
                    <option value="24ѧʱ" selected="CourseTime">&nbsp;&nbsp;24ѧʱ</option>
                    <option value="20ѧʱ" selected="CourseTime">&nbsp;&nbsp;20ѧʱ</option>
                    <option value="16ѧʱ" selected="CourseTime">&nbsp;&nbsp;16ѧʱ</option>
                    </select>
                    <span>*��ѡ��γ�ѧʱ</span>
                </div>
                <div>
                    <label for="address">ѧ��:</label>
                    <select name="YearTime" id="YearTime">
                    <option value="��һ" selected="YearTime">&nbsp;&nbsp;��һ</option>
                    <option value="���" selected="YearTime">&nbsp;&nbsp;���</option>
                    <option value="����" selected="YearTime">&nbsp;&nbsp;����</option>
                    <option value="����" selected="YearTime">&nbsp;&nbsp;����</option>
                    </select>
                    <span></span>
                </div>
                <div>
                    <label for="fax">ѧ��:</label>
                    <select name="TermTime" id="TermTime">
                    <option value="��һѧ��" selected="TermTime">&nbsp;&nbsp;��һѧ��</option>
                    <option value="�ڶ�ѧ��" selected="TermTime">&nbsp;&nbsp;�ڶ�ѧ��</option>
                    </select>
                    <span></span>
                </div>                
                
                 <div>
                    <label for="fax">��������:</label>
                    <select name=" EveryWeekCourseTime" id="ClassroomType">
                    <option value="��ͨ" selected="ClassroomType">&nbsp;&nbsp;��ͨ</option>
                    <option value="��ý��" selected="ClassroomType">&nbsp;&nbsp;��ý��</option>
                    </select>
                    
                    
                </div>
                <div>
                 <label for="phone">ÿ���Ͽ���:</label>
                    <select name=" EveryWeekCourseTime" id="YearTime">
                    <option value="2" selected="EveryWeekCourseTime">&nbsp;&nbsp;2ѧʱ</option>
                    <option value="4" selected="EveryWeekCourseTime">&nbsp;&nbsp;4ѧʱ</option>
                  </select>
                  </div>
                <div class="providerAddBtn">
                    <!--<a href="#">����</a>-->
                    <!--<a href="providerList.html">����</a>-->
                    <input type="submit" onClick="return check();" value="����" />
                    <a href="MajorScheduleList.jsp"><input type="button" value="����" /></a>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>


    
