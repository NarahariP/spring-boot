package com.hari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hari.common.Payment;
import com.hari.common.TransactionRequest;
import com.hari.common.TransactionResponse;
import com.hari.entity.Order;
import com.hari.repository.OrderRepository;

@Service
@RefreshScope
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	// @Value(value = "${microservice.payment-service.endpoint.uri}")
	private String PAYMENT_ENDPOINT_URL = "http://PAYMENT-SERVICE/payment/doPayment";

	@Autowired
	private RestTemplate restTemplate;

	public TransactionResponse bookOrder(TransactionRequest request) {
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getAmount());
		Payment paymentResp = restTemplate.postForObject(PAYMENT_ENDPOINT_URL, payment, Payment.class);
		String resp = paymentResp.getPaymentStatus().equals("success")
				? "payment processed successfully and order placed."
				: "these is failure in payment, order added back to cart";
		orderRepository.save(order);
		return new TransactionResponse(paymentResp.getAmount(), resp, order, paymentResp.getTransactionId());
	}

}
