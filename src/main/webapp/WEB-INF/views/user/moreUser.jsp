<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/addMoreUser" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="minNumber" id="minNumber">
					到
					<input type="text" name="maxNumber" id="maxNumber">
				</td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age" id="age"></td>
			</tr>
			<tr>
				<td>部门：</td>
				<td><input type="text" name="deptment" id="deptment"></td>
			</tr>
			<tr><td><input type="submit" value="批量插入"></td></tr>
		</table>
	</form>
</body>
</html>