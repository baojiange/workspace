<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改页面</title>
    
  </head>
    <body>
	<form action="${pageContext.request.contextPath}/task/eidtTask" method="post">
		<table>
			<tr>
				<td>任务编号</td>
				<td><input type="text" name="taskId" id="taskId" value="${record.taskId}"></td>
			</tr>
			<tr>
				<td>任务名称</td>
				<td><input type="text" name="taskName" id ="taskName" value="${record.taskName}"></td>
			</tr>
			<tr>
				<td>任务运行时间表达式</td>
				<td><input type="text" name="cronExpression" id="cronExpression" value="${record.cronExpression}"></td>
			</tr>
			<tr>
				<td>任务分组</td>
				<td><input type="text" name="taskGroup" id="taskGroup" value="${record.taskGroup}"></td>
			</tr>
			<tr>
				<td>执行的方法(全路径)</td>
				<td><input type="text" name="taskServ" id="taskServ" value="${record.taskServ}"></td>
				<td><input type="hidden" name="id" id="id" value="${record.id}"></td>
			</tr>
			
			<tr><td><input type="submit" value="修改"></td></tr>
		</table>
	</form>
</body>

<script type="text/javascript">




</script>



</html>
