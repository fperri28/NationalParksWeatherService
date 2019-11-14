<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>


<section id="main-content"  class="centeredPanel">
<c:url value="/survey" var="surveyUrl" />

<!-- form:form - indicates you want the Spring version of form as indicated above in taglib -->
<!-- anything with form: indicates a Spring form feature -->
<!-- The modelAttribute identifies a POJO that is auto-magically connected to a form -->
<!-- Any names used in the form are assumed to match the POJO variable names -->
<!-- the modelAttribute is automatically passed to the controller on "submit" -->

<form:form action="${surveyUrl}" method="POST" modelAttribute="Survey">

        <div>
        	<label for="parkCode">Favorite National Park</label>
        	<form:input  path="parkCode" />
        	<form:errors path="parkCode"  cssClass="error"/>
        		
        </div>

        <div>
            <label for="emailAddress">Email</label>
			<form:input  type="emailAddress" path="emailAddress" />            
        	<form:errors path="emailAddress" cssClass="error"/>
<%--         	<form:errors path="emailMatching" cssClass="error"/>
        </div>

        <div>
            <label for="verifyEmail">Verify Email</label>
            <form:input  type="emailAddress" path="verifyEmail" />
            <form:errors path="verifyEmail" cssClass="error"/> --%>
        </div>
       

        <div>
        	<label for="activityLevel">Activity Level</label>
        	<form:input  path="activityLevel" />
        	<form:errors path="activityLevel"  cssClass="error"/>	
        </div>

        
        <div>
            <input type="submit" value="Submit"/>
        </div>
</form:form>
</section>



</body>
</html>