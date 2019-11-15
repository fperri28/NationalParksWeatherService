<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<c:url value="/login" var="loginUrl" />
<div style="font-family: helvetica;">
<form:form action="${loginUrl}" method="POST" modelAttribute="Login">

	<br>
	<br>
		<div>Login to the National Parks Weather Service</div>
	<br>
	<br>

 <div>
        	<label for="emailAddress">Email</label>
        	<form:input  path="emailAddress"  />
        	<form:errors path="emailAddress"  cssClass="error"/>
        	
        		
        </div>
        	<br>
	<br>
        <div>
        	<label for="password">Password</label>
        	<form:input  path="password"  />
        	<form:errors path="password"  cssClass="error"/>
        		
        </div>
        	<br>
	<br>
        <div>
        <input type="submit" value="Submit"/>
        </div>
</form:form>
</div>
</body>
</html>