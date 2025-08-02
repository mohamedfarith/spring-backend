package com.learning.ecommerceapp.ecommerceapp.dto

data class OrderItemRequest(
    val productId: Long,
    val quantity: Int
)