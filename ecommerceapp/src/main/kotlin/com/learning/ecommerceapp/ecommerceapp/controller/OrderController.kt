package com.learning.ecommerceapp.ecommerceapp.controller

import com.learning.ecommerceapp.ecommerceapp.dto.OrderRequest
import com.learning.ecommerceapp.ecommerceapp.dto.OrderResponse
import com.learning.ecommerceapp.ecommerceapp.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService : OrderService) {

    @PostMapping
    fun placeOrder(@RequestBody request: OrderRequest): ResponseEntity<OrderResponse> {
        return ResponseEntity.ok(orderService.placeOrder(request))
    }

    @GetMapping("/user/{userId}")
    fun getOrdersByUser(@PathVariable userId: Long): ResponseEntity<List<OrderResponse>> {
        val orders = orderService.getOrdersByUser(userId)
        return ResponseEntity.ok(orders)
    }
}