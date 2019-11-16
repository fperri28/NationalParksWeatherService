<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<style>
h2 {
	font-family: helvetica;
}
</style>

<title>${park.parkName}</title>

<br>
<br>
<h2>${park.parkName}</h2>
<div style="font-family: helvetica; font-size: 20px;">
	<table>
		<tr>

			<td><img
				src="/m3-java-capstone/img/parks/${fn:toLowerCase(park.parkCode)}.jpg" />
			</td>
			<td></td>
			<td style="font-style: italic; width: 500px;"><c:out
					value="${park.parkDescription}" /></td>
		</tr>
	</table>
	<p>
		<strong>State: </strong>
		<c:out value="${park.state}" />
	</p>
	<p>
		<c:out value=" ${park.acreage} acres" />
	</p>
	<p>
		<c:out value="Elevation: ${park.elevationInFeet} feet" />
	</p>
	<p>
		<c:out value="Miles of trail: ${park.milesOfTrail}" />
	</p>
	<p>
		<c:out value=" ${park.numberOfCampsites} campsites" />
	</p>
	<p>
		<c:out value="Climate: ${park.climate}" />
	</p>
	<p>
		<c:out value="Year Founded: ${park.yearFounded}" />
	</p>
	<p>
		<c:out value=" ${park.annualVisitorCount} vistors per year" />
	</p>
	<p>
		<c:out value="Number of Animal Species: ${park.numberOfAnimalSpecies}" />
	</p>
	<p>
		<c:out value="Entry Fee: $${park.entryFee}" />
	</p>
	
	<br> <br>
	<p style="font-style: italic;">
		<c:out value="${park.inspirationalQuote}" />
	</p>
	<p>
		<c:out value="-- ${park.inspirationalQuoteSource}" />
	</p>
	<br> <br>


	<div style="background: tan; font-family: helvetica;">
		<table style="display: inline-block; border: 1px solid; float: left; height: auto; background: #0b98de;">

			<c:forEach begin="0" end="0" items="${forecast}" var="forecast">
				<br>
				<tr>
					<td align="center" style="background: #0b98de;">
						<h4>Today's Forecast</h4>

					</td>
				</tr>

				<tr>
					<td align="center" style="background: white; border-radius: 50%;" ><img style="height: 190px; width: 190px; border-radius: 50%;"
						src="/m3-java-capstone/img/weather/${forecast.forecast}.png" /></td>
				</tr>

				<tr>
					<td align="center">High: <c:out value="${forecast.high}" />º <br>Low:
						<c:out value="${forecast.low}" />º
					</td>
				</tr>

				<tr>
				
				<td align="center"><c:set var="message" />
				
				<% if (session.getAttribute("tempUnit") == "C") { %>
				<c:if test="${forecast.high > 23.8}"> Bring an extra gallon of water. </c:if> 
				<c:if test="${forecast.high - forecast.low > 6.6}"> Wear breathable layers. </c:if>
				<c:if test="${forecast.low < -6.6}"> Visit with caution! We cannot be held responsible for frostbite. </c:if>
				<% } else {%>
				<c:if test="${forecast.high > 75}"> Bring an extra gallon of water. </c:if> 
				<c:if test="${forecast.high - forecast.low > 20}"> Wear breathable layers. </c:if>
				<c:if test="${forecast.low < 20}"> Visit with caution! We cannot be held responsible for frostbite. </c:if>
				<% } %>
				
			<br> 
			
			<c:set var="weather" />
			<c:choose>
				<c:when test="${forecast.forecast.equals('rain')}"> It's going to rain. Pack rain gear and wear waterproof shoes. </c:when>
				<c:when test="${forecast.forecast.equals('snow')}"> It's going to snow. Pack snowshoes. </c:when>
				<c:when test="${forecast.forecast.equals('thunderstorms')}"> It's going to thunderstorm. Seek shelter and avoid hiking on exposed ridges. </c:when>
				<c:when test="${forecast.forecast.equals('sunny')}"> It's going to be sunny. Pack sunblock. </c:when>
				<c:otherwise> Expect clear skies. </c:otherwise>
			</c:choose>
			</td>
			</tr>

			</c:forEach>

		</table>

		<p>
			<c:url value="/temperature" var="temperatureUrl">
				<c:param name="parkCode">${park.parkCode }</c:param>
			</c:url>
			<form:form action="${temperatureUrl}" method="POST">
				<label for="temperature">Temperature Preference</label>
				<br>
				
				<% if (session.getAttribute("tempUnit") == "C") { %>
 			   		<input type="radio" name="temperature" value="Fahrenheit">Fahrenheit<br>
					<input checked="checked" type="radio" name="temperature" value="Celsius">Celsius<br>
				<% } else {%>
 			   		<input checked="checked" type="radio" name="temperature" value="Fahrenheit">Fahrenheit<br>
					<input type="radio" name="temperature" value="Celsius">Celsius<br>
				<% } %>

				<input type="submit" value="Change temperature preference">

				<br>
			</form:form>
		</p>

		<table style="display: inline-block; border: 1px solid; background: #0b98de;">
			<tr>
				<th>5 Day Forecast</th>
			</tr>

			<tr>

				<c:forEach begin="1" end="5" items="${forecast}" var="forecast">
					<td align="center"><img style="width: 180px; border-radius: 50%;"
						src="/m3-java-capstone/img/weather/${forecast.forecast}.png" /></td>
				</c:forEach>

			</tr>

			<tr>
				<c:forEach begin="1" end="5" items="${forecast}" var="forecast">
					<td align="center"><c:out value="High: ${forecast.high}" />º <c:out
							value="Low: ${forecast.low}" />º</td>
				</c:forEach>
			</tr>



		</table>


	</div>

</div>

</body>
</html>