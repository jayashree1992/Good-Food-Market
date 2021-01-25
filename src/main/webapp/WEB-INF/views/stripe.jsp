<link href="${stylesheet}/stripe.css" rel="stylesheet">
<script src="https://js.stripe.com/v3/"></script>
<form action="//httpbin.org/post" method="POST">
	<input type="hidden" name="token" />
	<div class="group">
		<label> <span>Card number</span>
			<div id="card-number-element" class="field"></div>
		</label> <label> <span>Expiry date</span>
			<div id="card-expiry-element" class="field"></div>
		</label> <label> <span>CVC</span>
			<div id="card-cvc-element" class="field"></div>
		</label> <label> <span>Postal code</span> <input id="postal-code"
			name="postal_code" class="field"
			placeholder="Regular field placeholder" />
		</label>
	</div>
	<button type="submit">Pay $25</button>
	<div class="outcome">
		<div class="error"></div>
		<div class="success">
			Success! Your Stripe token is <span class="token"></span>
		</div>
	</div>
</form>