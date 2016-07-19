<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'adduser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="resources/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btn_adduser").click(function() {
			$.ajax({
				url:"user/queryAllUsers.do&_t="+getDate(),
				type:"post",
				data: 
				{
					userId:$("#userId").val(),
					userName:$("#userName").val(),
					userPhone:$("#userPhone").val(),
					userPassword:$("#userPassword").val(),
					lastLoginTime:$("#lastLoginTime").val(),
					userStatus:$("#userStatus").val(),
					userTypeCode:$("#userTypeCode").val()
				},
				dataType : 'json',
				success : function(data) {
					alert(data.msg);
				},
				error : function() {
					alert(data.msg);
				},
				async : true
			});
		});
	});
</script>
</head>

<body>
	<form id="myform" action="user/addUserInfo.do" method="post">
		用户编号:<input type="text" name="user.userId" id="userId"><br /> 
		用户姓名:<input type="text" name="user.userName" id="userName"><br /> 
		用户电话:<input type="text" name="user.userPhone" id="userPhone"><br /> 
		用户密码:<input type="text" name="user.userPassword" id="userPassword"><br /> 
		用户登录时间:<input type="text" name="user.lastLoginTime" id="lastLoginTime"><br /> 
		用户状态:<input type="text"  name="user.userStatus" id="userStatus"><br /> 
		用户角色: <select name="user.userTypeCode" id="userTypeCode">
			<c:forEach items="${types }" var="usertype">
				<option value="${usertype.userTypeCode }">${usertype.userTypeName
					}</option>
			</c:forEach>
		</select><br />
		<input type="submit" value="添加">
	</form>
</body>
</html>
