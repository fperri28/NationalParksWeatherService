<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forecast for ${forecast}</title>
</head>
<body>
<div>
<c:forEach items="${forecast}" var="forecast">

	<p>
	<c:out value="${forecast.fiveDayForecastValue }"/>
	</p>
		<p> <img src = "/m3-java-capstone/img/weather/${forecast.forecast}.png"/>
		</p>

		<p><c:out value="${forecast.high}"/>
		</p>
		<p><c:out value="${forecast.low}"/>
		</p> 


</c:forEach>
</div>
</body>
</html>