<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Courses Form</title>

<style>

	.error {
		color: #ff0000;
	}
        
        
            body{
        background-color: #269abc;
        
          }
        
</style>

</head>

<body>

	<h2>Courses</h2>
 
	<form:form method="POST" modelAttribute="course">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="course">Course: </label> </td>
				<td><form:input path="course" id="course"/></td>
				<td><form:errors path="course" cssClass="error"/></td>
		    </tr>
                    
                    <tr>
				<td><label for="courseLevel">Course level: </label> </td>
				<td><form:input path="courseLevel" id="courseLevel"/></td>
				<td><form:errors path="courseLevel" cssClass="error"/></td>
		    </tr>
	    
			
	
			
	
			
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
                                                    <strong><input type="submit" value="Update"/></strong>
						</c:when>
						<c:otherwise>
                                                <strong><input type="submit" value="Register"/></strong>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
        <strong>Go back to <a href="<c:url value='/teacher/courselist' />">List of All Courses</a></strong>
</body>
</html>
