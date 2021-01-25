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
	
	<meta name="_csrf" content="${_csrf.token}">
	<meta name="_csrf_header" content="${csrf.headerName}">
	

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

	<div class="wrapper">

	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${localURL}/home">Home</a>
	            </div>
			</div>
		</nav>
			
		
		<div class="content">
		
			<div class="container">
			
				<div class="row">
				
					<div class="col-xs-12">
					
						
						<div class="jumbotron">
						
							<h1>${errorTitle}</h1>
							<hr/>
						
							<blockquote style="word-wrap:break-word">
								
								${errorDescription}
							
							</blockquote>						
						
						</div>
						
											
					</div>					
				
				</div>
			
			</div>
							
		</div>

		
	<%@include file="./pageLayout/footer.jsp" %>

	</div>
		
	
</body>


</html>