package com.digitalhouse.checkout.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.digitalhouse.checkout.model.dto.Product;
import com.digitalhouse.checkout.repository.FeignProductRepository;
import com.digitalhouse.checkout.service.IProductService;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ProductService implements IProductService {

    private FeignProductRepository feignProductRepository;

    Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(FeignProductRepository feignProductRepository) {
        super();
        this.feignProductRepository = feignProductRepository;
    }

    @Override
    @CircuitBreaker(name = "product", fallbackMethod = "getProductFallbackMethod")
    @Retry(name = "product")
    public Product getProduct(String id) {
        log.info("Intentando Obtener el producto con ID :" + id);
        return feignProductRepository.getProductById(id, false);
    }

    public Product getProductFallbackMethod(String id, CallNotPermittedException exception) {
        log.error("Circuit breaker en estado Open");

        return new Product();
    }

}
