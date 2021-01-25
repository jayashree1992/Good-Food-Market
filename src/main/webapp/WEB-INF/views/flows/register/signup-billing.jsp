<%@include file="../shared/flows-header.jsp" %>


<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>			
	<div class="container">
		
		<br>
		<br>
		<br>
		<br>
		<br>
		
		<div class="row">
			
			<div class="col-md-6 col-md-offset-3">
				
				<div class="panel panel-primary">
				
					<div class="panel-heading">
						<h4>Sign Up - Address</h4>
					</div>
					
					<div class="panel-body">
										
						<springform:form
							method="POST"
							modelAttribute="billing"
							class="form-horizontal"
							id="Frm_billing"
						>
						
							
							<div class="form-group">
								<label class="control-label col-md-4">Address Line One</label>
								<div class="col-md-8">
									<springform:input type="text" path="locationLineOne" class="form-control"
										placeholder="Address Line One" />
									<springform:errors path="locationLineOne" cssClass="errormsg" element="em"/> 
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" >Address Line Two</label>
								<div class="col-md-8">
									<springform:input type="text" path="locationLineTwo" class="form-control"
										placeholder="Address Line Two" />
									<springform:errors path="locationLineTwo" cssClass="errormsg" element="em"/> 
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="city">City</label>
								<div class="col-md-8">
									<springform:input type="text" path="city" class="form-control"
										placeholder="City Name" />
									<springform:errors path="city" cssClass="errormsg" element="em"/> 
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Postal Code</label>
								<div class="col-md-8">
									<springform:input type="text" path="zip" class="form-control"
										placeholder="XXXXX" />
									<springform:errors path="zip" cssClass="errormsg" element="em"/> 
								</div>
							</div>							
						
							<div class="form-group">
								<label class="control-label col-md-4">State</label>
								<div class="col-md-8">
									<springform:input type="text" path="state" class="form-control"
										placeholder="State Name" />
									<springform:errors path="state" cssClass="errormsg" element="em"/> 
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Country</label>
								<div class="col-md-8">
									<springform:input type="text" path="country" class="form-control"
										placeholder="Enter Country Name" />
									<springform:errors path="country" cssClass="errormsg" element="em"/> 
								</div>
							</div>
							
							
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<button type="submit" name="_eventId_personal" class="btn btn-primary">
										<span class="glyphicon glyphicon-chevron-left"></span> Back - Registeration
									</button>								
									<button type="submit" name="_eventId_confirm" class="btn btn-primary">
										Next - Confirm<span class="glyphicon glyphicon-chevron-right"></span>
									</button>																	 
								</div>
							</div>
						<br>
						<br>
						
						</springform:form>					
					
					
					</div>
				
				
				</div>
			
			
			</div>
		
		
		</div>
		
		
	</div>

<%@include file="../shared/flows-footer.jsp" %>	