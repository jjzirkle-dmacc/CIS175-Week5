<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Tracker</title>
</head>
<body>
	<form action="editTaskServlet" method="post">
		Department: <input type="text" name="department"
			value="${itemToEdit.department}"> Task: <input type="text"
			name="task" value="${itemToEdit.task}"> <input type="hidden"
			name="id" value="${taskToEdit.id}"> <input type="submit"
			value="Save Edited Task">
	</form>

</body>
</html>