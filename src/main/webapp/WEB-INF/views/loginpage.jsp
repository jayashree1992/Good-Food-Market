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

	<div class="wrapper">

		<!-- Navigation -->
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	           
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${localURL}/home">Good Food Markets</a>
	            </div>
			</div>
		</nav>		

		<!-- Page Content -->

		<div class="content" style="margin-top:100px;">
			
   <div class="container">
    
	<c:if test="${not empty message}">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<div class="alert alert-danger fade in">${message}</div>
			</div>
		</div>
	</c:if>
         
<c:if test="${not empty logout}">
		<div class="row">
				<div class="col-md-offset-3 col-md-6">
				<div class="alert alert-success">${logout}</div>
			</div>
		</div>
	</c:if> 
        
    <div class="row" >
     
     <div class="col-md-offset-3 col-md-6">
      
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <h4>Login</h4>
       </div>
       
       <div class="panel-body" >
        <form action="${localURL}/login" method="POST" class="form-horizontal"
         id="frm_login" 
        >
         <div class="form-group">	
          <label for="username" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">
           <input type="text" name="username" id="username" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
           <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
           <input type="submit" value="Login" class="btn btn-primary"/>
          </div>
         </div>
        </form>
       
       </div>
       <div class="panel-footer">
       	<div class="text-right">
       		New User - <a href="${localURL}/register">Register Here</a>
       	</div>
       </div>
      
      </div> 
    
     </div>
     
    </div>    
   
   </div>

			
		</div>
		
				</div>
		

  <!-- Footer -->
<%@include file="./pageLayout/footer.jsp" %>


  
  	<!-- jQuery -->
		<script src="${javascript}/jquery.js"></script>

		<script src="${javascript}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${javascript}/bootstrap.min.js"></script>
		
	

  
  <script src="${javascript}/mywebsite.js"></script>

</body>

</html>
