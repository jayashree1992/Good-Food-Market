<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">

	<div class="row">




		<div class="col-md-12" style="width: 110%; margin-bottom: 20px;">

			<img src="${images}/grocery_banner.jpg" style="max-width: 100%;">

		</div>

		<div class="row">

			<c:forEach items="${homeItems}" var="item">
				<%-- 			<a href="${localURL}/view/${item.id}/item"> --%>
				<div class="col-lg-3 col-md-6 mb-3">
					<div class="card h-100">
						<img class="card-img-top"
							src="${localURL}/files/images/${item.itemcode}.jpg" alt="">
						<div class="card-body" style="text-align: center">
							<h4 class="card-title">
								${item.name} - <span style="font-size: 15px">$
									${item.perunitprice}</span>
							</h4>
							<p class="card-text">${item.description}</p>
							<%-- 		<a href="${localURL}/cart/add/${item.id}/item" class="btn btn-success">
			<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a> --%>
										<a href="${localURL}/view/${item.id}/item" class="btn btn-info">
								<span class="glyphicon glyphicon-eye-open"></span> View
							</a>


						</div>
					</div>
				</div>
				<!-- 		</a> -->

			</c:forEach>

		</div>


	</div>


</div>


