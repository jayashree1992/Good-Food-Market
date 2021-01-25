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
						<h4>Create a new Account</h4>
					</div>
					
					<div class="panel-body">
										
						<springform:form
							method="POST"
							modelAttribute="user"
							class="form-horizontal"
							id="form_registration"
						>
						
							
							<div class="form-group">
								<label class="control-label col-md-4">First Name</label>
								<div class="col-md-8">
									<springform:input type="text" path="firstname" class="form-control"
										placeholder="First Name" />
									<springform:errors path="firstname" cssClass="errormsg" element="em"/> 
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-md-4">Last Name</label>
								<div class="col-md-8">
									<springform:input type="text" path="lastname" class="form-control"
										placeholder="Last Name" />
									<springform:errors path="lastname" cssClass="errormsg" element="em"/> 
								</div>
							</div>
						
							<div class="form-group">
								<label class="control-label col-md-4">Email</label>
								<div class="col-md-8">
									<springform:input type="email" path="email" class="form-control"
										placeholder="abc@zyx.com" />
									<springform:errors path="email" cssClass="errormsg" element="em"/> 									
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Contact Number</label>
								<div class="col-md-8">
									<springform:input type="text" path="contactnumber" class="form-control"
										placeholder="XXXXXXXXXX" maxlength="10" />
									<springform:errors path="contactnumber" cssClass="errormsg" element="em"/> 
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Password</label>
								<div class="col-md-8">
									<springform:input type="password" path="password" class="form-control"
										placeholder="Password" />
									<springform:errors path="password" cssClass="errormsg" element="em"/> 
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Confirm Password</label>
								<div class="col-md-8">
									<springform:input type="password" path="confirmpassword" class="form-control"
										placeholder=" Re-Enter Password" />
									<springform:errors path="confirmpassword" cssClass="errormsg" element="em"/> 
								</div>
							</div>
							
					 
							
							<div class="form-group">
								<label class="control-label col-md-4">Select Role</label>
								<div class="col-md-8">
									<label class="radio-inline">
										<springform:radiobutton path="role" value="USER" checked="checked"/> User 				
									</label>
									<label class="radio-inline">
										<springform:radiobutton path="role" value="ADMIN"/> ADMIN
									</label>
								</div>
							</div>							

							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<button type="submit" name="_eventId_billing" class="btn btn-primary">
										Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
									</button>																	 
								</div>
							</div>
						
						
						</springform:form>					
					
					
					</div>
				
				
				</div>
			
			
			</div>
		
		
		</div>
		
		
	</div>

	
<%@include file="../shared/flows-footer.jsp" %>	
