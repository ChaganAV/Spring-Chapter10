package com.example.Chapter103.controller;

import com.example.Chapter103.model.ErrorDetails;
import com.example.Chapter103.model.NotEnoughMoneyException;
import com.example.Chapter103.model.PaymentDetails;
import com.example.Chapter103.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private final PaymentService paymentService;
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(){
        try{
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);

        }catch (NotEnoughMoneyException e){
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
    @PostMapping("/paydetails")
    public ResponseEntity<PaymentDetails> makeDetails(
            @RequestBody PaymentDetails paymentDetails){
        logger.info("Received payment " + paymentDetails.getAmount());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
