<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<h3><a href="${pageContext.request.contextPath}/user/addUserforward">AddUser</a></h3>
<h3><a href="${pageContext.request.contextPath}/user/frowardsomeUser">验证AOP是否已经管理事务</a></h3>
<h3><a href="${pageContext.request.contextPath}/user/forwardMoreUser">验证批量是否回滚</a></h3>
<h3><a href="${pageContext.request.contextPath}/task/loadList">跳转到任务列表</a></h3>
</body>
</html>
