package com.learning.ecommerceapp.ecommerceapp.dto

data class OrderRequest(
    val userId: Long,
    val items: List<OrderItemRequest>
)