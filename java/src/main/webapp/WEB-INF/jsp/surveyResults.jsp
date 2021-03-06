<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>


<h2 style = "font-family: helvetica;">Thank you for taking our survey! How does your favorite park compare to other popular parks? See below!</h2>
<div style="font-family: helvetica; font-size: 18px;">
<c:forEach items="${post}" var="park">
		<p>
		<img src="/m3-java-capstone/img/parks/${fn:toLowerCase(park.parkCode)}.jpg"/>
		</p>
		<h3><c:out value="${park.parkName}"/>
		</h3>
		 <p>Count: <c:out value="${park.surveycount}"/>
		</p> 

</c:forEach>
</div>

</body>
</html>