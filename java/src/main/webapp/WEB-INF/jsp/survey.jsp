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
		<select name="state" id="state">
			<option value="Alabama">Alabama</option>
			<option value="Alaska">Alaska</option>
			<option value="Arizona">Arizona</option>
			<option value="Arkansas">Arkansas</option>
			<option value="California">California</option>
			<option value="Colorado">Colorado</option>
			<option value="Connecticut">Connecticut</option>
			<option value="Delaware">Delaware</option>
			<option value="District of Columbia">District Of Columbia</option>
			<option value="Florida">Florida</option>
			<option value="Georgia">Georgia</option>
			<option value="Hawaii">Hawaii</option>
			<option value="Idaho">Idaho</option>
			<option value="Illinois">Illinois</option>
			<option value="Indiana">Indiana</option>
			<option value="Iowa">Iowa</option>
			<option value="Kansas">Kansas</option>
			<option value="Kentucky">Kentucky</option>
			<option value="Louisiana">Louisiana</option>
			<option value="Maine">Maine</option>
			<option value="Maryland">Maryland</option>
			<option value="Massachusetts">Massachusetts</option>
			<option value="Michigan">Michigan</option>
			<option value="Minnesota">Minnesota</option>
			<option value="Mississippi">Mississippi</option>
			<option value="Missouri">Missouri</option>
			<option value="Montana">Montana</option>
			<option value="Nebraska">Nebraska</option>
			<option value="Nevada">Nevada</option>
			<option value="New Hampshire">New Hampshire</option>
			<option value="New Jersey">New Jersey</option>
			<option value="New Mexico">New Mexico</option>
			<option value="New York">New York</option>
			<option value="North Carolina">North Carolina</option>
			<option value="North Dakota">North Dakota</option>
			<option value="Ohio">Ohio</option>
			<option value="Oklahoma">Oklahoma</option>
			<option value="Oregon">Oregon</option>
			<option value="Pennsylvania">Pennsylvania</option>
			<option value="Rhode Island">Rhode Island</option>
			<option value="South Carolina">South Carolina</option>
			<option value="South Dakota">South Dakota</option>
			<option value="Tennessee">Tennessee</option>
			<option value="Texas">Texas</option>
			<option value="Utah">Utah</option>
			<option value="Vermont">Vermont</option>
			<option value="Virginia">Virginia</option>
			<option value="Washington">Washington</option>
			<option value="West Virginia">West Virginia</option>
			<option value="Wisconsin">Wisconsin</option>
			<option value="Wyoming">Wyoming</option>
		</select>
	</div>
        
       <br>

        <div>
        	<label for="activityLevel">Activity Level</label><br>
        	<%-- <form:input  path="activityLevel" /> --%>
        	<input checked="checked" type="radio" name="activityLevel" value="inactive">Inactive<br>
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