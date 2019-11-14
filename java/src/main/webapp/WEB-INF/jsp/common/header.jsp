<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Parks Weather Service</title>
    <c:url value="/css/npgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>
<body style=" background:#90EE90">
	<header style=" background: green;">
	<c:url value="/" var="homePageHref" />
	<c:url value="/survey" var="surveyHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img style="width: 45%;" src="${logoSrc}" alt="National Parks Geek logo" />
        </a>
	</header>
	
<%-- 	<div align="center">
    <h2>Dynamic Drop Down List </h2>
    <form action="list" method="GET">
        Select a Park:&nbsp;
        <select name="park">
            <c:forEach items="${listParks}" var="park">
                <option value="${park.parkName}"
                    <c:if test="${park.parkName eq selectedParkName}">selected="selected"</c:if>
                    >
                    ${park.parkName}
                </option>
            </c:forEach>
        </select>
        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</div> --%>
	<nav>
        <h2>Explore The National Parks System</h2>
        <p> Use these state of the art web applications to learn more about the National Parks Weather Service! </p>
        
        <div id="menu-outer">
  		<div class="table">
    	<ul id="horizontal-list">
            <li><a href="${homePageHref}">Home</a></li>
            <li><a href="${surveyHref}">Survey</a></li>
            <li>
            <form action="/parkDetail" method="GET">
        	Please select a Park: 
        		<select id="parkCode" name="parkCode">
            	<c:forEach var="parks" items="${listParks}">
                	<option value="${parks.parkCode}">${parks.parkName}</option>
           		 </c:forEach>
       			 </select>
       			 <input type="submit" value="Go To Park"> 
    		</form>
    		</li>
        </ul>
        </div>
        </div>
        
        
    </nav>
	
