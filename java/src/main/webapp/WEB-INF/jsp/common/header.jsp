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

	<header style=" background: green;">
	<c:url value="/" var="homePageHref" />
	<c:url value="/survey" var="surveyHref" />
	<c:url value="/login" var="loginHref"/>
	<c:url value="/register" var="registerHref"/>
	
     	 <c:url value="/img/logo.png" var="logoSrc" />
        <a id="logo" href="${homePageHref}">
        	<img style="width: 45%;" src="${logoSrc}" alt="National Parks Geek logo" />
        </a>
	</header>
	

<div class="topnav">
	<nav>
            <a href="${homePageHref}">Home</a>
            <a href="${surveyHref}">Take Our Survey</a>
            
            <div class="topnav-centered" style="hover: none;">
            <a>
            <form action="parkDetail" method="GET" style="color: white;">
        	Please select a Park: 
        		<select id="parkCode" name="parkCode">
            	<c:forEach var="parks" items="${listParks}">
                	<option value="${parks.parkCode}">${parks.parkName}</option>
           		 </c:forEach>
       			 </select>
       			 <input type="submit" value="Go To Park"> 
    		</form>
    		</a>
    		</div>
    		
    		<div class="topnav-right">
    			<a href="${registerHref}">Register</a>
    			<a href="${loginHref}">Login</a>
        	</div>
 
    </nav>
</div>

