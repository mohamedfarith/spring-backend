package com.learning.ecommerceapp.ecommerceapp.dto

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val orderItems: List<OrderItem> = emptyList(),

    val createdAt: LocalDateTime = LocalDateTime.now()
)

fun Order.toOrderResponse(): OrderResponse {
    return OrderResponse(
        orderId = id,
        createdAt = createdAt,
        totalAmount = orderItems.sumOf { it.product.price },
        items = orderItems.map { it.toOrderItemSummary() }, userId = user.id
    )
}