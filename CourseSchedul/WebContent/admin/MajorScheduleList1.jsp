<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
   <title>��У�ſι���ϵͳ</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<script >
function Check(){
	String CourseID=request.getParameter("CourseID");
	 MajorScheduleDAO mdao = new MajorScheduleDAO();
		boolean flag=mdao.FindMajorScheduleByID(CourseID);
         if(!flag){
	      alert("�����������Ϊ�գ�");
	      form.CourseID.focus();
	      return false;
          }	
}
    function allcheck(){
    	var checkObj = document.getElementsByName("check")//���е���Ϊcheck�Ķ�ѡ����
    	for(var i =0;i<checkObj.length;i++)//�ӵ������ʼ������������ĳ���
    		checkObj[i].checked=true;//��ѡ��ı�ѡ�е�ֵҪ����true
    	}
    function allnotcheck(){
        	var checkObj = document.getElementsByName("check")//���е���Ϊcheck�Ķ�ѡ����
        	for(var i =0;i<checkObj.length;i++)//�ӵ������ʼ������������ĳ���
        		checkObj[i].checked=false;//��ѡ��ı�ѡ�е�ֵҪ����true
        	}
    function backcheck(){
            	var checkObj = document.getElementsByName("check")//���е���Ϊcheck�Ķ�ѡ����
            	for(var i =0;i<checkObj.length;i++){ //�ӵ������ʼ������������ĳ���
            		if(checkObj[i].checked==true)
            		checkObj[i].checked=false;//��ѡ��ı�ѡ�е�ֵҪ����false
            		else
            			checkObj[i].checked=true;
            	        }
                   }
        	
    function deleteCheck(){
    	var checkObj = document.getElementsByName("check")//���е���Ϊcheck�Ķ�ѡ����
    	var arr = [];//����һ������
    	var flag=false;
    	for(var i =0;i<checkObj.length;i++){ //�ӵ������ʼ������������ĳ���
    		if(checkObj[i].checked==true){
    			arr.push(checkObj[i].value);
    			flag=true;
    		}
    }
    	alert(arr);
    	if(flag==true){
    		if(confirm("��ȷ��ɾ����Щ��¼��"))
    			location.href="deleteCheckServlet?arr="+arr;	
    	}
    	else
    		alert("��������ѡ��һ����¼���ٽ���ɾ��");
    }


</script>
<style>
.search input[type='submit']{
    margin-left: 20px;
    width: 100px;
    padding: 0 20px;
    height: 30px;
    border: 1px solid #7ba92c;
    border-radius: 4px;
    color: #fff;
    font-weight: bold;
    background:#87c212 url("img/search.png") 10px center no-repeat;
}
.search input[type='submit']:focus{
    outline: none;
    background-color: #5d8410;
}
</style>
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
<% 
String CourseID = (String)session.getAttribute("CourseID");
%>
        <div class="location">
            <strong>���������ڵ�λ����:</strong>
            <span>רҵ�γ̹���ҳ�� >> רҵ�γ̲�ѯҳ��</span>
        </div>
        <div class="search">
            
            <form action="searchByCourseID"  name="form" >
            <span>�γ�ID:</span>
				<input type="text" placeholder="����γ�ID" name="CourseID" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'CourseID';}"  />
				<input type="submit" value="��ѯ"/>
				<a href="MajorScheduleAdd.jsp">���רҵ�γ�</a>
		</form>        
        </div>
        <!--��Ӧ�̲������-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th></th>
                <th width="10%">�γ�ID</th>
                <th width="15%">רҵID</th>
                <th width="10%">�γ�����</th>
                <th width="10%">�γ�ѧʱ</th>
                <th width="10%">ѧ��</th>
                <th width="10%">ѧ��</th>
                <th width="10%">��������</th>
                <th width="10%">ʣ���ſ���</th>
                <th width="25%">����</th>
            </tr>
<%
      Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
      v=(Vector<MajorScheduleDTO>)session.getAttribute("searchcourse");
      Iterator it = v.iterator();
      MajorScheduleDTO m = null;
      while(it.hasNext()){
	  m = (MajorScheduleDTO)it.next();
	  System.out.println(CourseID+"666");
	  String aa=m.getCourseID();
	  aa=aa.substring(0,4);
	  //System.out.println(aa+"9999");
	  if(aa.equals(CourseID)){ 
		  //System.out.println(CourseID);
%>
<tr >
<td><input type="checkbox" name="check" value=<%=m.getCourseID() %>> </td>
<td><%=m.getCourseID() %>
<td><%=m.getMajorID() %>
<td><%=m.getCourseName() %>
<td><%=m.getCourseTime() %>
<td><%=m.getYearTime() %>
<td><%=m.getTermTime() %>
<td><%=m.getClassroomType() %>
<td><%=m.getEveryWeekCourseTime() %></td>
<td >
      <a href="MajorScheduleView.jsp?CourseID=<%=m.getCourseID() %>"><img src="img/read.png" alt="�鿴" title="�鿴"/></a>
      <a href="MajorScheduleUpdate.jsp?CourseID=<%=m.getCourseID()%>"><img src="img/xiugai.png" alt="�޸�" title="�޸�"/></a>
      <a href="deleteMajorScheduleServlet?CourseID=<%=m.getCourseID()%>"><img src="img/schu.png" alt="ɾ��" title="ɾ��"/></a>
    </td>
</tr>
<%
	}}
%>

        </table>

    </div>
</section>

<!--���ɾ����ť�󵯳���ҳ��-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>��ʾ</h2>
       <div class="removeMain" >
           <p>��ȷ��Ҫɾ���ù�Ӧ����</p>
           <a href="#" id="yes">ȷ��</a>
           <a href="#" id="no">ȡ��</a>
       </div>
   </div>
</div>


<footer class="footer">
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>