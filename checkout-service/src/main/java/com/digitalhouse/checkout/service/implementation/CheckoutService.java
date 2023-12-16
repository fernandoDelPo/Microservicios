package com.digitalhouse.checkout.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalhouse.checkout.model.Checkout;
import com.digitalhouse.checkout.model.dto.Product;
import com.digitalhouse.checkout.service.ICheckoutService;
import com.digitalhouse.checkout.service.IProductService;

@Service
public class CheckoutService implements ICheckoutService{
	
	private IProductService productService;
	
	

	public CheckoutService(IProductService productService) {

		this.productService = productService;
	}



	@Override
	public Checkout buildCheckout(List<String> productIds) {
		Double total = 0.0;
		for(String id :  productIds){
			Product product = productService.getProduct(id);
			System.out.println("Respuesta desde "+product.getInstance());
			total += product.getPrice();
		}
		Checkout checkout = new Checkout("234","www.digitalhouse.com/checkout?code=234",total.toString(),List.of("credit_card"));
	
		
		return checkout;
	}


	

}
