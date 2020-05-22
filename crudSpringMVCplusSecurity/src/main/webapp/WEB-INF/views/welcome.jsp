<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        
        <!--Bootstrap 4-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Admin page</title>
        
        <style> 
        body,html{
            height: 100%;
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background-image: url("static/image/misery.jpg");
            background-position: center;
            background-repeat: no-repeat;
            background-size: 300px 300px;
            text-align: center;
            position:relative;
            background-color: #269abc;
            text-align: center;
            position:relative;
    overflow-y: hidden;
    }
    p{
        background-color: #269abc;
        text-orientation: sideways;
        padding-top: 5px;
        padding-bottom: 5px;
    }
   
    </style>
</head>
<body id="bd">

        <nav class="navbar navbar-dark bg-dark navbar-expand-md navbar-fixed-top">
        <a class="navbar-brand" href="#">
            User page
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-2"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar-list-2">
            <ul class="navbar-nav ml-auto">
                
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/home/listofcourses" />">View courses</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/logout" />">Log out</a>
                </li>
                
            </ul>
        </div>
    </nav>
    <p>Dear <strong>${user}</strong>, Welcome ! Choose whether to view the courses' list or log out
    </p>
</body>
</html>