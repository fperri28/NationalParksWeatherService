<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url var="formAction" value="/forecast"/>
		<form method="GET" action="${formAction}">
		<div>
		<label for="choosePark">Choose a park to view the five day forecast</label>
		<select name = "parkname">
		<c:forEach items="${park}" var="park">
		
		<option value=" ${park.parkCode}">${park.parkName}</option>
		
		</c:forEach>
		
		
		</select>
		</div>
		<div>
		<input type="submit" value="View the five day forecast for the park"/>
		</div>
		
		</form>	
