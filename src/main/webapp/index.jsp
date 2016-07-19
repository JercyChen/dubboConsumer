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

<title>My JSP 'index.jsp' starting page</title>
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
	<c:if test="${sessionScope.username!=null }">
		<span>当前用户:<%=session.getAttribute("username")%></span>
		<br />
	</c:if>
	<span>功能</span><br/>
	<a href="jsp/login.jsp">1.用户登陆</a><br/>
	<a href="user/queryAllUsers.do">2.查询所有用户</a><br/>
	<a href="user/addUser.do">3.添加用户</a><br/>
	<a href="user/deleteUser.do">4.删除用户</a>
</body>
</html>
