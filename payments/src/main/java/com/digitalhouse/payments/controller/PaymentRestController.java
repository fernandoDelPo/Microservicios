package com.digitalhouse.payments.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.digitalhouse.payments.model.Payment;
import com.digitalhouse.payments.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/payments")
@RestController
public class PaymentRestController {
    
    
    private PaymentService paymentService;
    
    Logger log = LoggerFactory.getLogger(PaymentRestController.class);

    public PaymentRestController(PaymentService paymentService) {
        super();
        this.paymentService = paymentService;
    }
    
    @GetMapping()
    public Payment getPayment(String id) {
        log.info("Intentando obtener payment con id: "+id +" ....");
        
        // utilizar un servicio
        log.error("Error al obtener un payment");
        
        return new Payment(id, 400.f, "id1", "id2");
    }

   
    
    @PostMapping()
    public void createPayment(@RequestBody Payment payment){
        paymentService.createPayment(payment);
        
    }
    
}
