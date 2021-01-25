<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="stylesheet" value="/files/css"></spring:url>
<spring:url var="javascript" value="/files/js"></spring:url>
<spring:url var="images" value="/files/images"></spring:url>

<c:set var="localURL" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">


<title>Good Food Markets ${pageTitle}</title>

<script>
  window.menu = '${pageTitle}';
  window.contextRoot = '${localURL}';
  </script>

<!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="${stylesheet}/bootstrap.min.css" rel="stylesheet">
<link href="${stylesheet}/bootstrap-readable-theme.css" rel="stylesheet"> 
<link href="${stylesheet}/dataTables.bootstrap.css" rel="stylesheet">
<link href="${stylesheet}/mywebsite.css" rel="stylesheet">




</head>

<body>

	<!-- Navigation -->
	<%@include file="./pageLayout/navigation.jsp"%>

	<!-- Page Content -->
	<c:if test="${homePageClicked == true }">
		<%@include file="home.jsp"%>
	</c:if>

	<c:if test="${aboutPageClicked == true }">
		<%@include file="about.jsp"%>
	</c:if>

	<c:if test="${contactPageClicked == true }">
		<%@include file="contact.jsp"%>
	</c:if>

	<c:if
		test="${categoryPageClicked == true or allItemsPageClicked == true}">
		<%@include file="allItems.jsp"%>
	</c:if>

	<c:if test="${showItemDetailClicked == true}">
		<%@include file="itemDetails.jsp"%>
	</c:if>

	<c:if test="${manageItemsClicked == true}">
		<%@include file="manageitems.jsp"%>
	</c:if>

   <c:if test="${shoppingCartClicked == true}">
  		<%@include file="shoppingcart.jsp" %>
   </c:if>
   
   <c:if test="${checkoutClicked == true}">
  		<%@include file="stripe.jsp" %>
   </c:if>
   
      
   <c:if test="${showOrdersClicked == true}">
  		<%@include file="myorders.jsp" %>
   </c:if>
   


	<!-- Footer -->
	<%@include file="./pageLayout/footer.jsp"%>



	<!-- jQuery -->
	<script src="${javascript}/jquery.js"></script>
	<script src="${javascript}/jquery.validate.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${javascript}/bootstrap.min.js"></script>

	<!-- DataTable Plugin -->
	<script src="${javascript}/jquery.dataTables.js"></script>

	<!-- DataTable Bootstrap Script -->
	<script src="${javascript}/dataTables.bootstrap.js"></script>

	<!-- DataTable Bootstrap Script -->
	<script src="${javascript}/bootbox.min.js"></script>
	<script src="${javascript}/mywebsite.js"></script>

</body>

</html>
