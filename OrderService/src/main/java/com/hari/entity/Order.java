package com.hari.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_TB")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

	private double amount;
	@Id
	private int id;
	private String name;
	private int qty;
}
