<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��У�ſι���ϵͳ</title>
<link rel="stylesheet" href="css/public.css"/>
<link rel="stylesheet" href="css/style.css"/>
</head>
<script type="text/javascript">
function check(){
	if(form.CourseName.value==""){
		alert("�γ����Ʋ���Ϊ��");
		form.CourseName.focus();
		return false;	
}
	alert("����ɹ�!");
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
            <span>רҵ�γ̹���ҳ�� >> רҵ�γ��޸�ҳ</span>
        </div>
        <div class="providerAdd">


            <form action="updateMajorSchedule" name="form">
                <!--div��class Ϊerror����֤����ok����֤�ɹ�-->
<%         
        String CourseID = request.getParameter("CourseID");
        MajorScheduleDAO mdao = new MajorScheduleDAO();
		Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
		v=mdao.findMajorScheduleByID(CourseID);
        Iterator it = v.iterator();
        MajorScheduleDTO m = null;
        while(it.hasNext()){
	    m = (MajorScheduleDTO)it.next();
%>
                <div class="">
                   <label for="providerId">�γ�ID:</label>
                    <input type="text" name="CourseID" readOnly="true" id="providerId" value=<%=m.getCourseID() %> />
                    <span>*</span>
                     </div> 
                <div>
                    <label for="providerName">רҵID:</label>
                    <input type="text" name="MajorID" id="providerName" value=<%=m.getMajorID() %> onBlur="MajorIDcheck()"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="people">�γ�����:</label>
                    <input type="text" name="CourseName" id="people" value=<%=m.getCourseName() %>>
                    <span>*</span>

                </div>
                <div>
                    
                   <label for="phone">�γ�ѧʱ:</label>
                    <select name="CourseTime" id="YearTime">
                    <option value="48ѧʱ" selected="CourseTime">&nbsp;&nbsp;48ѧʱ</option>
                    <option value="32ѧʱ" selected="CourseTime">&nbsp;&nbsp;32ѧʱ</option>
                    <option value="24ѧʱ" selected="CourseTime">&nbsp;&nbsp;24ѧʱ</option>
                   
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
                    <select name="ClassroomType" id="ClassroomType">
                    <option value="��ͨ" selected="ClassroomType">&nbsp;&nbsp;��ͨ</option>
                    <option value="��ý��" selected="ClassroomType">&nbsp;&nbsp;��ý��</option>
                    </select>
                    <span></span>

                </div>
                
                <div>
                 <label for="phone">ʣ���ſ���:</label>
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
