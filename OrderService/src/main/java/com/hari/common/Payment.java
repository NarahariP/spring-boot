package com.hari.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {

	private double amount;
	private int orderId;
	private int paymentId;
	private String paymentStatus;
	private String transactionId;
}
