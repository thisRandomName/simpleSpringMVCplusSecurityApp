<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of Courses</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
                
                
            body{
        background-color: #269abc;
        
          }
        
	</style>

</head>


<body>
	<h2>List of Courses</h2>	
	<table>
		<tr>
			<td>Course</td><td>Course Level</td><td>
		</tr>
		<c:forEach items="${courses}" var="course">
			<tr>
			<td>${course.course}</td>
			<td>${course.courseLevel}</td>
			
			<td><a href="<c:url value='/edit-${course.id}-course' />">${course.id}</a></td>
			<td><a href="<c:url value='/delete-${course.id}-course' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newcourse' />">Add New Course</a>
</body>
</html>