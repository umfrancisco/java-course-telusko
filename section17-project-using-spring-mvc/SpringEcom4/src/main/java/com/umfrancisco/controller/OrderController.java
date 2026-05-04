package com.umfrancisco.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.model.dto.OrderRequest;
import com.umfrancisco.model.dto.OrderResponse;
import com.umfrancisco.service.OrderService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {
	
	private OrderService service;
	
	public OrderController(OrderService service) {
		this.service = service;
	}
	
	@PostMapping("/orders/place")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
		OrderResponse orderResponse = service.placeOrder(orderRequest);
		return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponse>> getAllOrders() {
		List<OrderResponse> responses = service.getAllOrderResponses();
		return new ResponseEntity<>(responses, HttpStatus.OK);
	}
}
