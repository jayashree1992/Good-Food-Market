<div class="container">

<row>

	
	<c:choose>
		<c:when test="${not empty ordersList}">
		
		<table id="cart" class="table table-hover table-condensed" >
		<thead>
					<tr class="accordion-toggle">
						<th style="width:15%">Order Id</th>
						<th style="width:15%">Price</th>
						<th style="width:40%">Date</th>
						<th style="width:15%"></th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ordersList}" var="order">
			
					
					<tr>
						<td data-th="Product">
							
						 ${order.getId()}
									

						</td>
						
						<td data-th="Subtotal" class="text-left"> &#36; ${order.total}</td>
						<td data-th="Price"> ${order.createdOn}</td> 	
						
												
					 <td><a href="${localURL}/view/myorders?order_id=${order.id}" class="btn btn-success btn-block">View Details </a></td>
					</tr>
					</c:forEach>
				</tbody>
		
				</table>
		
		
		</c:when>
		
		<c:otherwise>
			
			<div class="jumbotron">
				
				<h3 class="text-center">Your Cart is Empty!</h3>
			
			</div>
		
		</c:otherwise>
	</c:choose>

</row>
</div>

<div class="container">
<row>

	<c:choose>
		<c:when test="${not empty orderItems}">

			<table id="cart" class="table table-hover table-condensed">
			   	<thead>
					<tr>
						<th style="width:50%">Product</th>
						<th style="width:10%">Price</th>
						<th style="width:8%">Quantity</th>
						<th style="width:22%" class="text-center">Subtotal</th>
			
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderItems}" var="orderItem">
				
					
					<tr>
						<td data-th="Product">
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img src="${images}/${orderItem.item.itemcode}.jpg" alt="${orderItem.item.name}" class="img-responsive dataTableImg shoppingCart"/></div>
								<div class="col-sm-10">
									<h4 class="nomargin">${orderItem.item.name} 
									</h4>
									<p>Brand : ${orderItem.item.brandname}</p>
									<p>Description : ${orderItem.item.description}</p>
								</div>
							</div>
						</td>
						<td data-th="Price"> &#36; ${orderItem.price} /-</td>
						<td data-th="Quantity">
							${orderItem.quantity}
						</td>
						<td data-th="Subtotal" class="text-center"> &#36; ${orderItem.itemTotal()}</td>
	
					</tr>
					</c:forEach>
				</tbody>
</table>

	
		
		</c:when>
		
		<c:otherwise>
			
			<div>
				
	
			
			</div>
		
		</c:otherwise>
	</c:choose>

<row>
</div>
