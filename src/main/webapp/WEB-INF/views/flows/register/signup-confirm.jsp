<%@include file="../shared/flows-header.jsp" %>

<div class="container">
		<br>
		<br>
		<br>
		<br>
		<br>
	<div class="row">
	
		<div class="col-sm-6">
	
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
					<h3>Name : <strong>${modelRegister.user.firstname} ${modelRegister.user.lastname}</strong></h3>
						<h4>Email : <strong>${modelRegister.user.email}</strong></h4>
						<h4>Contact : <strong>${modelRegister.user.contactnumber}</strong></h4>
						<h4>Role : <strong>${modelRegister.user.role}</strong></h4> 
						<p>
							<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>
			
			</div>
					
		
		</div>
		
		<div class="col-sm-6">
		
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Billing Address</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
					<p>${modelRegister.billing.locationLineOne}, </p>
						<p>${modelRegister.billing.locationLineTwo}, </p>
						<p>${modelRegister.billing.city} -  ${modelRegister.billing.zip}, </p>
						<p>${modelRegister.billing.state}</p>
						<p>${modelRegister.billing.country}</p> 
						<p>
							<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>
			
			</div>
		
		</div>
	
	</div>
	
	<div class="row">
		
		<div class="col-sm-4 col-sm-offset-4">
			
			<div class="text-center">
				
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">Confirm</a>
				
			</div>
			
		</div>
		
	</div>
<br>
<br>
</div>

<%@include file="../shared/flows-footer.jsp" %>	