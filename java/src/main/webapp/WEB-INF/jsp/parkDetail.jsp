<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<title>${park.parkName}</title>


<h2>${park.parkName}</h2>
	<div >
		<p>
			<img src="/m3-java-capstone/img/parks/${fn:toLowerCase(park.parkCode)}.jpg"/>
		</p>
		<p>
			<c:out value="${park.parkDescription}" />
		</p>
		<p>
			<c:out value="State: ${park.state}" />
		</p>
		<p>
			<c:out value=" ${park.acreage} acres"  />
		</p>
		<p>
			<c:out value="Elevation: ${park.elevationInFeet} feet" />
		</p>
		<p>
			<c:out value="Miles of trail: ${park.milesOfTrail}" />
		</p>
		<p>
			<c:out value=" ${park.numberOfCampsites} campsites"  />
		</p>
		<p>
			<c:out value="Climate: ${park.climate}" />
		</p>
		<p>
			<c:out value="Year Founded: ${park.yearFounded}" />
		</p>
		<p>
			<c:out value=" ${park.annualVisitorCount} vistors per year"  />
		</p>
		<p>
			<c:out value='Inspirational Quote: "${park.inspirationalQuote}"' />
		</p>
		<p>
			<c:out value="Inspirational Source: ${park.inspirationalQuoteSource}" />
		</p>
		<p>
			<c:out value="Entry Fee: $ ${park.entryFee}"  />
		</p>
		<p>
			<c:out value="Number of Animal Species: ${park.numberOfAnimalSpecies}"  />
		</p>

<div>
<c:forEach begin="0" end="0" items="${forecast}" var="forecast">


		<p> <img src = "/m3-java-capstone/img/weather/${forecast.forecast}.png"/>
		</p>

		<p><c:out value="${forecast.high}"/>
		</p>
		<p><c:out value="${forecast.low}"/>
		</p> 
		
		<p>
			<c:set var="message" />
			<c:choose>
				<c:when test="${forecast.high > 75}"> Bring an extra gallon of water</c:when>
				<c:when test="${forecast.high - forecast.low > 20}"> Wear breathable layers </c:when>
				<c:when test="${forecast.low < 20}"> Visit with caution, we cannot be held responsible for frost bite </c:when>
				<c:otherwise> Look forward to a wonderful day in the Parks System. Have Fun! </c:otherwise>
			</c:choose>
			</p>

		<p>
			<c:set var="weather" />
			<c:choose>
				<c:when test="${forecast.forecast.equals('rain')}"> It's going to rain, pack rain gear and wear waterproof shoes </c:when>
				<c:when test="${forecast.forecast.equals('snow')}"> It's going to snow, pack snow shoes </c:when>
				<c:when test="${forecast.forecast.equals('thunderstorms')}"> It's going to thunderstorm, seek shelter and avoid hiking on exposed ridges </c:when>
				<c:when test="${forecast.forecast.equals('sunny')}"> It's going to be sunny, pack sunblock </c:when>
				<c:otherwise> Look forward to a wonderful day in the Parks System. Have Fun! </c:otherwise>
			</c:choose>
		</p>	
		

</c:forEach>
</div>



<div>
	<form action="forecast" method="GET">
				<div>		
					<input type="hidden" name="parkCode" value ="${park.parkCode}"/>
				</div>	
				<div>
					<input type="submit" value="Check the 5 day forecast" />
				</div>		
			</form>
</div>

</div>

</body>
</html>