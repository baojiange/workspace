<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>部门</td>
			<td>操作</td>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.id}</td>
				<td>${user.userName}</td>
				<td>${user.age}</td>
				<td>${user.deptment}</td>
				<td>
				<a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">删除</a>
				<a href="${pageContext.request.contextPath}/user/updFoward?id=${user.id}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>