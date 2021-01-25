
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${localURL}/home">Good Food Markets</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item" id="home">
            <a class="nav-link" href="${localURL}/home">Home</a>
          </li>
          <li class="nav-item" id="about">
            <a class="nav-link" href="${localURL}/about">About Us</a>
          </li>
          <li class="nav-item" id="allItems">
            <a class="nav-link" href="${localURL}/view/allItems">View All Items</a>
          </li>
         
          
          	<security:authorize access="hasAuthority('ADMIN')">
          <li class="nav-item" id="manageitem">
            <a class="nav-link" href="${localURL}/admin/manage/item">Manage Items</a>
          </li>
          		</security:authorize>
          
          
          
        
        
          	<security:authorize access="hasAuthority('USER')">
          <li class="nav-item" id="myorders">
            <a class="nav-link" href="${localURL}/view/myorders">My Orders</a>
          </li>
          		</security:authorize>
          		
          		  
       <%--    <li class="nav-item" id="contact">
            <a class="nav-link" href="${localURL}/contact">Contact Us</a>
          </li> --%>
          
          			    
			  
         
          
          
        </ul>
        
          <ul class="nav navbar-nav navbar-right">
			    	
			    		<security:authorize access="isAnonymous()">
	                    <li id="register">
	                        <a href="${localURL}/register">Register</a>
	                    </li>
						<li id="login">
	                        <a href="${localURL}/login">Login</a>
	                    </li> 	
	                    
	                     	</security:authorize>
			    	<security:authorize access="isAuthenticated()">
	                    
	                     <li class="dropdown" id="shoppingcart">
				            <a href="javascript:void(0)" class="btn btn-default dropdown-toggle" id="dropdownmenu1"
				            data-toggle="dropdown">
				            ${modelUser.fullname}
				           
				            
				            </a>
				            
				            <ul class="dropdown-menu">
				            
				              <security:authorize access="hasAuthority('USER')">
				            	<li>
				            	
				            		<a href="${localURL}/cart/show">
				            		<span class="glyphicon glyphicon-shopping-cart"></span>
				            		<span class="badge">${modelUser.cart.cartLines}</span>
				            		- &#38; ${modelUser.cart.total}
				            		</a>
				            	
				            	</li>
				            	
				            	<li class="divider" role="separator"></li>
				            	
				            	       </security:authorize>
				            	
				            	<li> <a  href="${localURL}/do-logout">Logout</a></li>
				            	
				            </ul>
				            
				          </li> 		    	
			    
		                	</security:authorize>          			    	
				 </ul>		
			
      </div>
    </div>
  </nav>
  
  <script>
		window.userRole = '${modelUser.role}';
	</script>