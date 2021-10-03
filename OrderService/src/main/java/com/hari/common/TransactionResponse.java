package com.hari.common;

import com.hari.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponse {

	private double amount;
	private String messaage;
	private Order order;
	private String transactionId;
}
