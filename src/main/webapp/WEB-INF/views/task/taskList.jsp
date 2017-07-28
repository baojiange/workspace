<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>任务列表</title>
  </head>
 <body>
 	<div><a href="${pageContext.request.contextPath}/task/addPage">添加</a></div>
	<table>
		<tr>
			<td>任务编号</td>
			<td>任务名称</td>
			<td>状态</td>
			<td>任务运行时间表达式</td>
			<td>任务分组</td>
			<td>操作</td>
		</tr>
		<c:forEach var="task" items="${taskList}">
			<tr>
				<td>${task.taskId}</td>
				<td>${task.taskName}</td>
				<td>${task.status}</td>
				<td>${task.cronExpression}</td>
				<td>${task.taskGroup}</td>
				<td>
				<a href="${pageContext.request.contextPath}/task/delTask?id=${task.id}">删除任务</a>
				<a href="${pageContext.request.contextPath}/task/loadEditPage?id=${task.id}">修改任务</a>
				<a href="${pageContext.request.contextPath}/task/pauseTask?id=${task.id}">暂停任务</a>
				<a href="${pageContext.request.contextPath}/task/resumeTask?id=${task.id}">恢复任务</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
