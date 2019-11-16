<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<c:url value="/register" var="registerUrl" />
<div style="display:flex; font-family: helvetica;">

<form:form action="${registerUrl}" method="POST"
	modelAttribute="Register">

	<br>
	<br>
		<div>Register to Join the National Parks Weather Service</div>
	<br>
	<br>


	<div>
		<label for="emailAddress">Email</label>
		<form:input path="emailAddress" type="text" />
		<form:errors path="emailAddress" cssClass="error" />

	</div>
	<br>
	<br>

	<div>
		<label for="password">Password</label>
		<form:password path="password" />
		<form:errors path="password" cssClass="error" />

	</div>

	<br>
	<br>

	<div>
		<input type="submit" value="Submit" />
	</div>
</form:form>
</div>
</body>
</html>