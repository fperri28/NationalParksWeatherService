<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<style>

.grid-container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas: "image image title" "image image description" ". . . .";
  grid-gap: 50px;
  flex-wrap: wrap;
  justify-content: center;
}

grid-item {
  display: flex;
  align-items: center;
  justify-content: center;
}
.image {
  grid-area: image;
  width: 100%;
  height: auto;

}

.title {
  grid-area: title;
}

.description {
  grid-area: description;
}

.image img {
    width: 100%;
    height: auto;
}
  
</style>


<title>Welcome to the National Parks Weather Service</title>

<section>
	<div style="padding: 10px; text-align: center">
	<p>Welcome to the National Parks Weather Service</p>
	</div>
	
	
	<div class="grid-container">

		<c:forEach items="${park}" var="park">
		<a style=" text-decoration: none" href="parkDetail?parkCode=${park.parkCode}">
<div class="image"> 
					<img src="/m3-java-capstone/img/parks/${fn:toLowerCase(park.parkCode)}.jpg"/>
</div>
<div class="title"> 
					<h2 style="color: black" ><c:out value=" ${park.parkName}" /></h2>
</div>
<div class="description" style="color: black"> 
					<c:out value="${park.parkDescription}" />
</div>
			</a>
		</c:forEach>
		</div>
</section>

</body>
</html>