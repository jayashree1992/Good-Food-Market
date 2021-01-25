
<div class="container">
	<div class="row">
		
		<div class="col-md-3">
		<%@include file="./pageLayout/aside.jsp" %>
		</div>
			
		<div class="col-md-9">
			<div class="row">
			
	
				<div class="col-lg-12">
				
					<c:if test="${allItemsPageClicked == true}">
					
					<script>
						
						window.categoryId = '';
					
					</script>
					
					<ol class="breadcrumb">
						<li><a href="${localURL}/home">Home</a></li>
						<li class="active">All Items</li>
					</ol>
					
					</c:if>
					
					
					<c:if test="${categoryPageClicked == true}">
					
					
					<script>
						
						window.categoryId = '${category.id}';
					
					</script>
					
					<ol class="breadcrumb">
						<li><a href="${localURL}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					</ol>
					
					</c:if>
					
					
							<div>
						
						<table id="items_tbl" class="table table-striped table-bordered">
				

							<thead>
							
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Available Quantity</th>
									<th></th>
							
								</tr>
							
							</thead>
							
						
							
						
						</table>
						
					
					
					</div>
					
					
				</div>
			</div>
		</div>
		
				
			
		
	</div>
</div>


