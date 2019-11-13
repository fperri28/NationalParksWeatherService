<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>${park.parkName}</title>
</head>
<body>
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

</div>

</body>
</html>