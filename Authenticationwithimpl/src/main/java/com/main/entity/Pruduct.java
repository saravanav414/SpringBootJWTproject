package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "product") // Correct table name
public class Pruduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String productName; // Corrected field name
	private long price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Pruduct(long id, String productName, long price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public Pruduct() {
		super();
	}

	@Override
	public String toString() {
		return "Pruduct [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}

}