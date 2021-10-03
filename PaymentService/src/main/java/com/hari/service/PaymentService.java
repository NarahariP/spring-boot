package com.hari.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.entity.Payment;
import com.hari.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public Payment fetchOrderDetails(int orderId) {
		return paymentRepository.findByOrderId(orderId);
	}

	private String isPaymentProcessing() {
		return new Random().nextBoolean() ? "success" : "failed";
	}

	public Payment savePayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(isPaymentProcessing());
		return paymentRepository.save(payment);
	}
}
