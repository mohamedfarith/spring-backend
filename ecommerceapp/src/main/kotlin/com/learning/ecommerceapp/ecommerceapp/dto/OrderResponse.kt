package com.learning.ecommerceapp.ecommerceapp.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class OrderResponse(
    val orderId: Long,
    val userId: Long,
    val createdAt: LocalDateTime,
    val totalAmount: BigDecimal,
    val items: List<OrderItemSummary>
)

data class OrderItemSummary(
    val productId: Long,
    val productName: String,
    val quantity: Int,
    val price: BigDecimal,
    val subtotal: BigDecimal
)