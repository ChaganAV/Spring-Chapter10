package com.example.Chapter103.services;

import com.example.Chapter103.model.NotEnoughMoneyException;
import com.example.Chapter103.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
