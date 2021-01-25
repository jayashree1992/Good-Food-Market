<div class="container">


	<c:if test="${not empty message}">
		
		<div class="alert alert-info">
			<h3 class="text-center">${message}</h3>
		</div>		
	
	</c:if>
	 
	<c:choose>
		<c:when test="${not empty cartDetail}">
			<table id="cart" class="table table-hover table-condensed">
			   	<thead>
					<tr>
						<th style="width:50%">Product</th>
						<th style="width:10%">Price</th>
						<th style="width:8%">Quantity</th>
						<th style="width:22%" class="text-center">Subtotal</th>
						<th style="width:10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartDetail}" var="cartDetail">
					<c:if test="${cartDetail.available == false}">
						<c:set var="availableCount" value="${availableCount - 1}"/>
					</c:if>
					
					<tr>
						<td data-th="Product">
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img src="${images}/${cartDetail.item.itemcode}.jpg" alt="${cartDetail.item.name}" class="img-responsive dataTableImg shoppingCart"/></div>
								<div class="col-sm-10">
									<h4 class="nomargin">${cartDetail.item.name} 
										<c:if test="${cartDetail.available == false}">
											<strong class="notavail">(Not Available)</strong> 
										</c:if>
									</h4>
									<p>Brand : ${cartDetail.item.brandname}</p>
									<p>Description : ${cartDetail.item.description}</p>
								</div>
							</div>
						</td>
						<td data-th="Price"> &#36; ${cartDetail.buyingPrice} /-</td>
						<td data-th="Quantity">
							<input type="number" name="refcart" id="count_${cartDetail.id}" class="form-control text-center" value="${cartDetail.itemCount}" min="1" max="5">
						</td>
						<td data-th="Subtotal" class="text-center"> &#36; ${cartDetail.total}</td>
						
						
						<td class="actions" data-th="">
<%-- 							<c:if test="${cartDetail.available == true}">
								<button type="button" name="cartRef" class="btn btn-info btn-sm" value="${cartDetail.id}"><span class="glyphicon glyphicon-refresh"></span></button>
							</c:if>	 --%>											
							<a href="${localURL}/cart/${cartDetail.id}/delete" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>								
						</td>
						
						
						
					</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total &#36; ${userModel.cart.total}</strong></td>
					</tr>
					<tr>
						<td><a href="${localURL}/view/allItems" class="btn btn-warning"><span class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total &#36; ${modelUser.cart.total}</strong></td>
						
					 <td><a href="${localURL}/cart/${modelUser.cart.id}/checkout" class="btn btn-success btn-block">Checkout <span class="glyphicon glyphicon-chevron-right"></span></a></td>
						
							
									
					</tr>
				</tfoot>
			</table> 
		
		</c:when>
		
		<c:otherwise>
			
			<div class="jumbotron">
				
				<h3 class="text-center">Your Cart is Empty!</h3>
			
			</div>
		
		</c:otherwise>
	</c:choose>

</div>
