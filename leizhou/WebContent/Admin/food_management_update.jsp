<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>美食管理-添加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>

<body>
	<div class="x-body">
	<form action="foodManageServlet?action=updateFood" method="post" enctype="multipart/form-data" class="layui-form layui-form-pane">
<c:if test="${!empty foodList }">
<c:forEach items="${foodList}" var="foodList" varStatus="loop">
		<div class="layui-form-item">
			<label for="name" class="layui-form-label"> <span
				class="x-red">*</span>美食编号
			</label>
			<div class="layui-input-inline">
				<input type="text" id="fid" name="fid" value='${foodList.fid}'
					readonly="true" required lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label for="name" class="layui-form-label"> <span
				class="x-red">*</span>美食类型
			</label>
			<div class="layui-input-inline">
				<input type="text" id="ftid" name="ftid" value='${foodList.ftid }'
					required lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label for="name" class="layui-form-label"> <span
				class="x-red">*</span>美食名称
			</label>
			<div class="layui-input-inline">
				<input type="text" id="fname" name="fname"
					value='${foodList.fname }' required lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label for="name" class="layui-form-label"><span
				class="x-red">*</span>图片路径</label>
			<div class="layui-input-inline">
				<input type="text" id="image" name="image" value=${foodList.image }
					required lay-verify="required" autocomplete="off"
					class="layui-input">
					
					<img style="width:95%;height:250px;margin-top: 10px;margin-left: 10px;" 
				src="${pageContext.request.contextPath }/${foodList.image }" />
				<input type="file" name="image" id="image" style="float:right; margin-top: 10px"><br>
			</div>			
		</div>
		
		
		<div class="layui-form-item">
			<label for="name" class="layui-form-label">发布人 </label>
			<div class="layui-input-inline">
				<input type="text" id="aid" name="aid" value='${foodList.aid  }'
					autocomplete="off" class="layui-input">
			</div>
		</div>





	<div class="layui-form-item">
		<input type="submit" class="layui-btn"
			style="margin-left: 220px; width: 150px;" " lay-submit=""
			value="提  交">
		<!-- <button class="layui-btn" style="margin-left:230px;" lay-submit="" lay-filter="save">保存</button> -->
		<!-- <button class="layui-btn" lay-submit="" lay-filter="cancel">取消</button> -->
	</div>
	</c:forEach>
	</c:if>
	</form>
	</div>
		</div>
	<script src="./lib/layui/layui.js" charset="utf-8">
        </script>
	<script src="./js/x-layui.js" charset="utf-8">
        </script>
	<script>
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;

              //监听提交
              form.on('submit(save)', function(data){
                console.log(data);
                //发异步，把数据提交给php
                layer.alert("成功", {icon: 6},function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                });
                return false;
              });
            });
			
        </script>
	<script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>

</body>
</html>