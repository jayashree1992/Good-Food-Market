<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<spring:url var="stylesheet" value="/files/css"></spring:url>
<spring:url var="javascript" value="/files/js"></spring:url>
<spring:url var="images" value="/files/images"></spring:url>

<c:set var="localURL" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	

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


<%@include file="flows-navbar.jsp" %>

	<div class="content">