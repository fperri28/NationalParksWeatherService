<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<c:url value="/confirmation" var="confirmationUrl" />
<div style="font-family: helvetica;">
<h1>Confirmation</h1>
<c:out value="${message}"/>
</div>
</body>
</html>