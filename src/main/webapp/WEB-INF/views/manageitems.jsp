<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	<div class="row">
	
	<c:if test="${not empty exceptionName}">	
				
			<div class="col-xs-12">			
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					
					${successMsg}
					
				</div>				
			</div>

	</c:if>
		
		<div class="col-md-12">
		
			<div class="panel panel-primary">
			
				<div class="panel-heading">
				
					<h4>Manage Items</h4>
				</div>
				
				<div class="panel-body">
				
					<springform:form class="form-horizontal" modelAttribute="item" action="${localURL}/admin/manage/item" method="POST"
					enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Item Name</label>
							<div class="col-md-8">
								<springform:input type="text" path="name" id="name" class="form-control"
									placeholder="Item Name" />
								<!-- <em class="errormsg">Item name cannot be blank.</em> -->
								<springform:errors path="name" cssClass="errormsg" elements="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Brand Name</label>
							<div class="col-md-8">
								<springform:input type="text" path="brandname" id="brand" class="form-control"
									placeholder="Brand Name" />
									<springform:errors path="brandname" cssClass="errormsg" elements="em"/>
							</div>
						</div>
						
					
					
						
							<div class="form-group">
							<label class="control-label col-md-4" for="description">Description</label>
							<div class="col-md-8">
								<springform:textarea path="description" id="description" class="form-control"
									placeholder="Description"/>
								<springform:errors path="description" cssClass="errormsg" elements="em"/>
							</div>
							</div>
							
							<div class="form-group">
							<label class="control-label col-md-4" for="price">Per Unit Price</label>
							<div class="col-md-8">
								<springform:input type="number" path="perunitprice" id="price" class="form-control"
									placeholder="Per Unit Price" />
							<springform:errors path="perunitprice" cssClass="errormsg" elements="em"/>
							</div>
							</div>
							
						
							
							<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Available Quantity</label>
							<div class="col-md-8">
								<springform:input type="number" path="quantity" id="quantity" class="form-control"
									placeholder="Available Quantity" />
						
							
							</div>
							</div>
							
							
						<div class="form-group">
							<label class="control-label col-md-4" for="image">Upload Item Picture</label>
							<div class="col-md-8">
								<springform:input type="file" path="file" id="file" class="form-control"/>
								<springform:errors path="file" cssClass="errormsg" element="em"></springform:errors>
							
							</div>
						</div>
							
							<div class="form-group">
							<label class="control-label col-md-4" for="category">Category</label>
							<div class="col-md-8">
								<springform:select class="form-control" id="category" path="categoryId"
								items="${categories}" itemLabel="name" itemValue="id"/>
							
								<c:if test="${item.id == 0}">
								
								<br/>
								<button type="button" data-toggle="modal" data-target="#add_category"
								class="btn btn-warning btn-xs " style="float:right"
								>Add new category</button>
								
								</c:if>
							
							</div>
							</div>
					
					
							<div class="form-group">
					
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" class="btn btn-primary"
									value="Submit" />
									
								    <springform:hidden path="id"/>
									<springform:hidden path="itemcode"/>
									<springform:hidden path="supplierId"/>
									<springform:hidden path="active"/>	
									<springform:hidden path="sold"/>	
									<springform:hidden path="no_of_people_viewed"/>	
						
							</div>
						</div>
						
										
					</springform:form>

				</div>

	
										
				</div>
			
			
			</div>
		
	
	
	</div>
	
	
	<div class="row" style="margin-left:100px;margin-right:auto;text-align:center">
				
		
		<div>
		
		
		<h3>Items Available</h3>
		<hr/>
		
		
		</div>
		
		<div >
		
			<div style="overflow:auto">
			
				<table id="tbl_items" class="table table-striped table-bordered" style="width:100%">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand Name</th>
						<th>Available Quantity</th>
						<th>Per Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
				

				
							
			</table>
			
			
			</div>
		
		</div>
	
	
	</div>


	<div class="row">
	<div class="modal fade" id="add_category" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header"> 
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
				<springform:form id="form_category" modelAttribute="category" action="${localURL}/admin/manage/category" method="POST">
					
					
				<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8 validate">
						<springform:input type="text" path="name" id="category_name" class="form-control"
							placeholder="Category Name" /> 
					</div>
				</div>
       			
       			<div class="form-group">				
					<label class="control-label col-md-4">Description</label>
					<div class="col-md-8 validate">
						<springform:textarea cols="" rows="5" path="description" class="form-control" id="category_description"
							placeholder="Enter description" /> 
					</div>
				</div>	        	        
	        
	        
				<div class="form-group">				
					<div class="col-md-offset-4 col-md-4">					
						<input type="submit" name="submit" value="Add Category" class="btn btn-primary"/>						
					</div>
				</div>
					
				</springform:form>
					
				</div>
			</div>
		
		</div>
	</div>
	</div>

</div>