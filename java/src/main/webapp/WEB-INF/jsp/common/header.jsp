<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Parks Weather Service</title>
    <c:url value="/css/npgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>
<body>
	<header>
	<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img style="width: 25%; padding: 20px" src="${logoSrc}" alt="National Parks Geek logo" />
        </a>
        <h1>The National Parks Weather Service</h1>
	</header>
	
	<nav>
        <h2>Explore The National Parks System</h2>
        <p> Use these state of the art web applications to learn more about the National Parks Weather Service! </p>
        
        
        <ul>
            <li><a href="${homePageHref}">Home</a></li>
            <li><a href="survey">Survey</a></li>
<%--             <li><c:url var="formAction" value="/forecast" />
				<form method="GET" action="${formAction}">
					<div>
						<label for="choosePark">Choose a park to view the five day forecast</label>
						<select name="parkname">
							<c:forEach items="${park}" var="park">

								<option value=" ${park.parkCode}">${park.parkName}</option>

							</c:forEach>


						</select>
					</div>
					

				</form></li>  --%>
        </ul>
    </nav>
	
