<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>


<h2>Thank you for taking our survey! How does your favorite park compare to other popular parks? See below!</h2>

<c:forEach items="${post}" var="park">
		<p>Park Code: <c:out value="${park.parkCode}"/>
		</p>
		 <p>Count: <c:out value="${park.surveycount}"/>
		</p> 

</c:forEach>


</body>
</html>