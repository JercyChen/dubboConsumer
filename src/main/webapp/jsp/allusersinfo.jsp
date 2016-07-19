<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allusersinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table border="1">
		<tr>
			<th>序号</th>
			<th>编号</th>
			<th>姓名</th>
			<th>电话</th>
			<th>密码</th>
			<th>上一次登录时间</th>
			<th>用户状态</th>
			<th>用户角色编号</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.userId }</td>
				<td>${user.userName }</td>
				<td>${user.userPhone }</td>
				<td>${user.userPassword }</td>
				<td>${user.lastLoginTime }</td>
				<td>${user.userStatus }</td>
				<td>${user.userTypeCode }</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
