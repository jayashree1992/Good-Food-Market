<div class="container">

	<div class="row">
	
		<div class="col-xs-12">
			<ol class="breadcrumb">
			
				<li><a href="${localURL}/home">Home</a></li>
				<li><a href="${localURL}/view/allItems">All Items</a></li>
				
				<li class="active">${item.name}</li>
			
			</ol>
		</div>
			
	</div>
	
	
	<div class="row">
	
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				
				<img src="${images}/${item.itemcode}.jpg" class="img img-responsive"/>
				
			</div>
			
		</div>
		
		<div class="col-xs-12 col-sm-8">
			
			<h3>${item.name}</h3>
			<hr/>
			<p>${item.description}</p>
			<hr/>
			<h4>Price : <strong>${item.perunitprice} &dollar;</strong></h4>
			<hr/>
	
			
			<c:choose>
			<c:when test="${item.quantity <1}">
				
					<h6>Available Quantity : <span style="color:#F67A59">Currently Unavailable!</span></h6>
					
							
			</c:when>
			<c:otherwise>
					<h6>Available Quantity : ${item.quantity}</h6>
			</c:otherwise>
			</c:choose>
			
			
			<security:authorize access = "hasAuthority('USER')">
			<c:choose>
			<c:when test="${item.quantity <1}">
				
						<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
			<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</strike></a>
					
							
			</c:when>
			<c:otherwise>
			<a href="${localURL}/cart/add/${item.id}/item" class="btn btn-success">
			<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
			</c:otherwise>
			</c:choose>
			
			</security:authorize>
			
				
			<security:authorize access = "hasAuthority('ADMIN')">
				<a href="${localURL}/admin/${item.id}/item" class="btn btn-warning">
			<span class="glyphicon glyphicon-pencil"></span>Edit</a>
			
			</security:authorize>
		
			
			<a href="${localURL}/view/allItems" class="btn btn-primary">Back</a>
			
			
			
		</div>
			
	</div>

</div>