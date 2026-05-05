package com.umfrancisco.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.umfrancisco.model.Order;
import com.umfrancisco.model.OrderItem;
import com.umfrancisco.model.Product;
import com.umfrancisco.model.dto.OrderItemRequest;
import com.umfrancisco.model.dto.OrderItemResponse;
import com.umfrancisco.model.dto.OrderRequest;
import com.umfrancisco.model.dto.OrderResponse;
import com.umfrancisco.repository.OrderRepository;
import com.umfrancisco.repository.ProductRepository;

@Service
public class OrderService {
	
	private ProductRepository productRepository;
	private OrderRepository orderRepository;
	
	public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
		this.productRepository = productRepository;
		this.orderRepository = orderRepository;
	}
	
	public OrderResponse placeOrder(OrderRequest request) {
		Order order = new Order();
		String orderId = UUID.randomUUID().toString().substring(0,8).toUpperCase();
		order.setOrderId(orderId);
		order.setCustomerName(request.customerName());
		order.setEmail(request.email());
		order.setStatus("PLACED");
		order.setOrderDate(LocalDate.now());
		
		List<OrderItem> items = new ArrayList<>();
		for (OrderItemRequest itemReq : request.items()) {
			Product product = productRepository.findById(itemReq.productId())
					.orElseThrow(() -> new RuntimeException("Product not found"));
			product.setStockQuantity(product.getStockQuantity() - itemReq.quantity());
			
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setQuantity(itemReq.quantity());
			orderItem.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemReq.quantity())));
			orderItem.setOrder(order);
			
			items.add(orderItem);
		}
		
		order.setOrderItems(items);
		Order savedOrder = orderRepository.save(order);
		
		List<OrderItemResponse> itemResponses = new ArrayList<>();
		for (OrderItem item : order.getOrderItems()) {
			OrderItemResponse orderItemResponse = new OrderItemResponse(
					item.getProduct().getName(),
					item.getQuantity(),
					item.getTotalPrice());
			itemResponses.add(orderItemResponse);
		}
		
		OrderResponse orderResponse = new OrderResponse(
				savedOrder.getOrderId(), 
				savedOrder.getCustomerName(), 
				savedOrder.getEmail(), 
				savedOrder.getStatus(), 
				savedOrder.getOrderDate(), 
				itemResponses);
		return orderResponse;
	}
	
	public List<OrderResponse> getAllOrderResponses() {
		return null;
	}
}
