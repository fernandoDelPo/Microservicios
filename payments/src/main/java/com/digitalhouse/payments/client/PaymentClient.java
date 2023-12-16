package com.digitalhouse.payments.client;

import com.digitalhouse.payments.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentClient {
    
    public boolean createPayment(Payment payment){
        
        //Este servicio ejecuta una llamada a otro servicio externo  para crear el pago
        return true;        
    }
    
}
