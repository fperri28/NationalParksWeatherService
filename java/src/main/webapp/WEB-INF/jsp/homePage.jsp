<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to the National Parks Weather Service</title>
</head>
<body>

	<div>
		<c:forEach items="${park}" var="park">
		<a style=" text-decoration: none" href="parkDetail?parkCode=${park.parkCode}">
			<div >
				<p>
					<img src="/m3-java-capstone/img/parks/${fn:toLowerCase(park.parkCode)}.jpg"/>
				</p>
				<p>
					<c:out value=" ${park.parkName}" />
				</p>
				<p>
					<c:out value="${park.parkDescription}" />
				</p>

			</div>
			</a>
		</c:forEach>
	</div>

</body>
</html>