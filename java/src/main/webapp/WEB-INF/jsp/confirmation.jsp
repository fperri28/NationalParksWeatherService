<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<c:url value="/confirmation" var="confirmationUrl" />
<h1>Confirmation</h1>
<c:out value="${message}"/>

</body>
</html>