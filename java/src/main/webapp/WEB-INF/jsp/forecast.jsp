<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forecast for ${forecast.parkCode}</title>
</head>
<body>
<div>
<c:forEach items="${forecast.parkCode}" var="parkCode">
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