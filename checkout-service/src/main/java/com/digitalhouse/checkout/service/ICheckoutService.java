package com.digitalhouse.checkout.service;

import java.util.List;

import com.digitalhouse.checkout.model.Checkout;

public interface ICheckoutService {
	
	public Checkout buildCheckout(List<String> productIds);

}
