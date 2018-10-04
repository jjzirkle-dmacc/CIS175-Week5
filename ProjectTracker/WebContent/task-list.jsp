<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project List</title>
</head>
<body>
	<form method="post" action="editTaskListServlet">
		<table>
			<c:forEach items="${requestScope.allTasks}" var="currenttask">
				<tr>
					<td><input type="radio" name="id" value="${currenttask.id}"></td>
					<td>${currenttask.department}</td>
					<td>${currenttask.task}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Edit Selected Task" name="doThisToTask">
		<input type="submit" value="Delete Selected Task" name="doThisToTask">
		<input type="submit" value="Add New Task" name="doThisToTask">
	</form>



</body>
</html>