<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>



<section id="main-content"  class="centeredPanel" style = "font-family: helvetica;">
<c:url value="/survey" var="surveyUrl" />

<!-- form:form - indicates you want the Spring version of form as indicated above in taglib -->
<!-- anything with form: indicates a Spring form feature -->
<!-- The modelAttribute identifies a POJO that is auto-magically connected to a form -->
<!-- Any names used in the form are assumed to match the POJO variable names -->
<!-- the modelAttribute is automatically passed to the controller on "submit" -->
<br>
<br>
<h2 style="font-family: helvetica;">Please take our Survey</h2>
<form:form action="${surveyUrl}" method="POST" modelAttribute="Survey">

        <div style="font-family: helvetica;">
        	<label for="parkCode">Favorite National Park</label>
        	
   
        		<select id="parkCode" name="parkCode">
            	<c:forEach var="parks" items="${listParks}">
                	<option value="${parks.parkCode}">${parks.parkName}</option>
           		 </c:forEach>
       			 </select>
        		
        </div>
        <br>


        <div>
            <label for="emailAddress">Email</label>
			<form:input  type="emailAddress" path="emailAddress" />            
        	<form:errors path="emailAddress" cssClass="error"/>

        </div>
        <br>
        <div>
        	<label for="state">State of Residence</label>
        	<form:input type="state" path="state"/>
        	<form:errors path="state" cssClass="error"/>
        </div>
       <br>

        <div>
        	<label for="activityLevel">Activity Level</label><br>
        	<%-- <form:input  path="activityLevel" /> --%>
        	<input type="radio" name="activityLevel" value="inactive">Inactive<br>
        	<input type="radio" name="activityLevel" value="sedentary">Sedentary<br>
        	<input type="radio" name="activityLevel" value="active">Active<br>
        	<input type="radio" name="activityLevel" value="extremelyactive">Extremely Active<br>
        	<br>
        		
        </div>

        
        <div>
            <input type="submit" value="Submit"/>
        </div>
</form:form>
</section>



</body>
</html>