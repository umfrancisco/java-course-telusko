package com.umfrancisco.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Product product;
	private int quantity;
	private BigDecimal totalPrice;
	@ManyToOne(fetch=FetchType.LAZY)
	private Order order;
	
	public OrderItem() {
		
	}
	
	public OrderItem(int id, Product product, int quantity, BigDecimal totalPrice, Order order) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.order = order;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", product=" + product + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ ", order=" + order + "]";
	}
}
