package com.digitalhouse.checkout.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalhouse.checkout.model.dto.Product;

@FeignClient(name ="products-service")
public interface FeignProductRepository {
	
	@RequestMapping(method= RequestMethod.GET,value ="/products")
	Product getProductById(@RequestParam String id,@RequestParam Boolean throwError);

}
