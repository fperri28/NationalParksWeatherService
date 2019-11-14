<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<style>
body {
font-family: helvetica;
}

</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forecast for ${forecast}</title>
</head>
<body>
<h1>Five-Day Forecast for ${park.parkName}</h1>
<div>
<c:forEach items="${forecast}" var="forecast">

	<p>
	<c:out value="${forecast.fiveDayForecastValue }"/>
	</p>
		<p> <img src = "/m3-java-capstone/img/weather/${forecast.forecast}.png"/>
		</p>

		<p><c:out value="High: ${forecast.high}"/>º
		</p>
		<p><c:out value="Low: ${forecast.low}"/>º
		</p> 


</c:forEach>
</div>
</body>
</html>