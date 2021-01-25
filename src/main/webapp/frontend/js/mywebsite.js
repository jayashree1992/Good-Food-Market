$(function() {

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Items':
		$('#allItems').addClass('active');
		break;

	case 'Manage Items':
		$('#manageitem').addClass('active');
		break;

	case 'Shopping Cart':
		$('#shoppingcart').addClass('active');
		break;

	case 'My Orders':
		$('#myorders').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#allItems').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');

	if ((token && header && token.length > 0 && header.length > 0)) {

		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}

	var $table = $('#items_tbl');

	if ($table.length) {
		var jsonUrl = '';

		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/view/allItems';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/items';
		}

		$table
				.DataTable({

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'All' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [

							{
								data : 'itemcode',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/files/images/' + data
											+ '.jpg" class="picture"/>';

								}
							},
							{
								data : 'name'

							},

							{
								data : 'brandname'
							},

							{
								data : 'perunitprice',
								mRender : function(data, type, row) {
									return data + '&dollar;'
								}
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:#F67A59">Currently Unavailable!</span>';
									} else {
										return data;
									}

								}
							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var url = '';
									url += '<a href="'
											+ window.contextRoot
											+ '/view/'
											+ data
											+ '/item" class="btn btn-primary"> <span class="glyphicon glyphicon-eye-open"></span> </a>';

									if (userRole == 'ADMIN') {

										url += '<a href="'
												+ window.contextRoot
												+ '/admin/'
												+ data
												+ '/item" class="btn btn-warning"> <span class="glyphicon glyphicon-pencil"></span> </a>';

									} else {
										if (row.quantity < 1) {
											url += '<a href="javascript:void(0)" class="btn btn-success disabled"> <span class="glyphicon glyphicon-shopping-cart"></span> </a>';

										} else {

											url += '<a href="'
													+ window.contextRoot
													+ '/cart/add/'
													+ data
													+ '/item" class="btn btn-success"> <span class="glyphicon glyphicon-shopping-cart"></span> </a>';
										}

									}

									return url;

								}
							}

					]

				});

	}

	alr = $('.alert');
	if (alr.length) {
		setTimeout(function() {
			alr.fadeOut('slow');
		}, 3000);
	}

	var $adminItemTable = $('#tbl_items');

	if ($adminItemTable.length) {

		var jsonUrl = window.contextRoot + '/json/data/admin/view/allItems';
		console.log(jsonUrl);

		$adminItemTable
				.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},

							{
								data : 'itemcode',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/files/images/' + data
											+ '.jpg" class="item_crud_img"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brandname'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:#F67A59">Currently Unavailable!</span>';
									}

									return data;

								}
							},
							{
								data : 'perunitprice',
								mRender : function(data, type, row) {
									return data + '&#36;'
								}
							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var urli = '';

									urli += '<label class="activate_deactivate">';

									if (data) {
										urli += '<input type="checkbox" checked="checked" value="'
												+ row.id + '"/>';

									} else {
										urli += '<input type="checkbox" value="'
												+ row.id + '"/>';
									}

									urli += '<div class="glide"></div></label>';

									return urli;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var urli = '';
									urli += '<a href=" '
											+ window.contextRoot
											+ '/admin/'
											+ data
											+ '/item" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';

									return urli;
								}
							} ],

					initComplete : function() {

						var api = this.api();

						api
								.$(
										'.activate_deactivate input[type="checkbox"]')
								.on(
										'change',
										function() {

											var box = $(this);
											var checked_unchecked = box
													.prop('checked');
											var message = (checked_unchecked) ? 'Do you want to activate the item?'
													: 'Do you want to deactivate the item?';
											var val = box.prop('value');

											bootbox
													.confirm({

														size : 'medium',
														title : 'Item Activation and Deactivation',
														message : message,
														callback : function(
																confirmed) {
															if (confirmed) {
																console
																		.log(val);

																var urlActive = window.contextRoot
																		+ '/admin/manage/item/'
																		+ val
																		+ '/active';

																$
																		.post(
																				urlActive,
																				function(
																						data) {

																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data
																							});
																				});

															} else {
																box
																		.prop(
																				'checked',
																				!checked_unchecked);
															}
														}

													});

										});

					}

				});

	}
	
	$.validator.addMethod("regx", function(value, element, regexpr) {          
	    return regexpr.test(value);
	}, "Letters Only");
	
	$.validator.addMethod("reg", function(value, element, regexpr) {          
	    return regexpr.test(value);
	}, "Please enter a valid phone number");
	
	
	$.validator.addMethod("re", function(value, element, regexpr) {          
	    return regexpr.test(value);
	}, "Password must be must be eight characters or longer");


	
	
	var registerationForm = $('#form_registration');

	if (registerationForm.length) {

		registerationForm.validate({
			rules : {
				firstname : {
					required: true,
					regx: /^[a-zA-Z\s]+$/
				},
				lastname : {
					required: true,
					regx: /^[a-zA-Z\s]+$/
				},
				email : {
					required: true,
					email:true
				},
				contactnumber :{
					reg:/^[1-9]\d{9}$/
				},
				password:{
					re: /(?=.{8,})/
				}
				
			},
			messages : {
				firstname : {
					
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				error.addClass('errormsg');
				error.insertAfter(element);

			}
		}

		);
		
		
		

	}

	var validateCategory = $('#form_category');

	if (validateCategory.length) {

		validateCategory
				.validate({
					rules : {
						name : {
							required : true,
							minlength : 2,

						},
						description : {
							required : true,

						}
					},
					messages : {
						name : {
							required : 'Please add the category name!',
							minlength : 'The category name should not be less than 2 characters',

						},
						description : {
							required : 'Please enter description for category!',

						}
					},
					errorElement : "em",
					errorPlacement : function(error, element) {
						error.addClass('errormsg');
						error.insertAfter(element);

					}
				}

				);

	}

	var login = $('#frm_login');

	if (login.length) {

		login.validate({
			rules : {
				username : {
					required : true,
					email : true

				},
				password : {
					required : true
				}
			},
			messages : {
				username : {
					required : 'Please enter your email!',
					email : 'Please enter a valid email address!'
				},
				password : {
					required : 'Please enter your password!'
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {

				error.addClass("errormsg");

				error.insertAfter(element);
			}
		}

		);

	}

	$('input[name="refcart"]')
			.change(
					function() {

						var cartDetailId = $(this).attr('id').split('_')[1];
						var orgCount = $(this).attr('value');
						var currCount = $(this).val();

						if (currCount !== orgCount) {

							if (currCount < 1 || currCount > 5) {

								$(this).val(orgCount);
								bootbox
										.alert({
											size : 'medium',
											title : 'Error',
											message : 'Item Count should be minimum 1 and maximum 5!'
										});
							} else {

								var updateUrl = window.contextRoot + '/cart/'
										+ cartDetailId + '/update?count='
										+ currCount;
								window.location.href = updateUrl;
							}
						}
					});

});
